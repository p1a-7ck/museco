package com.epam.java.rt.museco.service.marshal;

import com.epam.java.rt.museco.model.company.staff.RootStaff;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Municipal Service Company
 */
public final class StaffAdapter extends XmlAdapter<String, RootStaff> {

    public RootStaff unmarshal(String v) throws Exception {
        return null;//
    }

    public String marshal(RootStaff v) throws Exception {
        return v.getName();
    }
}
