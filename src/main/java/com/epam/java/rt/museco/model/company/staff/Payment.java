package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.Main;
import org.joda.money.Money;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Payment {
    private UUID id;
    private DateTime createdDate;
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
