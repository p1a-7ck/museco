package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.model.general.Term;
import org.joda.money.Money;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Position {
    private UUID id;
    private String name;
    private Money salary;
    private Money hourCost;
    private Term term = new Term();
    private Staff parentStaff;

    public Position() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        if (id == null) this.id = UUID.randomUUID();
        else this.id = id;
    }

    public Term getTerm() {
        Term copyTerm = new Term();
        return copyTerm.copyOf(this.term);
    }

    public void setTerm(Term term) {
        // could be some checks
        this.term.copyOf(term);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getSalary() {
        return Money.of(this.salary.getCurrencyUnit(), this.salary.getAmount());
    }

    public void setSalary(Money salary) {
        if (salary.getAmount().compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Salary amount should be more than zero");
        this.salary = Money.of(salary.getCurrencyUnit(), salary.getAmount());
    }

    public Money getHourCost() {
        return Money.of(this.hourCost.getCurrencyUnit(), this.hourCost.getAmount());
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
        this.setTerm(position.getTerm());
        this.setParentStaff(position.getParentStaff());
        return this; // return Position for inline-code use
    }
}
