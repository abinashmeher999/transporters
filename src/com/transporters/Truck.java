package com.transporters;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * Class Truck
 */
public class Truck implements Serializable {

    //
    // Fields
    //
    public enum Status {

        AVAILABLE,
        DISPATCHABLE,
        ENROUTE
    }

    public static final long MAX_CAPACITY = 500;

    private String plate_number;
    private int id;
    private double cost;
    private Status status;
    private Office current_office;
    private Office destination_office;
    private int total_km;
    private long current_occupied_volume;
    private ArrayList<Consignment> consignment_list;

    //
    // Constructors
    //
    public Truck(int _id) {
        id = _id;
        plate_number = null;
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

    public String getPlate_number() {
        return plate_number;
    }

    public void setPlate_number(String plate_number) {
        this.plate_number = plate_number;
    }

    public Office getCurrent_office() {
        return current_office;
    }

    public void setCurrent_office(Office current_office) {
        this.current_office = current_office;
    }

    public Office getDestination_office() {
        return destination_office;
    }

    public void setDestination_office(Office destination_office) {
        this.destination_office = destination_office;
    }

    public int getTotal_km() {
        return total_km;
    }

    public void setTotal_km(int total_km) {
        this.total_km = total_km;
    }

    public long getCurrent_occupied_volume() {
        return current_occupied_volume;
    }

    public void setCurrent_occupied_volume(long current_occupied_volume) {
        this.current_occupied_volume = current_occupied_volume;
    }

    public ArrayList<Consignment> getConsignment_list() {
        return consignment_list;
    }

    public void setConsignment_list(ArrayList<Consignment> consignment_list) {
        this.consignment_list = consignment_list;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double _cost) {
        cost = _cost;
    }

    public int getId() {
        return id;
    }
    
    private static final long serialVersionUID = 4097235281089254672L;
}
