package com.epam.java.rt.museco;

import com.epam.java.rt.museco.model.company.staff.Position;
import com.epam.java.rt.museco.model.company.staff.Staff;
import com.epam.java.rt.museco.model.general.Term;
import com.epam.java.rt.museco.service.marshal.DataMarshaller;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

/**
 * Municipal Service Company
 */
public class Main {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {

        Staff staff = new Staff();
        Position position = new Position();

        position.setId();
        position.setName("manager");
        position.setSalary(Money.of(CurrencyUnit.of("KZT"), 250000));
        position.setHourCost(Money.of(CurrencyUnit.of("KZT"), 5000));
        Term term = new Term();
        term.setBeginDate();
        position.setTerm(term);
        // position.setParentStaff();

        staff.setName("BI-SERVICE");
        staff.setDetail("SINCE 2014");
        staff.addPosition(position);
        System.out.println(staff);

        DataMarshaller dataMarshaller = new DataMarshaller();
        dataMarshaller.output(position);


    }
}
