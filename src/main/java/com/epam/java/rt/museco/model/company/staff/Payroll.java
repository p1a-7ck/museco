package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.model.general.Term;

import java.util.Currency;
import java.util.Date;
import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Payroll {
    private UUID id = UUID.randomUUID();
    private Date created = new Date();
    private Employee employee;
    private Term amountPeriod;
    private Currency amount;
    private Payment payment;

    public Payroll() {
    }
}
