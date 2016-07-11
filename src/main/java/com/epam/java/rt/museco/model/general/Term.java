package com.epam.java.rt.museco.model.general;

import java.util.Date;

/**
 * Municipal Service Company
 */
public class Term {
    private Date beginDate = new Date();
    private Date expireDate;

    public Term() {
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public boolean isActive() {
        Date currentDate = new Date();
        return (expireDate != null) ?
                beginDate.before(currentDate) && expireDate.after(currentDate) : beginDate.before(currentDate);
    }

    public boolean isActive(Date selectedDate) {
        return (expireDate != null) ?
                beginDate.before(selectedDate) && expireDate.after(selectedDate) : beginDate.before(selectedDate);
    }
}