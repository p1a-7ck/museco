package com.epam.java.rt.museco.model.general;

import java.util.Date;

/**
 * Municipal Service Company
 * Should be used to store begin and expire dates for entity, which could
 * be defined to date values that ensured begin date will before expire date.
 */
public class Term {
    private Date beginDate;
    private Date expireDate;

    public Term() {
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate() {
        this.setBeginDate(new Date());
    }

    public void setBeginDate(Date beginDate) {
        if (beginDate == null)
            throw new IllegalArgumentException("Begin date should be defined");
        else if (this.expireDate != null) if (!beginDate.before(this.expireDate))
            throw new IllegalArgumentException("Begin date should be before expire date");
        this.beginDate = beginDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate() {
        this.setExpireDate(new Date());
    }

    public void setExpireDate(Date expireDate) {
        if (this.beginDate == null)
            throw new IllegalArgumentException("Begin date should be defined first");
        else if (expireDate != null) if (!expireDate.after(this.beginDate))
            throw new IllegalArgumentException("Expire date should be after begin date");
        this.expireDate = expireDate;
    }

    public boolean isActive() {
        Date currentDate = new Date();
        return this.beginDate != null &&
                ((this.expireDate != null) ?
                        this.beginDate.before(currentDate) && this.expireDate.after(currentDate) :
                        this.beginDate.before(currentDate));
    }

    public boolean isActive(Date selectedDate) {
        return this.beginDate != null &&
                ((this.expireDate != null) ?
                        this.beginDate.before(selectedDate) && this.expireDate.after(selectedDate) :
                        this.beginDate.before(selectedDate));
    }

    public Term copyOf (Term term) {
        this.setBeginDate(term.getBeginDate());
        this.setExpireDate(term.getExpireDate());
        return this; // return Term for inline-code use
    }

    @Override
    public String toString() {
        return  "Term {" +
                "beginDate=" + this.beginDate +
                ", expireDate=" + this.expireDate +
                "}";
    }
}