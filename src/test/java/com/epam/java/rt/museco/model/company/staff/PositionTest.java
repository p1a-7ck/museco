package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.Main;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * museco
 */
public class PositionTest {

//    @Test
//    public void initTest() {
//        Main.LOGGER.trace(".initTest()");
//        Position position = new Position();
//        assertNotNull(position);
//        assertNull(position.getId());
//        assertNull(position.getName());
//        assertNull(position.getSalary());
//        assertNull(position.getHourCost());
//        assertNull(position.getCreateDate());
//        assertNull(position.getExpireDate());
//        assertNull(position.getRootStaff());
//    }

    @Test
    public void setGetIdTest() {
        Main.LOGGER.trace(".setGetIdTest()");
        Position position = new Position();
        assertNotNull(position);
        assertNull(position.getId());
        position.setId();
        assertNotNull(position.getId());
        UUID id = UUID.randomUUID();
        position = new Position();
        position.setId(id);
        assertEquals(id, position.getId());
    }

    @Test
    public void setGetNameTest() {
        Main.LOGGER.trace(".setGetNameTest()");
        Position position = new Position();
        assertNotNull(position);
        assertNull(position.getName());
        String name = "NAME";
        position.setName(name);
        assertEquals(name, position.getName());
        name = null;
        position.setName(name);
        assertNull(position.getName());
    }

    @Test
    public void setGetSalaryHourCostTest() {
        Main.LOGGER.trace(".setGetSalaryHourCostTest()");
        Position position = new Position();
        assertNotNull(position);
        assertNull(position.getSalary());
        assertNull(position.getHourCost());
        Money salary = Money.of(CurrencyUnit.of("KZT"), 10000);
        position.setSalary(salary);
        assertEquals(salary, position.getSalary());
        salary = Money.of(CurrencyUnit.of("KZT"), 0);
        position.setSalary(salary);
        assertEquals(salary, position.getSalary());
        salary = null;
        position.setSalary(salary);
        assertNull(position.getSalary());
        Money hourCost = Money.of(CurrencyUnit.of("KZT"), 1000);
        position.setHourCost(hourCost);
        assertEquals(hourCost, position.getHourCost());
        hourCost = Money.of(CurrencyUnit.of("KZT"), 0);
        position.setHourCost(hourCost);
        assertEquals(hourCost, position.getHourCost());
        hourCost = null;
        position.setHourCost(hourCost);
        assertNull(position.getHourCost());
    }

//    @Test
//    public void createExpireDatesNowTest() {
//        Main.LOGGER.trace(".createExpireDatesNowTest()");
//        Position position = new Position();
//        assertNotNull(position);
//        assertNull(position.getCreateDate());
//        assertNull(position.getExpireDate());
//        position.setCreateDateNow();
//        assertNotNull(position.getCreateDate());
//        position.setExpireDateNow();
//        assertNotNull(position.getExpireDate());
//        assertFalse(position.isWithinCreateAndExpireDatesNow());
//    }
//
//    @Test
//    public void createExpireDatesTest() {
//        Main.LOGGER.trace(".createExpireDatesTest()");
//        Position position = new Position();
//        assertNotNull(position);
//        assertNull(position.getCreateDate());
//        assertNull(position.getExpireDate());
//        DateTime createDate = DateTime.now().plusDays(-10);
//        position.setCreateDate(createDate);
//        assertEquals(createDate, position.getCreateDate());
//        DateTime expireDate = DateTime.now().plusDays(10);
//        position.setExpireDate(expireDate);
//        assertEquals(expireDate, position.getExpireDate());
//        DateTime checkDate = DateTime.now().plusDays(15);
//        assertFalse(position.isWithinCreateAndExpireDates(checkDate));
//        assertTrue(position.isWithinCreateAndExpireDatesNow());
//    }
//
//    @Test
//    public void setGetParentRootStaffTest() {
//        Main.LOGGER.trace(".setGetParentRootStaffTest()");
//        Position position = new Position();
//        assertNotNull(position);
//        assertNull(position.getRootStaff());
//        position.setId();
//        RootStaff rootStaff = new RootStaff();
//        rootStaff.addPosition(position);
//        Main.LOGGER.trace("rootStaff.addPosition({})", position);
//        position.setRootStaff(rootStaff);
//        Main.LOGGER.trace("position.setRootStaff({})", rootStaff);
//        assertEquals(rootStaff, position.getRootStaff());
//        rootStaff.removePosition(position.getId());
//        rootStaff = null;
//        Main.LOGGER.trace("position.setRootStaff(null)");
//        position.setRootStaff(rootStaff);
//        assertNull(position.getRootStaff());
//    }
//
//    @Test
//    public void updatePositionTest() {
//        Main.LOGGER.trace(".updatePOsitionTest()");
//        Position position = new Position();
//        assertNotNull(position);
//        assertNull(position.getRootStaff());
//        position.setId();
//        RootStaff rootStaff = new RootStaff();
//        rootStaff.addPosition(position);
//        Main.LOGGER.trace("rootStaff.addPosition({})", position);
//        Main.LOGGER.trace("position.setRootStaff({})", rootStaff);
//        position = rootStaff.getPosition(position.getId());
//        position.setName("RENAMED");
//        assertEquals(position, rootStaff.getPosition(position.getId()));
//    }
//
//    @Test(expected = IllegalStateException.class)
//    public void setGetParentRootStaffExceptionTest() {
//        Main.LOGGER.trace(".setGetParentRootStaffExceptionTest()");
//        Position position = new Position();
//        assertNotNull(position);
//        assertNull(position.getRootStaff());
//        position.setId();
//        RootStaff rootStaff = new RootStaff();
//        rootStaff.addPosition(position);
//        Main.LOGGER.trace("rootStaff.addPosition({})", position);
//        position.setRootStaff(rootStaff);
//        Main.LOGGER.trace("position.setRootStaff({})", rootStaff);
//        assertEquals(rootStaff, position.getRootStaff());
////        rootStaff.removePosition(position.getId()); // this line commented in an effort to result ISE
//        rootStaff = null;
//        Main.LOGGER.trace("position.setRootStaff(null)");
//        position.setRootStaff(rootStaff); // here should be IllegalStateException
//    }

}