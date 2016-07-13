package com.epam.java.rt.museco.model.general;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * museco
 */
public class TermTest {
    @Test
    public void createTermTest() {
        Termable term = new Term();
        assertNotNull(term);
//        term = term.setBeginDate(new Date());
        assertNull(term.getBeginDate());
//        term = term.setExpireDate(new Date());
        assertNull(term.getExpireDate());
        assertFalse(term.withinDate());
        assertFalse(term.withinDate(new Date()));
    }
}