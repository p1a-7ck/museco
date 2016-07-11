package com.epam.java.rt.museco.model.company.staff;

import java.util.*;

/**
 * Municipal Service Company
 */
public class Payment {
    private UUID id = UUID.randomUUID();
    private Date created = new Date();
    private List<Payroll> payrolls = new ArrayList<Payroll>();
    private Currency amount;

    public Payment() {
    }
}
