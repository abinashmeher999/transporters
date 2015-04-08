package com.transporters;

import java.io.Serializable;

/**
 * Class Employee
 */
public class Employee implements Serializable{

    //
    // Fields
    //
    private int employee_id;
    private String name;

    //
    // Constructors
    //
    public Employee() {
    }

    ;
  
	//
	// Methods
	//


	//
	// Accessor methods
	//

	/**
	 * Set the value of employee_id
	 * @param newVar the new value of employee_id
	 */
  private void setEmployee_id(int newVar) {
        employee_id = newVar;
    }

    /**
     * Get the value of employee_id
     *
     * @return the value of employee_id
     */
    private int getEmployee_id() {
        return employee_id;
    }

    /**
     * Set the value of name
     *
     * @param newVar the new value of name
     */
    private void setName(String newVar) {
        name = newVar;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    private String getName() {
        return name;
    }

    //
    // Other methods
    //
    /**
     */
    public void enterConsignementDetails() {
    }

    /**
     * @return boolean
     * @param _truck_id
     */
    public boolean dispatchTruck(int _truck_id) {
        return false;
    }

    /**
     * @return boolean
     * @param _truck_id
     */
    public boolean receiveTruck(int _truck_id) {
        return false;
    }

    /**
     * @return String
     */
    public String getID() {
        return null;
    }
    private static final long serialVersionUID = -2672229822413412984L;

}
