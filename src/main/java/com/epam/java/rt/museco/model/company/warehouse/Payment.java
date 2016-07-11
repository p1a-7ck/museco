package com.epam.java.rt.museco.model.company.warehouse;

import java.util.*;

/**
 * Municipal Service Company
 */
public class Payment {
    private UUID id = UUID.randomUUID();
    private Date created = new Date();
    private List<Invoice> invoices = new ArrayList<Invoice>();
    private Currency amount;

    public Payment() {
    }
}
