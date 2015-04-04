package com.transporters;

import java.util.*;

/**
 * Class Office
 */
abstract public class Office {

    //
    // Fields
    //
    private String branch_name;
    private Address branch_address;
    private long volume_received;
    private long volume_dispatched;
    private int truck_avg_idle_time;
    private long revenue;
    private int avg_truck_waiting_time;
    private System local_system;
    private Truck available_truck_list;

    private Vector available_truck_listVector = new Vector();

    //
    // Constructors
    //
    public Office() {
    }

    ;
  
	//
	// Methods
	//


	//
	// Accessor methods
	//

	/**
	 * Set the value of branch_name
	 * @param newVar the new value of branch_name
	 */
  private void setBranch_name(String newVar) {
        branch_name = newVar;
    }

    /**
     * Get the value of branch_name
     *
     * @return the value of branch_name
     */
    private String getBranch_name() {
        return branch_name;
    }

    /**
     * Set the value of branch_address
     *
     * @param newVar the new value of branch_address
     */
    private void setBranch_address(Address newVar) {
        branch_address = newVar;
    }

    /**
     * Get the value of branch_address
     *
     * @return the value of branch_address
     */
    private Address getBranch_address() {
        return branch_address;
    }

    /**
     * Set the value of volume_received
     *
     * @param newVar the new value of volume_received
     */
    private void setVolume_received(long newVar) {
        volume_received = newVar;
    }

    /**
     * Get the value of volume_received
     *
     * @return the value of volume_received
     */
    private long getVolume_received() {
        return volume_received;
    }

    /**
     * Set the value of volume_dispatched
     *
     * @param newVar the new value of volume_dispatched
     */
    private void setVolume_dispatched(long newVar) {
        volume_dispatched = newVar;
    }

    /**
     * Get the value of volume_dispatched
     *
     * @return the value of volume_dispatched
     */
    private long getVolume_dispatched() {
        return volume_dispatched;
    }

    /**
     * Set the value of truck_avg_idle_time
     *
     * @param newVar the new value of truck_avg_idle_time
     */
    private void setTruck_avg_idle_time(int newVar) {
        truck_avg_idle_time = newVar;
    }

    /**
     * Get the value of truck_avg_idle_time
     *
     * @return the value of truck_avg_idle_time
     */
    private int getTruck_avg_idle_time() {
        return truck_avg_idle_time;
    }

    /**
     * Set the value of revenue
     *
     * @param newVar the new value of revenue
     */
    private void setRevenue(long newVar) {
        revenue = newVar;
    }

    /**
     * Get the value of revenue
     *
     * @return the value of revenue
     */
    private long getRevenue() {
        return revenue;
    }

    /**
     * Set the value of avg_truck_waiting_time
     *
     * @param newVar the new value of avg_truck_waiting_time
     */
    private void setAvg_truck_waiting_time(int newVar) {
        avg_truck_waiting_time = newVar;
    }

    /**
     * Get the value of avg_truck_waiting_time
     *
     * @return the value of avg_truck_waiting_time
     */
    private int getAvg_truck_waiting_time() {
        return avg_truck_waiting_time;
    }

    /**
     * Set the value of local_system
     *
     * @param newVar the new value of local_system
     */
    private void setLocal_system(System newVar) {
        local_system = newVar;
    }

    /**
     * Get the value of local_system
     *
     * @return the value of local_system
     */
    private System getLocal_system() {
        return local_system;
    }

    /**
     * Set the value of available_truck_list
     *
     * @param newVar the new value of available_truck_list
     */
    private void setAvailable_truck_list(Truck newVar) {
        available_truck_list = newVar;
    }

    /**
     * Get the value of available_truck_list
     *
     * @return the value of available_truck_list
     */
    private Truck getAvailable_truck_list() {
        return available_truck_list;
    }

    /**
     * Add a Available_truck_list object to the available_truck_listVector List
     */
    private void addAvailable_truck_list(Truck new_object) {
        available_truck_listVector.add(new_object);
    }

    /**
     * Remove a Available_truck_list object from available_truck_listVector List
     */
    private void removeAvailable_truck_list(Truck new_object) {
        available_truck_listVector.remove(new_object);
    }

    /**
     * Get the List of Available_truck_list objects held by
     * available_truck_listVector
     *
     * @return List of Available_truck_list objects held by
     * available_truck_listVector
     */
    private List getAvailable_truck_listList() {
        return (List) available_truck_listVector;
    }

    //
    // Other methods
    //
    /**
     * @param hours
     */
    public void setAvgTruckWaitingTime(int hours) {
    }

    /**
     * @return Timespan
     * @param truck_id
     */
    private int queryTruckAvgIdleTime(int truck_id) {//Make return to timespan
        return (0);
    }

    /**
     * @return long
     */
    private long queryVolumeReceived() {
        return 0;
    }

    /**
     * @return long
     */
    private long queryVolumeDispatched() {
        return 0;
    }

    /**
     * @return long
     */
    private long queryTotalVolumeHandled() {
        return 0;
    }

    /**
     * @return long
     */
    private long queryRevenue() {
        return 0;
    }

}
