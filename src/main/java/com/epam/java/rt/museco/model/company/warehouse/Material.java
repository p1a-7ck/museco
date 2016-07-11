package com.epam.java.rt.museco.model.company.warehouse;

import java.util.Currency;
import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Material {
    private UUID id = UUID.randomUUID();
    private String name;
    private String details;
    private String unit;
    private Currency cost;

    public Material() {
    }
}
