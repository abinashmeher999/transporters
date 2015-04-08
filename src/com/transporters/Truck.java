package com.transporters;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
import java.io.Serializable;
>>>>>>> Data reading at the begin

/**
 * Class Truck
 */
public class Truck implements Serializable{

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

    public ArrayList<Consignment> getConsignment_list() {
        return consignment_list;
    }

    public void setConsignment_list(ArrayList<Consignment> consignment_list) {
        this.consignment_list = consignment_list;
    }
    private ArrayList<Consignment> consignment_list;
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
        consignment_list = new ArrayList<Consignment>();
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
    public void setId(int _id) {
        id = _id;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of status
     *
     * @param _status the new value of status
     */
    public void setStatus(Status _status) {
        status = _status;
    }

    /**
     * Get the value of status
     *
     * @return the value of status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Set the value of current_office
     *
     * @param _current_office the new value of current_office
     */
    public void setCurrentOffice(Office _current_office) {
        current_office = _current_office;
    }

    /**
     * Get the value of current_office
     *
     * @return the value of current_office
     */
    public Office getCurrentOffice() {
        return current_office;
    }

    /**
     * Get the value of MAX_CAPACITY
     *
     * @return the value of MAX_CAPACITY
     */
    public long getMax_capacity() {
        return MAX_CAPACITY;
    }

    /**
     * Set the value of total_km
     *
     * @param newVar the new value of total_km
     */
    public void setTotalKM(int newVar) {
        total_km = newVar;
    }

    /**
     * Get the value of total_km
     *
     * @return the value of total_km
     */
    public int getTotalKM() {//change return to timespan
        return total_km;
    }

    /**
     * Set the value of current_occupied_volume
     *
     * @param newVar the new value of current_occupied_volume
     */
    public void setCurrentOccupiedVolume(long newVar) {
        current_occupied_volume = newVar;
    }

    /**
     * Get the value of current_occupied_volume
     *
     * @return the value of current_occupied_volume
     */
    public long getCurrentOccupiedVolume() {
        return current_occupied_volume;
    }

    /**
     */
    public void Truck() {
    }

}
