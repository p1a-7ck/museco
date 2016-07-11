package com.epam.java.rt.museco.model.customer.facility;

import com.epam.java.rt.museco.model.general.Term;

import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Backyard {
    private UUID id = UUID.randomUUID();
    private String name;
    private double surfaceArea;
    private Term term;

    public Backyard() {
    }
}
