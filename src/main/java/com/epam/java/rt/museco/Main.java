package com.epam.java.rt.museco;

import com.epam.java.rt.museco.model.company.staff.RootStaff;
import com.epam.java.rt.museco.model.company.staff.Position;
import com.epam.java.rt.museco.service.marshal.DataMarshaller;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

/**
 * Municipal Service Company
 */
public class Main {
    public final static Logger LOGGER = LoggerFactory.getLogger("LOGGER");
    public static void main(String[] args) throws JAXBException, FileNotFoundException {

        RootStaff rootStaff = new RootStaff();
        Position position = new Position();

        position.setId();
        position.setName("manager");
        position.setSalary(Money.of(CurrencyUnit.of("KZT"), 250000));
        position.setHourCost(Money.of(CurrencyUnit.of("KZT"), 5000));
//        Term term = new Term();
//        term.setBeginDate();
//        position.setTerm(term);
        // position.setParentRootStaff();

        rootStaff.setName("BI-SERVICE");
        rootStaff.setDetail("SINCE 2014");
        rootStaff.addPosition(position);
        System.out.println(rootStaff);

        DataMarshaller dataMarshaller = new DataMarshaller();
        dataMarshaller.output(position);

        dataMarshaller.output(rootStaff);

    }
}
