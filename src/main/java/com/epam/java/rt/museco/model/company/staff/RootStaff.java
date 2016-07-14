package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.Main;

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
public class RootStaff {
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

    public RootStaff() {
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

    public void addPosition(Position sourcePosition) {
        Main.LOGGER.trace(".addPosition({})", sourcePosition);
        Position position = new Position();
        position.copyOf(sourcePosition);
        this.positions.add(position);
        Main.LOGGER.trace("(!) position.setParentRootStaff({})", this);
        position.setParentRootStaff(this);
    }

    public Position getPosition(UUID id) {
        for (Position position : this.positions)
            if (position.getId().equals(id)) {
                Position resultPosition = new Position();
                resultPosition.copyOf(position);
                return resultPosition;
            }
        return null;
    }

    public void removePosition(UUID id) {
        for (Position position : this.positions)
            if (position.getId().equals(id)) {
                positions.remove(position);
                break;
            }
    }

    public void updatePosition(Position sourcePosition) {
        Main.LOGGER.trace("updatePosition({}).getName() = {}", sourcePosition, sourcePosition.getName());
        Position foundPosition = null;
        for (Position position : this.positions)
            if (position.getId().equals(sourcePosition.getId())) {
                foundPosition = position;
                break;
            }
        if (foundPosition == null) throw new IllegalStateException("Position-item not exist in '" + this.name + "' staff-aggregator");
        foundPosition.copyOf(sourcePosition);
    }

    public boolean isChildEmployee(UUID id) {
        for (Employee employee : this.employees)
            if (employee.getId().equals(id))
                return true;
        return false;
    }

    @Override
    public String toString() {
        return "RootStaff {" +
                "name=" + this.name +
                ", detail=" + this.detail +
                ", positions=" + this.positions +
                ", employees=" +
                ", payrolls=" +
                ", payments=" +
                "}";
    }
}