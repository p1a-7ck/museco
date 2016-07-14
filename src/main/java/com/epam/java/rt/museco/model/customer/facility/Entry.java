package com.epam.java.rt.museco.model.customer.facility;

import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Entry {
    private UUID id = UUID.randomUUID();
    private String name;
    private String detail;
    private double floorArea;
    private double wallArea;
    private double ceilingArea;
//    private Term term;

    public Entry() {
    }
}
