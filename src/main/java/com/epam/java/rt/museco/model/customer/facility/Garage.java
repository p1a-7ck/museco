package com.epam.java.rt.museco.model.customer.facility;

import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Garage {
    private UUID id = UUID.randomUUID();
    private String name;
    private double floorArea;

    public Garage() {
    }
}
