package com.epam.java.rt.museco.model.company.warehouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Municipal Service Company
 */
public class Warehouse {
    private List<Material> materials = new ArrayList<Material>();
    private List<Invoice> invoices = new ArrayList<Invoice>();
    private List<Payment> payments = new ArrayList<Payment>();
    private List<Transfer> transfers = new ArrayList<Transfer>();

    public Warehouse() {
    }

}
