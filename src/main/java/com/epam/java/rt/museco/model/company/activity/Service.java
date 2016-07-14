package com.epam.java.rt.museco.model.company.activity;

import com.epam.java.rt.museco.model.company.warehouse.Material;
import com.epam.java.rt.museco.model.company.staff.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Service {
    private UUID id = UUID.randomUUID();
    private String name;
    private List<Material> materials = new ArrayList<Material>();
    private List<Position> positions = new ArrayList<Position>();
//    private Term term;

    public Service() {
    }
}
