package com.epam.java.rt.museco.model.company.staff;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Municipal Service Company
 * Aggregator-object for positions, employees, payrolls and payments list based
 * on this class. There are checks to determine if staff-object aggregates exact
 * position/employee/payroll/payment object to exclude mixin between different
 * staff-objects
 */
@XmlRootElement(name = "staff")
@XmlAccessorType(XmlAccessType.FIELD)
public class Staff {
    private String name;
    private String detail;
    @XmlElementWrapper
    private List<Position> positions = new ArrayList<Position>();
    @XmlElementWrapper
    private List<Employee> employees = new ArrayList<Employee>();
    @XmlElementWrapper
    private List<Payroll> payrolls = new ArrayList<Payroll>();
    @XmlElementWrapper
    private List<Payment> payments = new ArrayList<Payment>();

    public Staff() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void addPosition(Position position) {
        Position newPosition = new Position();
        newPosition.copyOf(position).setParentStaff(this);
        this.positions.add(newPosition);
    }

    public boolean isChildPosition(UUID id) {
        for (Position position : this.positions)
            if (position.getId().equals(id))
                return true;
        return false;
    }

    public boolean isChildEmployee(UUID id) {
        for (Employee employee : this.employees)
            if (employee.getId().equals(id))
                return true;
        return false;
    }

    @Override
    public String toString() {
        return "Staff {" +
                "name=" + this.name +
                ", detail=" + this.detail +
                ", positions=" + this.positions +
                ", employees=" +
                ", payrolls=" +
                ", payments=" +
                "}";
    }
}