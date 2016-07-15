package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.Main;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Test;

/**
 * Municipal Service Company
 */
public class RootStaffTest {

    /**
     * (1) Create new root staff and setId
     * (2) Set name to 'BI-GROUP' and detail to 'Astana'
     * (3) Add new position and setId
     * (4) Set position's name to 'manager'
     * (5) Set salary to KZT 100.000
     * (6) Set hourCost to KZT 1.000
     * (7) Set createDate to now()
     * (8) Add new employee and setId
     * (9) Set first, last and middle name
     * (10) Set createDate to now()
     * (11) Set position 'manager' for employer 'Ivanov I.I.'
     */
    @Test
    public void simpleCreateAllEntitiesTest() {
        RootStaff rootStaff = new RootStaff();          // (1)
        rootStaff.setId();                              // (1)
        rootStaff.setName("BI-GROUP");                  // (2)
        rootStaff.setDetail("Astana");                  // (2)
        Position position = rootStaff.addNewPosition(); // (3)
        position.setName("manager");                    // (4)
        position.setSalary(Money.of
                (CurrencyUnit.of("KZT"), 100000));      // (5)
        position.setHourCost(Money.of
                (CurrencyUnit.of("KZT"), 1000));        // (6)
//        position.setCreateDateNow();                    // (7)
        Employee employee = rootStaff.addNewEmployee(); // (8)
        employee.setFirstName("Ivan");                  // (9)
        employee.setLastName("Ivanov");                 // (9)
        employee.setMiddleName("Ivanovich");            // (9)
        employee.setCreateDateNow();                    // (10)
        Main.LOGGER.trace("position = {}", position.toInDetail());
        employee.setPosition(position);                 // (11)
        Main.LOGGER.trace("rootStaff = {}", rootStaff.toInDetail());

    }
}