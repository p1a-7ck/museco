package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.Main;
import com.epam.java.rt.museco.model.general.BasePerson;
import org.joda.time.DateTime;

import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Employee extends BasePerson {
    private UUID id;
    private Position position;
    private DateTime createDate;
    private DateTime expireDate;
    private RootStaff rootStaff;

    public Employee() {
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

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        if (position != null) {
            if (this.rootStaff == null || !this.rootStaff.equals(position.getRootStaff()))
                throw new IllegalStateException("There are no staff-aggregator or position have another staff-aggregator");
            if (this.rootStaff.getPosition(position.getId()) == null)
                throw new IllegalStateException("There are no position in staff-aggregator");
        }
        this.position = position;
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

    public RootStaff getRootStaff() {
        return this.rootStaff;
    }

    public void setRootStaff(RootStaff rootStaff) {
        Main.LOGGER.trace(".setRootStaff({})", rootStaff);
        if (this.rootStaff == null || !this.rootStaff.equals(rootStaff)) {
            if (this.rootStaff != null) if (this.rootStaff.getEmployee(this.id) != null)
                throw new IllegalStateException("Employee-item exist in '" + this.rootStaff.getName() + "' staff-aggregator");
            if (rootStaff != null) if (rootStaff.getEmployee(this.id) == null)
                throw new IllegalStateException("Employee-item not exist in '" + rootStaff.getName() + "' staff-aggregator");
            this.rootStaff = rootStaff;
        }
    }

    public void copyOf(Employee employee) {
        Main.LOGGER.trace(".copyOf({})", employee);
        this.id = employee.id;
        super.setFirstName(employee.getFirstName());
        super.setLastName(employee.getLastName());
        super.setMiddleName(employee.getMiddleName());
        this.position = employee.position;
        this.createDate = employee.createDate;
        this.expireDate = employee.expireDate;
        this.rootStaff = employee.rootStaff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return this.id != null ? this.id.equals(employee.id) : null;

    }

    @Override
    public int hashCode() {
        return this.id != null ? this.id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "id=" + this.id +
                "}";
    }
}
