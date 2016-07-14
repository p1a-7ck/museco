package com.epam.java.rt.museco.model.company.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Municipal Service Company
 */
public class RootActivity {
    private UUID id = UUID.randomUUID();
    private List<Service> services = new ArrayList<Service>();
    private List<Order> orders = new ArrayList<Order>();
    private List<Provision> provisions = new ArrayList<Provision>();

    public RootActivity() {
    }
}
