package com.epam.java.rt.museco.model.customer.facility;

import com.epam.java.rt.museco.model.general.Term;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Section {
    private UUID id = UUID.randomUUID();
    private String name;
    private String detail;
    private double roofArea;
    private double wallArea;
    private List<Porch> porches = new ArrayList<Porch>();
    private List<Garage> garages = new ArrayList<Garage>();
    private Term term;

    public Section() {
    }
}
