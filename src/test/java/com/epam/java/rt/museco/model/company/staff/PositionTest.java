package com.epam.java.rt.museco.model.company.staff;

import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * museco
 */
public class PositionTest {

    @Test
    public void createExpireDatesNowTest() {
        Position position = new Position();
        assertNotNull(position);
        assertNull(position.getCreateDate());
        assertNull(position.getExpireDate());
        position.setCreateDateNow();
        assertNotNull(position.getCreateDate());
        position.setExpireDateNow();
        assertNotNull(position.getExpireDate());
        assertFalse(position.isWithinCreateAndExpireDatesNow());
    }

    @Test
    public void createExpireDatesTest() {
        Position position = new Position();
        assertNotNull(position);
        assertNull(position.getCreateDate());
        assertNull(position.getExpireDate());
        DateTime createDate = DateTime.now().plusDays(-10);
        position.setCreateDate(createDate);
        assertEquals(createDate, position.getCreateDate());
        DateTime expireDate = DateTime.now().plusDays(10);
        position.setExpireDate(expireDate);
        assertEquals(expireDate, position.getExpireDate());
        DateTime checkDate = DateTime.now().plusDays(15);
        assertFalse(position.isWithinCreateAndExpireDates(checkDate));
        assertTrue(position.isWithinCreateAndExpireDatesNow());
    }


}