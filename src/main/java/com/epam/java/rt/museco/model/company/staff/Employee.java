package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.model.general.Term;
import com.epam.java.rt.museco.model.general.Person;

import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Employee extends Person {
    private Position position;
    private Term term;

    public Employee() {
    }

    public Term getTerm() {
        Term copyTerm = new Term();
        return copyTerm.copyOf(this.term);
    }

    public void setTerm(Term term) {
        // could be some checks
        this.term.copyOf(term);
    }

    public Position getPosition() {
        Position positionCopy = new Position();

        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
