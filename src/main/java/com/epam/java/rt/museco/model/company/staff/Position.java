package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.Main;
import com.epam.java.rt.museco.model.general.BaseSubEntity;
import com.epam.java.rt.museco.model.general.LifeTime;
import com.epam.java.rt.museco.model.general.PersonName;
import com.epam.java.rt.museco.model.general.SubEntitable;
import org.joda.money.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Municipal Service Company
 */
@XmlRootElement(name = "position")
@XmlAccessorType(XmlAccessType.FIELD)
public class Position extends BaseSubEntity implements SubEntitable {
    private final static Logger POSITION_LOG = LoggerFactory.getLogger(Position.class);
    private String name;
    private Money salary;
    private Money hourCost;
    private LifeTime lifeTime;

    public Position() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
        POSITION_LOG.info("Name set to {}", this.name);
    }

    public Money getSalary() {
        return this.salary;
    }

    public void setSalary(Money salary) {
        Main.LOGGER.trace("setSalary({})", salary);
        if (salary != null) if (salary.getAmount().compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Salary amount should be more than zero");
        this.salary = salary;
    }

    public Money getHourCost() {
        return this.hourCost; //Money.of(this.hourCost.getCurrencyUnit(), this.hourCost.getAmount());
    }

    public void setHourCost(Money hourCost) {
        Main.LOGGER.trace("setSalary({})", salary);
        if (hourCost != null) if (hourCost.getAmount().compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Hour cost amount should be more than zero");
        this.hourCost = hourCost;
    }

    public LifeTime getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(LifeTime lifeTime) {
        this.lifeTime = lifeTime;
    }

    public void copyOf(Position position) {
        super.setId(position.getId());
        this.name = position.name;
        this.salary = position.salary;
        this.hourCost = position.hourCost;
        this.lifeTime.copyOf(position.lifeTime);
        this.setAggregator(position.getAggregator());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        return (super.getId() != null && position.getId() != null) && super.getId().equals(position.getId());
    }

    @Override
    public int hashCode() {
        return super.getId() != null ? super.getId().hashCode() : 0;
    }

    public String toInDetail() {
        return "Position {" +
                "id=" + super.getId() +
                ", name=" + this.name +
                ", salary=" + this.salary +
                ", hourCost=" + this.hourCost +
                ", createDate=" + this.lifeTime.getCreateDate() +
                ", expireDate=" + this.lifeTime.getExpireDate() +
                ", rootStaff=" + super.getAggregator() +
                "}";
    }
}