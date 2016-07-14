package com.epam.java.rt.museco.model.general;

import java.util.UUID;

/**
 * Municipal Service Company
 * Should be used as a base class for child entities, which should store
 * first name, last name and middle name, and should return concatenated
 * name value
 */
public class BasePerson {
    private UUID id;
    private String firstName;
    private String lastName;
    private String middleName;

    public BasePerson() {
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public void setId(UUID id) {
        if (id == null) this.id = UUID.randomUUID();
        else this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName.trim();
    }

    public String getShortName() {
        return (this.firstName != null && this.lastName != null) ? this.firstName.concat(" ").concat(this.lastName) :
                ((this.firstName != null) ? this.firstName : this.lastName);
    }

    public String getFullName() {
        return (this.firstName != null && this.lastName != null && this.middleName != null) ?
                this.firstName.concat(" ").concat(this.middleName).concat(" ").concat(this.lastName) :
                ((this.middleName == null ) ? this.getShortName() :
                        ((this.firstName != null) ? this.firstName.concat(" ").concat(this.middleName) :
                                this.lastName.concat(" ").concat(this.middleName)));
    }
}
