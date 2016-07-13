package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.model.general.Term;
import com.epam.java.rt.museco.model.general.Person;

/**
 * Municipal Service Company
 */
public class Employee extends Person {
    private Position position;
    private Term term = new Term();
    private Staff parentStaff;

    public Employee() {
    }

//    public Term getTerm() {
//        Term copyTerm = new Term();
//        return copyTerm.copyOf(this.term);
//    }

//    public void setTerm(Term term) {
//        // could be some checks
//        this.term.copyOf(term);
//    }

    public Position getPosition() {
        Position positionCopy = new Position();
        return positionCopy.copyOf(this.position);
    }

    public void setPosition(Position position) {
        if (this.parentStaff != null) if (!this.parentStaff.isChildPosition(position.getId())) // Employee and position should parented by one staff-object
            throw new IllegalArgumentException("There are no selected position-object in staff-object aggregator");
        this.position = position;
    }

    public Staff getParentStaff() {
        return parentStaff;
    }

    public void setParentStaff(Staff parentStaff) {
        if (this.parentStaff != null) if (!parentStaff.isChildEmployee(super.getId())) // Employee should parented by stored staff-object
            throw new IllegalArgumentException("There are no current employee-object in staff-object aggregator");
        this.parentStaff = parentStaff;
    }
}
