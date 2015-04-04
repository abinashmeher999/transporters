package com.transporters;

/**
 * Class Truck
 */
public class Truck {

    //
    // Fields
    //
    enum Status {

        AVAILABLE,
        DISPATCHABLE,
        ENROUTE
    }

    private int id;
    private Status status = Status.AVAILABLE;
    private Office current_office;
    private long max_capacity = 500;
    private int usage = 0;//TODO : change the type
    private long current_occupancy;

    private Office m_current_office;

    //
    // Constructors
    //
    public Truck() {
    }

    ;
  
	//
	// Methods
	//


	//
	// Accessor methods
	//

	/**
	 * Set the value of id
	 * @param newVar the new value of id
	 */
  private void setId(int newVar) {
        id = newVar;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    private int getId() {
        return id;
    }

    /**
     * Set the value of status
     *
     * @param newVar the new value of status
     */
    private void setStatus(Status newVar) {
        status = newVar;
    }

    /**
     * Get the value of status
     *
     * @return the value of status
     */
    private Status getStatus() {
        return status;
    }

    /**
     * Set the value of current_office
     *
     * @param newVar the new value of current_office
     */
    private void setCurrent_office(Office newVar) {
        current_office = newVar;
    }

    /**
     * Get the value of current_office
     *
     * @return the value of current_office
     */
    private Office getCurrent_office() {
        return current_office;
    }

    /**
     * Set the value of max_capacity
     *
     * @param newVar the new value of max_capacity
     */
    private void setMax_capacity(long newVar) {
        max_capacity = newVar;
    }

    /**
     * Get the value of max_capacity
     *
     * @return the value of max_capacity
     */
    private long getMax_capacity() {
        return max_capacity;
    }

    /**
     * Set the value of usage
     *
     * @param newVar the new value of usage
     */
    private void setUsage(int newVar) {
        usage = newVar;
    }

    /**
     * Get the value of usage
     *
     * @return the value of usage
     */
    private int getUsage() {//change return to timespan
        return usage;
    }

    /**
     * Set the value of current_occupancy
     *
     * @param newVar the new value of current_occupancy
     */
    private void setCurrent_occupancy(long newVar) {
        current_occupancy = newVar;
    }

    /**
     * Get the value of current_occupancy
     *
     * @return the value of current_occupancy
     */
    private long getCurrent_occupancy() {
        return current_occupancy;
    }

    /**
     * @param _volume
     */
    public void setCurrentOccupancy(int _volume) {
    }

    /**
     * @return long
     */
    public long getCurrentOccupancy() {
        return current_occupancy;
    }

    /**
     */
    public void Truck() {
    }

}
