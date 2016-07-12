package com.epam.java.rt.museco.service.marshal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Municipal Service Company
 */
public class DataMarshaller {
    public DataMarshaller() {
    }

    private String className(String classFullName) {
        StringBuilder resultName = new StringBuilder(classFullName);
        int pointIndex = resultName.indexOf(".");
        while (pointIndex >= 0) {
            resultName = resultName.delete(0, pointIndex + 1);
            pointIndex = resultName.indexOf(".");
        }
        return resultName.toString();
    }

    public boolean output(Object sourceObject) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(sourceObject.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(sourceObject,
                new FileOutputStream("repository/".
                        concat(this.className(sourceObject.getClass().toString())).
                        concat(".xml")));
        return true;
    }
}
