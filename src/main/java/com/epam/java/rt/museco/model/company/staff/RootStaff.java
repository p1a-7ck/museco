package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.model.general.Aggregatable;
import com.epam.java.rt.museco.model.general.BaseAggregator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Municipal Service Company
 * Aggregator-object for positions, employees, payrolls and payments list based
 * on this class. There are checks to determine if staff-object aggregates exact
 * position/employee/payroll/payment object to exclude mixin between different
 * staff-objects
 */
@XmlRootElement(name = "staff")
@XmlAccessorType(XmlAccessType.FIELD)
public class RootStaff extends BaseAggregator implements Aggregatable {
    private String name;
    private String detail;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RootStaff rootStaff = (RootStaff) o;

        return this.id != null ? this.id.equals(rootStaff.id) : null;

    }

    @Override
    public int hashCode() {
        return this.id != null ? this.id.hashCode() : 0;
    }

    public String toInDetail() {
        return "RootStaff {" +
                "id=" + this.id +
                ", name=" + this.name +
                ", detail=" + this.detail +
                ", positions=" + this.positions +
                ", employees=" + this.employees +
                ", payrolls=" + this.payrolls +
                ", payments=" + this.payments +
                "}";
    }
}