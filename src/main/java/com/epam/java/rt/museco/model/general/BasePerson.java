package com.epam.java.rt.museco.model.general;

/**
 * Municipal Service Company
 * Should be used as a base class for child entities, which should store
 * first name, last name and middle name, and should return concatenated
 * name value
 */
public abstract class BasePerson {
    private String firstName;
    private String lastName;
    private String middleName;

    public BasePerson() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) this.firstName = null;
        else this.firstName = firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) this.lastName = null;
        else this.lastName = lastName.trim();
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        if (middleName == null) this.middleName = null;
        else this.middleName = middleName.trim();
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
