package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.Main;
import org.joda.money.Money;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Payment {
    private UUID id;
    private DateTime createDate;
    private Map<UUID, Payroll> payrolls = new HashMap<UUID, Payroll>();
    private Money amount;
    private RootStaff rootStaff;

    public Payment() {
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

    public DateTime getCreateDate() {
        return this.createDate;
    }

    public void setCreateDateNow() {
        this.setCreateDate(new DateTime());
    }

    public void setCreateDate(DateTime createDate) {
        this.createDate = createDate;
    }

    public void addPayroll(Payroll payroll) {
        if (payroll != null) {
            if (this.rootStaff == null || !this.rootStaff.equals(payroll.getRootStaff()))
                throw new IllegalStateException("There are no staff-aggregator or payroll have another staff-aggregator");
            if (this.rootStaff.getPayroll(payroll.getId()) == null)
                throw new IllegalStateException("There are no payroll in staff-aggregator");
        }
        this.payrolls.put(payroll.getId(), payroll);
        payroll.setPayment(this);
    }

    public Payroll getPayroll(UUID id) {
        return this.payrolls.get(id);
    }

    public void removePayroll(UUID id) {
        this.payrolls.remove(id);
    }

    public Money getAmount() {
        return this.amount;
    }

    public void setAmont(Money amount) {
        if (amount != null) if (amount.getAmount().compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Payment amount should be more than zero");
        this.amount = amount;
    }

    public RootStaff getRootStaff() {
        return this.rootStaff;
    }

    public void setRootStaff(RootStaff rootStaff) {
        Main.LOGGER.trace(".setRootStaff({})", rootStaff);
        if (this.rootStaff == null || !this.rootStaff.equals(rootStaff)) {
            if (this.rootStaff != null) if (this.rootStaff.getPayment(this.id) != null)
                throw new IllegalStateException("Payment-item exist in '" + this.rootStaff.getName() + "' staff-aggregator");
            if (rootStaff != null) if (rootStaff.getPayment(this.id) == null)
                throw new IllegalStateException("Payment-item not exist in '" + rootStaff.getName() + "' staff-aggregator");
            this.rootStaff = rootStaff;
        }
    }

}
