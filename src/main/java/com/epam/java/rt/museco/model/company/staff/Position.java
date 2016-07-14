package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.Main;
import com.epam.java.rt.museco.service.marshal.MoneyAdapter;
import com.epam.java.rt.museco.service.marshal.StaffAdapter;
import org.joda.money.Money;
import org.joda.time.DateTime;

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
    private DateTime createDate;
    private DateTime expireDate;
    @XmlJavaTypeAdapter(StaffAdapter.class)
    private RootStaff parentRootStaff;

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

    public boolean isWithinCreateAndExpireDatesNow() {
        return isWithinCreateAndExpireDates(new DateTime());
    }

    public boolean isWithinCreateAndExpireDates(DateTime checkDate) {
        return !(checkDate == null || this.createDate == null) &&
                (this.expireDate == null ? !this.createDate.isAfter(checkDate) :
                this.expireDate.isAfter(checkDate) && !this.createDate.isAfter(checkDate));
    }

    private boolean isAcceptableCreateAndExpireDates(DateTime createDate, DateTime expireDate) {
        return (createDate == null && expireDate == null) || (createDate != null && expireDate == null) ||
                (createDate != null && !createDate.isAfter(expireDate));
    }

    public DateTime getCreateDate() {
        return this.createDate;
    }

    public void setCreateDateNow() {
        this.setCreateDate(new DateTime());
    }

    public void setCreateDate(DateTime createDate) {
        if (!isAcceptableCreateAndExpireDates(createDate, this.expireDate))
            throw new IllegalArgumentException("Begin date should be before or equal expire date");
        this.createDate = createDate;
    }

    public DateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDateNow() {
        this.setExpireDate(new DateTime());
    }

    public void setExpireDate(DateTime expireDate) {
        if (!isAcceptableCreateAndExpireDates(createDate, this.expireDate))
            throw new IllegalArgumentException("Begin date should be defined first and should be before or equal expire date");
        this.expireDate = expireDate;
    }

    public RootStaff getParentRootStaff() {
        return parentRootStaff;
    }

    public void setParentRootStaff(RootStaff parentRootStaff) {
        Main.LOGGER.trace(".setParentRootStaff({})", parentRootStaff);
        if (parentRootStaff == null || !parentRootStaff.equals(this.parentRootStaff)) {
            if (this.parentRootStaff != null) if (this.parentRootStaff.getPosition(this.id) != null)
                throw new IllegalStateException("Position-item exist in staff-aggregator");
            if (parentRootStaff != null) if (parentRootStaff.getPosition(this.id) == null)
                throw new IllegalStateException("Position-item not exist in staff-aggregator");
            this.parentRootStaff = parentRootStaff;
        }
    }

    public void copyOf(Position position) {
        this.setId(position.getId());
        this.setName(position.getName());
        this.setSalary(position.getSalary());
        this.setHourCost(position.getHourCost());
        this.setCreateDate(position.getCreateDate());
        this.setExpireDate(position.getExpireDate());
//        this.setParentRootStaff(position.getParentRootStaff());
    }

    @Override
    public String toString() {
        return "Position {" +
                "id=" + this.id +
                "}";
    }
}
