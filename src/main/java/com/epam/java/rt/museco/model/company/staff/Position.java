package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.model.general.Term;

import java.util.Currency;
import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Position {
    private UUID id = UUID.randomUUID();
    private String name;
    private Currency salary;
    private Currency hourCost;
    private Term term;

    public Position() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency getSalary() {
        return salary;
    }

    public void setSalary(Currency salary) {
        this.salary = salary;
    }

    public Currency getHourCost() {
        return hourCost;
    }

    public void setHourCost(Currency hourCost) {
        this.hourCost = hourCost;
    }
}
