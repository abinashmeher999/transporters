package com.transporters;

import java.io.Serializable;

/**
 * Class Address
 */
public class Address implements Serializable{

    //
    // Fields
    //
    private String contact;
    private String street;

    //
    // Constructors
    //
    /**
     * @param _contact
     * @param _street
     */
    public Address(String _contact, String _street) {
        contact = _contact;
        street = _street;
    }

    //
    // Methods
    //
    //
    // Accessor methods
    //
    /**
     * Set the value of street
     *
     * @param newVar the new value of street
     */
    public void setStreet(String newVar) {
        street = newVar;
    }

    /**
     * Get the value of street
     *
     * @return the value of street
     */
    public String getStreet() {
        return street;
    }

    public void setContact(String _contact) {
        contact = _contact;
    }

    public String getContact() {
        return contact;
    }

    //
    // Other methods
    //
}
