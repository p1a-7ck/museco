package com.epam.java.rt.museco.model.general;

import java.util.Date;

/**
 * Municipal Service Company
 */
public interface Termable {
    Date getBeginDate();

    Termable setBeginDate();

    Termable setBeginDate(Date beginDate);

    Date getExpireDate();

    Termable setExpireDate();

    Termable setExpireDate(Date expireDate);

    boolean withinDate();

    boolean withinDate(Date checkDate);
}
