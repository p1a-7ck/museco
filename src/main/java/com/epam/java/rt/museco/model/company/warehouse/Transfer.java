package com.epam.java.rt.museco.model.company.warehouse;

import java.util.Date;
import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Transfer {
    private UUID id = UUID.randomUUID();
    private Date created = new Date();
    private Material material;
    private Double quantity;

    public Transfer() {
    }
}
