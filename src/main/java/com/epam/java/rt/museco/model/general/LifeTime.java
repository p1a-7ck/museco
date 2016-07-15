package com.epam.java.rt.museco.model.general;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Municipal Service Company
 * This is Value Object which optimize use of create and expire dates
 */
public class LifeTime {
    private final static Logger LIFE_TIME_LOG = LoggerFactory.getLogger(LifeTime.class);
    private DateTime createDate;
    private DateTime expireDate;

    public LifeTime() {
    }

    public LifeTime(DateTime createDate, DateTime expireDate) {
        this.createDate = createDate;
        this.expireDate = expireDate;
    }

    public boolean isWithinCreateAndExpireDatesNow() {
        return isWithinCreateAndExpireDates(new DateTime());
    }

    public boolean isWithinCreateAndExpireDates(DateTime requestedDate) {
        return !(requestedDate == null || this.createDate == null) &&
                (this.expireDate == null ? !this.createDate.isAfter(requestedDate) :
                        this.expireDate.isAfter(requestedDate) && !this.createDate.isAfter(requestedDate));
    }

    private boolean isAcceptableCreateAndExpireDates(DateTime createDate, DateTime expireDate) {
        return (createDate == null && expireDate == null) || (createDate != null && expireDate == null) ||
                (createDate != null && !createDate.isAfter(expireDate));
    }

    public DateTime getCreateDate() {
        return this.createDate;
    }

    public boolean setCreateDateNow() {
        return this.setCreateDate(new DateTime());
    }

    public boolean setCreateDate(DateTime createDate) {
        if (!isAcceptableCreateAndExpireDates(createDate, this.expireDate)) {
            LIFE_TIME_LOG.error("Trying to set create date to {}", createDate);
            throw new IllegalArgumentException("Create date should be before or equal expire date");
        }
        this.createDate = createDate;
        LIFE_TIME_LOG.info("Create date set to {}", createDate);
        return true;
    }

    public DateTime getExpireDate() {
        return expireDate;
    }

    public boolean setExpireDateNow() {
        return this.setExpireDate(new DateTime());
    }

    public boolean setExpireDate(DateTime expireDate) {
        if (!isAcceptableCreateAndExpireDates(createDate, this.expireDate)) {
            LIFE_TIME_LOG.error("Trying to set expire date to {}", expireDate);
            throw new IllegalArgumentException("Create date should be defined first and should be before or equal expire date");
        }
        this.expireDate = expireDate;
        LIFE_TIME_LOG.info("Expire date set to {}", expireDate);
        return true;
    }

    public static LifeTime of(DateTime createDate, DateTime expireDate) {
        return new LifeTime(createDate, expireDate);
    }

    public static LifeTime of(LifeTime lifeTime) {
        return new LifeTime(lifeTime.createDate, lifeTime.expireDate);
    }

    public void copyOf(LifeTime lifeTime) {
        this.createDate = lifeTime.createDate;
        this.expireDate = lifeTime.expireDate;
        LIFE_TIME_LOG.info("Life time made copy of {}", this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LifeTime lifeTime = (LifeTime) o;

        if (createDate != null ? !createDate.equals(lifeTime.createDate) : lifeTime.createDate != null) return false;
        return expireDate != null ? expireDate.equals(lifeTime.expireDate) : lifeTime.expireDate == null;

    }

    @Override
    public int hashCode() {
        int result = createDate != null ? createDate.hashCode() : 0;
        result = 31 * result + (expireDate != null ? expireDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LifeTime{" +
                "createDate=" + createDate +
                ", expireDate=" + expireDate +
                '}';
    }
}
