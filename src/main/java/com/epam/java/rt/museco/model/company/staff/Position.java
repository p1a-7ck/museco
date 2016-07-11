package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.model.general.Term;

import java.util.Currency;
import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Position {
    private UUID id;
    private String name;
    private Currency salary;
    private Currency hourCost;
    private Term term;

    public Position() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        if (id == null) this.id = UUID.randomUUID();
        else this.id = id;
    }

    public Term getTerm() {
        Term copyTerm = new Term();
        return copyTerm.copyOf(this.term);
    }

    public void setTerm(Term term) {
        // could be some checks
        this.term.copyOf(term);
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
        Currency c;
        c.
        if (salary.` >= 0)
        this.salary = salary;
    }

    public Currency getHourCost() {
        return hourCost;
    }

    public void setHourCost(Currency hourCost) {
        this.hourCost = hourCost;
    }

    public Position copyOf(Position position) {
        this.setId(position.getId());
        this.setName(position.getName());
        this.setSalary(position.getSalary());
        this.setHourCost(position.getHourCost());
        this.setTerm(position.getTerm());
        return this; // return Position for inline-code use
    }
}
