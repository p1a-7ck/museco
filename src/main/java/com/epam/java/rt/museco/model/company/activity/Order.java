package com.epam.java.rt.museco.model.company.activity;

import java.util.Currency;
import java.util.Date;
import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Order {
    private UUID id = UUID.randomUUID();
    private Date created = new Date();
    private Service service;
    private Currency orderCost;

    public Order() {
    }
}
