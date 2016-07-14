package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.Main;
import com.epam.java.rt.museco.service.marshal.MoneyAdapter;
import com.epam.java.rt.museco.service.marshal.StaffAdapter;
import org.joda.money.Money;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.ReadableInterval;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Municipal Service Company
 */
@XmlRootElement(name = "position")
@XmlAccessorType(XmlAccessType.FIELD)
public class Position {
    private UUID id;
    private String name;
    @XmlJavaTypeAdapter(MoneyAdapter.class)
    private Money salary;
    @XmlJavaTypeAdapter(MoneyAdapter.class)
    private Money hourCost;
    private Interval dateLimits;
    @XmlJavaTypeAdapter(StaffAdapter.class)
    private Staff parentStaff;

    public Position() {
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public void setId(UUID id) {
        if (id == null) this.id = UUID.randomUUID();
        else this.id = id;
    }

    public ReadableInterval getDateLimits() {
        return this.dateLimits;
    }

    public void setDateLimitsStart() {
        if (this.dateLimits == null) this.dateLimits = new Interval(new DateTime(), new DateTime());
        else this.dateLimits = new Interval(new DateTime(), this.dateLimits.getEnd());
    }

    public void setDateLimitsStart(DateTime startDate) {
        if (this.dateLimits == null) this.dateLimits = new Interval(startDate, new DateTime());
        else this.dateLimits = new Interval(startDate, this.dateLimits.getEnd());
    }

    public void setDateLimitsEnd() {
        if (this.dateLimits == null) this.dateLimits = new Interval(new DateTime(), new DateTime());
        else this.dateLimits = new Interval(this.dateLimits.getStart(), new DateTime());
    }

    public void setDateLimitsEnd(DateTime endDate) {
        if (this.dateLimits == null) this.dateLimits = new Interval(new DateTime(), endDate);
        else this.dateLimits = new Interval(this.dateLimits.getStart(), endDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getSalary() {
        return this.salary; //Money.of(this.salary.getCurrencyUnit(), this.salary.getAmount());
    }

    public void setSalary(Money salary) {
        if (salary.getAmount().compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Salary amount should be more than zero");
        this.salary = Money.of(salary.getCurrencyUnit(), salary.getAmount());
    }

    public Money getHourCost() {
        return this.hourCost; //Money.of(this.hourCost.getCurrencyUnit(), this.hourCost.getAmount());
    }

    public void setHourCost(Money hourCost) {
        if (hourCost.getAmount().compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Hour cost amount should be more than zero");
        this.hourCost = Money.of(hourCost.getCurrencyUnit(), hourCost.getAmount());
    }

    public Staff getParentStaff() {
        return parentStaff;
    }

    public void setParentStaff(Staff parentStaff) {
        if (this.parentStaff != null) if (!this.parentStaff.isChildPosition(this.id))
            throw new IllegalArgumentException("There are no selected position-object in staff-object aggregator");
        this.parentStaff = parentStaff;
    }

    public Position copyOf(Position position) {
        this.setId(position.getId());
        this.setName(position.getName());
        this.setSalary(position.getSalary());
        this.setHourCost(position.getHourCost());
//        this.setTerm(position.getTerm());
        this.setParentStaff(position.getParentStaff());
        return this; // return Position for inline-code use
    }

    @Override
    public String toString() {
        return "Position {" +
                "id=" + this.id +
                "}";
    }
}
