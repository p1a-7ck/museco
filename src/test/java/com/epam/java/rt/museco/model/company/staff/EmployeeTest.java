package com.epam.java.rt.museco.model.company.staff;

import com.epam.java.rt.museco.Main;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * museco
 */
public class EmployeeTest {

    @Test
    public void initTest() {
        Main.LOGGER.trace(".initTest()");
        Employee employee = new Employee();
        assertNotNull(employee);
        assertNull(employee.getId());
        assertNull(employee.getFirstName());
        assertNull(employee.getMiddleName());
        assertNull(employee.getLastName());
        assertNull(employee.getFullName());
        assertNull(employee.getShortName());
        assertNull(employee.getCreateDate());
        assertNull(employee.getExpireDate());
        assertNull(employee.getRootStaff());
    }

    @Test
    public void setGetIdTest() {
        Main.LOGGER.trace(".setGetIdTest()");
        Employee employee = new Employee();
        assertNotNull(employee);
        assertNull(employee.getId());
        employee.setId();
        assertNotNull(employee.getId());
        UUID id = UUID.randomUUID();
        employee = new Employee();
        employee.setId(id);
        assertEquals(id, employee.getId());
    }

    @Test
    public void setGetNameTest() {
        Main.LOGGER.trace(".setGetNameTest()");
        Employee employee = new Employee();
        assertNotNull(employee);
        assertNull(employee.getFirstName());
        String name = "NAME";
        employee.setFirstName(name);
        assertEquals(name, employee.getFirstName());
        name = null;
        employee.setFirstName(name);
        assertNull(employee.getFirstName());
        name = "NAME";
        employee.setLastName(name);
        assertEquals(name, employee.getLastName());
        name = null;
        employee.setLastName(name);
        assertNull(employee.getLastName());
        name = "NAME";
        employee.setMiddleName(name);
        assertEquals(name, employee.getMiddleName());
        name = null;
        employee.setMiddleName(name);
        assertNull(employee.getMiddleName());
    }

    @Test
    public void createExpireDatesNowTest() {
        Main.LOGGER.trace(".createExpireDatesNowTest()");
        Employee employee = new Employee();
        assertNotNull(employee);
        assertNull(employee.getCreateDate());
        assertNull(employee.getExpireDate());
        employee.setCreateDateNow();
        assertNotNull(employee.getCreateDate());
        employee.setExpireDateNow();
        assertNotNull(employee.getExpireDate());
        assertFalse(employee.isWithinCreateAndExpireDatesNow());
    }

    @Test
    public void createExpireDatesTest() {
        Main.LOGGER.trace(".createExpireDatesTest()");
        Employee employee = new Employee();
        assertNotNull(employee);
        assertNull(employee.getCreateDate());
        assertNull(employee.getExpireDate());
        DateTime createDate = DateTime.now().plusDays(-10);
        employee.setCreateDate(createDate);
        assertEquals(createDate, employee.getCreateDate());
        DateTime expireDate = DateTime.now().plusDays(10);
        employee.setExpireDate(expireDate);
        assertEquals(expireDate, employee.getExpireDate());
        DateTime checkDate = DateTime.now().plusDays(15);
        assertFalse(employee.isWithinCreateAndExpireDates(checkDate));
        assertTrue(employee.isWithinCreateAndExpireDatesNow());
    }

    @Test
    public void setGetParentRootStaffTest() {
        Main.LOGGER.trace(".setGetParentRootStaffTest()");
        Employee employee = new Employee();
        assertNotNull(employee);
        assertNull(employee.getRootStaff());
        employee.setId();
        RootStaff rootStaff = new RootStaff();
        rootStaff.addEmployee(employee);
        Main.LOGGER.trace("rootStaff.addEmployee({})", employee);
        employee.setRootStaff(rootStaff);
        Main.LOGGER.trace("employee.setRootStaff({})", rootStaff);
        assertEquals(rootStaff, employee.getRootStaff());
        rootStaff.removeEmployee(employee.getId());
        rootStaff = null;
        Main.LOGGER.trace("employee.setRootStaff(null)");
        employee.setRootStaff(rootStaff);
        assertNull(employee.getRootStaff());
    }

    @Test
    public void updateEmployeeTest() {
        Main.LOGGER.trace(".updatePOsitionTest()");
        Employee employee = new Employee();
        assertNotNull(employee);
        assertNull(employee.getRootStaff());
        employee.setId();
        RootStaff rootStaff = new RootStaff();
        rootStaff.addEmployee(employee);
        Main.LOGGER.trace("rootStaff.addEmployee({})", employee);
        Main.LOGGER.trace("employee.setRootStaff({})", rootStaff);
        employee = rootStaff.getEmployee(employee.getId());
        employee.setFirstName("RENAMED");
        assertEquals(employee, rootStaff.getEmployee(employee.getId()));
    }

    @Test(expected = IllegalStateException.class)
    public void setGetParentRootStaffExceptionTest() {
        Main.LOGGER.trace(".setGetParentRootStaffExceptionTest()");
        Employee employee = new Employee();
        assertNotNull(employee);
        assertNull(employee.getRootStaff());
        employee.setId();
        RootStaff rootStaff = new RootStaff();
        rootStaff.addEmployee(employee);
        Main.LOGGER.trace("rootStaff.addEmployee({})", employee);
        employee.setRootStaff(rootStaff);
        Main.LOGGER.trace("employee.setRootStaff({})", rootStaff);
        assertEquals(rootStaff, employee.getRootStaff());
//        rootStaff.removeEmployee(employee.getId()); // this line commented in an effort to result ISE
        rootStaff = null;
        Main.LOGGER.trace("employee.setRootStaff(null)");
        employee.setRootStaff(rootStaff); // here should be IllegalStateException
    }

}