package com.transporters;

import java.sql.Time;
import java.util.*;

/**
 * Class Office
 */
abstract public class Office {

    //
    // Fields
    //
    private String name;
    private Address address;
    private long volume_received;
    private long volume_dispatched;
    private long cumulative_truck_count;
    private Time truck_avg_idle_time;
    private long revenue;
    private Time avg_consignment_waiting_time;
    private Database database;

    private List<Truck> available_truck_list;

    //
    // Constructors
    //
    public Office(String _office_name, Address _office_address) {
        name = _office_name;
        address = _office_address;
        volume_received = 0;
        volume_dispatched = 0;
        cumulative_truck_count = 0;
        truck_avg_idle_time = new Time(0);
        revenue = 0;
        avg_consignment_waiting_time = new Time(0);
        this.available_truck_list = new ArrayList<>();
    }

    ;
  
	//
	// Methods
	//


	//
	// Accessor methods
	//

    /**
     * Set the value of name
     * @param newVar the new value of name
     */
    public void setName(String newVar) {
        name = newVar;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of address
     *
     * @param _office_address the new value of address
     */
    public void setAddress(Address _office_address) {
        address = _office_address;
    }

    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Set the value of volume_received
     *
     * @param _volume the new value of volume_received
     */
    public void setVolume_received(long _volume) {
        volume_received = _volume;
    }

    /**
     * Get the value of volume_received
     *
     * @return the value of volume_received
     */
    public long getVolume_received() {
        return volume_received;
    }

    /**
     * Set the value of volume_dispatched
     *
     * @param _volume_dispatched the new value of volume_dispatched
     */
    public void setVolume_dispatched(long _volume_dispatched) {
        volume_dispatched = _volume_dispatched;
    }

    /**
     * Get the value of volume_dispatched
     *
     * @return the value of volume_dispatched
     */
    public long getVolume_dispatched() {
        return volume_dispatched;
    }

    /**
     * Set the value of truck_avg_idle_time
     *
     * @param _avg_idle_time the new value of truck_avg_idle_time
     */
    public void setTruck_avg_idle_time(Time _avg_idle_time) {
        truck_avg_idle_time = _avg_idle_time;
    }

    /**
     * Get the value of truck_avg_idle_time
     *
     * @return the value of truck_avg_idle_time
     */
    public Time getTruck_avg_idle_time() {
        return truck_avg_idle_time;
    }

    /**
     * Set the value of revenue
     *
     * @param _revenue the new value of revenue
     */
    public void setRevenue(long _revenue) {
        revenue = _revenue;
    }

    /**
     * Get the value of revenue
     *
     * @return the value of revenue
     */
    public long getRevenue() {
        return revenue;
    }

    /**
     * Set the value of avg_consignment_waiting_time
     *
     * @param _avg_consignment_waiting_time the new avg_consignment_waiting_time
     */
    public void setAvgConsignmentWaitingTime(Time _avg_consignment_waiting_time) {
        avg_consignment_waiting_time = _avg_consignment_waiting_time;
    }

    /**
     * Get the value of avg_consignment_waiting_time
     *
     * @return the value of avg_consignment_waiting_time
     */
    public Time getAvgConsignmentWaitingTime() {
        return avg_consignment_waiting_time;
    }

    /**
     * Set the value of available_truck_list
     *
     * @param _new_truck_list the new value of available_truck_list
     */
    public void setAvailable_truck_list(List<Truck> _new_truck_list) {
        available_truck_list = _new_truck_list;
    }

    /**
     * Get the value of available_truck_list
     *
     * @return the value of available_truck_list
     */
    public List<Truck> getAvailable_truck_list() {
        return available_truck_list;
    }

    /**
     * Add a Available_truck_list object to the available_truck_listVector List
     *
     * @param new_object
     */
    public void addAvailable_truck_list(Truck new_object) {
        available_truck_list.add(new_object);
    }

    /**
     * Remove a Available_truck_list object from available_truck_listVector List
     *
     * @param new_object
     */
    public void removeAvailable_truck_list(Truck new_object) {
        available_truck_list.remove(new_object);
    }

    //
    // Other methods
    //
    public long getCumulative_truck_count() {
        return cumulative_truck_count;
    }

    public void setCumulative_truck_count(long cumulative_truck_count) {
        this.cumulative_truck_count = cumulative_truck_count;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }
}
