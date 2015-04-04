package com.transporters;

/**
 * Class Address
 */
public class Address {

    //
    // Fields
    //
    private String street;
    private String city;

    //
    // Constructors
    //
    public Address() {
    }

    ;
  
	//
	// Methods
	//


	//
	// Accessor methods
	//

	/**
	 * Set the value of street
	 * @param newVar the new value of street
	 */
  private void setStreet(String newVar) {
        street = newVar;
    }

    /**
     * Get the value of street
     *
     * @return the value of street
     */
    private String getStreet() {
        return street;
    }

    /**
     * Set the value of city
     *
     * @param newVar the new value of city
     */
    private void setCity(String newVar) {
        city = newVar;
    }

    /**
     * Get the value of city
     *
     * @return the value of city
     */
    private String getCity() {
        return city;
    }

    //
    // Other methods
    //
    /**
     * @param _street
     * @param _city
     */
    public void Address(String _street, String _city) {
    }

}
