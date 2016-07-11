package com.epam.java.rt.museco.model.company.warehouse;

import java.util.Currency;
import java.util.Date;
import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Invoice {
    private UUID id = UUID.randomUUID();
    private Date created = new Date();
    private Material material;
    private Currency purchaseCost;
    private Double quantity;

    public Invoice() {
    }

}
