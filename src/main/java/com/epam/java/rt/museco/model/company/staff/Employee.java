package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.model.general.BasePerson;
import org.joda.time.DateTime;

/**
 * Municipal Service Company
 */
public final class Employee extends BasePerson {
    private Position position;
    private DateTime createDate;
    private DateTime expireDate;
    private RootStaff parentRootStaff;

    public Employee() {
    }

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
