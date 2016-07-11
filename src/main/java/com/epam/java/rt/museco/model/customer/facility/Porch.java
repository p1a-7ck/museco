package com.epam.java.rt.museco.model.customer.facility;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Porch {
    private UUID id = UUID.randomUUID();
    private String name;
    private String detail;
    private double floorArea;
    private double wallArea;
    private double ceilingArea;
    private List<Pantry> pantries = new ArrayList<Pantry>();
    private List<Apartment> apartments = new ArrayList<Apartment>();

    public Porch() {
    }
}
