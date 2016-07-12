package com.epam.java.rt.museco.service.marshal;

import com.epam.java.rt.museco.model.company.staff.Staff;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Municipal Service Company
 */
public final class StaffAdapter extends XmlAdapter<String, Staff> {


    public Staff unmarshal(String v) throws Exception {
        return null;//
    }

    public String marshal(Staff v) throws Exception {
        return v.getName();
    }
}
