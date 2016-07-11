package com.epam.java.rt.museco.model.company.staff;

import java.util.ArrayList;
import java.util.List;

/**
 * Municipal Service Company
 */
public class Staff {
    private List<Position> positions = new ArrayList<Position>();
    private List<Employee> employees = new ArrayList<Employee>();
    private List<Payroll> payrolls = new ArrayList<Payroll>();
    private List<Payment> payments = new ArrayList<Payment>();

    public Staff() {
    }
}
