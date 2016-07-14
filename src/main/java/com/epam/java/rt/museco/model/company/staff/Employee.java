package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.model.general.BasePerson;

/**
 * Municipal Service Company
 */
public class Employee extends BasePerson {
    private Position position;
//    private Term term = new Term();
private RootStaff parentRootStaff;

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
        positionCopy.copyOf(this.position);
        return positionCopy;
    }

    public void setPosition(Position position) {
        if (this.parentRootStaff != null)
            if (this.parentRootStaff.getPosition(position.getId()) == null) // Employee and position should parented by one staff-object
            throw new IllegalArgumentException("There are no selected position-object in staff-object aggregator");
        this.position = position;
    }

    public RootStaff getParentRootStaff() {
        return parentRootStaff;
    }

    public void setParentRootStaff(RootStaff parentRootStaff) {
        if (this.parentRootStaff != null)
            if (!parentRootStaff.isChildEmployee(super.getId())) // Employee should parented by stored staff-object
            throw new IllegalArgumentException("There are no current employee-object in staff-object aggregator");
        this.parentRootStaff = parentRootStaff;
    }
}
