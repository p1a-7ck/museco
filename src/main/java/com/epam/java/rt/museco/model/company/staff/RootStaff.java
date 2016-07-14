package com.epam.java.rt.museco.model.company.staff;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

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
    private UUID id;
    private String name;
    private String detail;
    @XmlElementWrapper
    private Map<UUID, Position> positions = new HashMap<UUID, Position>();
    @XmlElementWrapper
    private Map<UUID, Employee> employees = new HashMap<UUID, Employee>();
    @XmlElementWrapper
    private Map<UUID, Payroll> payrolls = new HashMap<UUID, Payroll>();
    @XmlElementWrapper
    private Map<UUID, Payment> payments = new HashMap<UUID, Payment>();

    public RootStaff() {
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        if (this.id != null) throw new IllegalStateException("Id already set");
        this.id = UUID.randomUUID();
    }

    public void setId(UUID id) {
        if (this.id != null) throw new IllegalStateException("Id already set");
        if (id == null) this.id = UUID.randomUUID();
        else this.id = id;
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
        this.positions.put(position.getId(), position);
        position.setRootStaff(this);
    }

    public Position getPosition(UUID id) {
        return this.positions.get(id);
    }

    public void removePosition(UUID id) {
        this.positions.remove(id);
    }

    public void addEmployee(Employee employee) {
        this.employees.put(employee.getId(), employee);
        employee.setRootStaff(this);
    }

    public Employee getEmployee(UUID id) {
        return this.employees.get(id);
    }

    public void removeEmployee(UUID id) {
        this.employees.remove(id);
    }

    public void addPayroll(Payroll payroll) {
        this.payrolls.put(payroll.getId(), payroll);
        payroll.setRootStaff(this);
    }

    public Payroll getPayroll(UUID id) {
        return this.payrolls.get(id);
    }

    public void removePayroll(UUID id) {
        this.payrolls.remove(id);
    }

    public void addPayment(Payment payment) {
        this.payments.put(payment.getId(), payment);
        payment.setRootStaff(this);
    }

    public Payment getPayment(UUID id) {
        return this.payments.get(id);
    }

    public void removePayment(UUID id) {
        this.payments.remove(id);
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

    @Override
    public String toString() {
        return "RootStaff {" +
                "id=" + this.id +
                "}";
    }
}