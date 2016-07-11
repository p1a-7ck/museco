package com.epam.java.rt.museco.model.company.activity;

import com.epam.java.rt.museco.model.general.Term;
import com.epam.java.rt.museco.model.company.warehouse.Material;
import com.epam.java.rt.museco.model.company.staff.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Provision {
    private UUID id = UUID.randomUUID();
    private Order order;
    private List<Material> materialsFact = new ArrayList<Material>();
    private List<Employee> employeesFact = new ArrayList<Employee>();
    private Term term;

    public Provision() {
    }
}
