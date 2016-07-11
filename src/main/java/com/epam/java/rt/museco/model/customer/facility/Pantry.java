package com.epam.java.rt.museco.model.customer.facility;

import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Pantry {
    private UUID id = UUID.randomUUID();
    private String name;
    private String detail;
    private double floorArea;

    public Pantry() {
    }
}
