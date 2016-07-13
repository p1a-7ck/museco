package com.epam.java.rt.museco.model.general;

import java.util.Date;

/**
 * Municipal Service Company
 * Should be used to store begin and expire dates for entity, which could be
 * defined to date values that ensured begin date will not after expire date.
 */
public final class Term implements Termable, Copyable {
    private final Date beginDate;
    private final Date expireDate;

    public Term() {
        this.beginDate = null;
        this.expireDate = null;
    }

    public Term(Date beginDate, Date expireDate) {
        if (beginDate == null && expireDate == null) {
            this.beginDate = null;
            this.expireDate = null;
        } else {
            if (beginDate == null) throw new IllegalArgumentException("Begin date should be defined first");
            if (expireDate == null) {
                this.beginDate = beginDate;
                this.expireDate = null;
            } else {
                if (beginDate.after(expireDate))
                    throw new IllegalArgumentException("Begin date should be before expire date");
                this.beginDate = beginDate;
                this.expireDate = expireDate;
            }
        }
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public Termable setBeginDate() {
        return new Term(new Date(), this.getExpireDate());
    }

    public Termable setBeginDate(Date beginDate) {
        return new Term(beginDate, this.getExpireDate());
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public Termable setExpireDate() {
        return new Term(this.getBeginDate(), new Date());
    }

    public Termable setExpireDate(Date expireDate) {
        return new Term(this.getBeginDate(), expireDate);
    }

    public boolean withinDate() {
        Date currentDate = new Date();
        return this.beginDate != null &&
                ((this.expireDate != null) ?
                        this.beginDate.before(currentDate) && this.expireDate.after(currentDate) :
                        this.beginDate.before(currentDate));
    }

    public boolean withinDate(Date checkDate) {
        return this.beginDate != null &&
                ((this.expireDate != null) ?
                        this.beginDate.before(checkDate) && this.expireDate.after(checkDate) :
                        this.beginDate.before(checkDate));
    }

    public void copyOf(Object o) {
        Termable anotherTerm = (Termable) o;
        this.setBeginDate(anotherTerm.getBeginDate());
        this.setExpireDate(anotherTerm.getExpireDate());
    }

    @Override
    public String toString() {
        return  "Term {" +
                "beginDate=" + this.beginDate +
                ", expireDate=" + this.expireDate +
                "}";
    }
}