package com.epam.java.rt.museco.model.customer.facility;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Municipal Service Company
 */
public class RootFacility {
    private UUID id = UUID.randomUUID();
    private String name;
    private String address;
    private String detail;
    private List<Entry> entries = new ArrayList<Entry>();
    private List<Backyard> backyards = new ArrayList<Backyard>();
    private List<Section> sections = new ArrayList<Section>();


    public RootFacility() {
    }
}
