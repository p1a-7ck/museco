package com.epam.java.rt.museco.model.general;

import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Person {
    private UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private String middleName;

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
