package com.epam.java.rt.museco.model.general;

import org.joda.time.DateTime;

/**
 * museco
 */
public interface LifeTimeable {
    boolean isWithinCreateAndExpireDatesNow();

    boolean isWithinCreateAndExpireDates(DateTime requestedDate);

    boolean isAcceptableCreateAndExpireDates(DateTime createDate, DateTime expireDate);

    DateTime getCreateDate();

    boolean setCreateDateNow();

    boolean setCreateDate(DateTime createDate);

    DateTime getExpireDate();

    boolean setExpireDateNow();

    boolean setExpireDate(DateTime expireDate);

}
