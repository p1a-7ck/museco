package com.epam.java.rt.museco.model.general;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Municipal Service Company
 * Should be used as a base class for child entities, which should store
 * first name, last name and middle name, and should return concatenated
 * name value
 */
public class PersonName {
    private final static Logger PERSON_NAME_LOG = LoggerFactory.getLogger(PersonName.class);
    private String firstName;
    private String lastName;
    private String middleName;

    public PersonName() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
        PERSON_NAME_LOG.info("First name set to {}", this.firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
        PERSON_NAME_LOG.info("Last name set to {}", this.lastName);
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName.trim();
        PERSON_NAME_LOG.info("Middle name set to {}", this.middleName);

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

    public void copyOf(PersonName personName) {
        this.firstName = personName.firstName;
        this.lastName = personName.lastName;
        this.middleName = personName.middleName;
        PERSON_NAME_LOG.info("Person name made copy of {}", this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonName that = (PersonName) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        return middleName != null ? middleName.equals(that.middleName) : that.middleName == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonName{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }
}
