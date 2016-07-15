package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.model.general.LifeTime;
import com.epam.java.rt.museco.model.general.LifeTimeable;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.time.DateTime;
import org.junit.Test;

/**
 * museco
 */
public class NewPositionTest {

    @Test
    public void initTest() {
        RootStaff rootStaff = new RootStaff();
        Position position = new Position();

        position.setId();
        position.setName("Manager");
        position.setSalary(Money.of(CurrencyUnit.of("KZT"), 100000));
        position.setHourCost(Money.of(CurrencyUnit.of("KZT"), 625));
        position.setLifeTime(LifeTime.of(DateTime.now().plusDays(-10), DateTime.now().plusDays(+10)));

        rootStaff.addSubEntity(position);

        position = new Position();

        position.setId();
        position.setName("Worker");
        position.setSalary(Money.of(CurrencyUnit.of("KZT"), 50000));
        position.setHourCost(Money.of(CurrencyUnit.of("KZT"), 312));
        position.setLifeTime(LifeTime.of(DateTime.now().plusDays(-10), DateTime.now().plusDays(+10)));

        rootStaff.addSubEntity(position);

        System.out.println(rootStaff.getSubEntities(Position.class));
        
        for (Class subEntityClass : rootStaff.getSubEntitiesClasses()) {
            System.out.println(rootStaff.getSubEntities(subEntityClass));
        }
    }
}
