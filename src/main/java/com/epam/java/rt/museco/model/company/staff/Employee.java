package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.model.general.Term;
import com.epam.java.rt.museco.model.general.Person;

import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Employee extends Person {
    private UUID id = UUID.randomUUID();
    private Position position;
    private Term term;

    public Employee() {
    }

    public UUID getId() {
        return id;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
