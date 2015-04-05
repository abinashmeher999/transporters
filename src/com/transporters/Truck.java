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

    private static final long MAX_CAPACITY = 500;

    private int id;
    private Status status;
    private Office current_office;
    private Office destination_office;
    private int total_km;
    private long current_occupied_volume;

    //
    // Constructors
    //
    public Truck() {
        id = -1;
        this.status = Status.AVAILABLE;
        current_office = null;
        destination_office = null;
        total_km = 0;
        current_occupied_volume = 0;
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
     * @param _id the new value of id
     */
    private void setId(int _id) {
        id = _id;
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
     * @param _status the new value of status
     */
    private void setStatus(Status _status) {
        status = _status;
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
     * @param _current_office the new value of current_office
     */
    private void setCurrentOffice(Office _current_office) {
        current_office = _current_office;
    }

    /**
     * Get the value of current_office
     *
     * @return the value of current_office
     */
    private Office getCurrentOffice() {
        return current_office;
    }

    /**
     * Get the value of MAX_CAPACITY
     *
     * @return the value of MAX_CAPACITY
     */
    private long getMax_capacity() {
        return MAX_CAPACITY;
    }

    /**
     * Set the value of total_km
     *
     * @param newVar the new value of total_km
     */
    private void setTotalKM(int newVar) {
        total_km = newVar;
    }

    /**
     * Get the value of total_km
     *
     * @return the value of total_km
     */
    private int getTotalKM() {//change return to timespan
        return total_km;
    }

    /**
     * Set the value of current_occupied_volume
     *
     * @param newVar the new value of current_occupied_volume
     */
    private void setCurrentOccupiedVolume(long newVar) {
        current_occupied_volume = newVar;
    }

    /**
     * Get the value of current_occupied_volume
     *
     * @return the value of current_occupied_volume
     */
    private long getCurrentOccupiedVolume() {
        return current_occupied_volume;
    }

    /**
     */
    public void Truck() {
    }

}
