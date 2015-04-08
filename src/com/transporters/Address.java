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
    private String city;

    //
    // Constructors
    //
    /**
     * @param _contact
     * @param _street
     * @param _city
     */
    public Address(String _contact, String _street, String _city) {
        contact = _contact;
        street = _street;
        city = _city;
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

    /**
     * Set the value of city
     *
     * @param newVar the new value of city
     */
    public void setCity(String newVar) {
        city = newVar;
    }

    /**
     * Get the value of city
     *
     * @return the value of city
     */
    public String getCity() {
        return city;
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
