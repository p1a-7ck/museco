package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.Main;
import org.joda.money.Money;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Payroll {
    private UUID id;
    private Employee employee;
    private DateTime createDate;
    private Money amount;
    private Payment payment;
    private RootStaff rootStaff;

    public Payroll() {
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

    public Employee getEmploye() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        if (employee != null) {
            if (this.rootStaff == null || !this.rootStaff.equals(employee.getRootStaff()))
                throw new IllegalStateException("There are no staff-aggregator or employee have another staff-aggregator");
            if (this.rootStaff.getPosition(employee.getId()) == null)
                throw new IllegalStateException("There are no employee in staff-aggregator");
        }
        this.employee = employee;
    }

    public DateTime getCreateDate() {
        return this.createDate;
    }

    public void setCreateDateNow() {
        this.setCreateDate(new DateTime());
    }

    public void setCreateDate(DateTime createDate) {
        this.createDate = createDate;
    }

    public Money getAmount() {
        return this.amount;
    }

    public void setAmont(Money amount) {
        if (amount != null) if (amount.getAmount().compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Payroll amount should be more than zero");
        this.amount = amount;
    }

    public Payment getPayment() {
        return this.payment;
    }

    public void setPayment(Payment payment) {
        if (payment != null) {
            if (this.rootStaff == null || !this.rootStaff.equals(payment.getRootStaff()))
                throw new IllegalStateException("There are no staff-aggregator or payment have another staff-aggregator");
            if (this.rootStaff.getPayment(payment.getId()) == null)
                throw new IllegalStateException("There are no payment in staff-aggregator");
        }
        this.payment = payment;
    }

    public RootStaff getRootStaff() {
        return this.rootStaff;
    }

    public void setRootStaff(RootStaff rootStaff) {
        Main.LOGGER.trace(".setRootStaff({})", rootStaff);
        if (this.rootStaff == null || !this.rootStaff.equals(rootStaff)) {
            if (this.rootStaff != null) if (this.rootStaff.getPayroll(this.id) != null)
                throw new IllegalStateException("Payroll-item exist in '" + this.rootStaff.getName() + "' staff-aggregator");
            if (rootStaff != null) if (rootStaff.getPayroll(this.id) == null)
                throw new IllegalStateException("Payroll-item not exist in '" + rootStaff.getName() + "' staff-aggregator");
            this.rootStaff = rootStaff;
        }
    }

}
