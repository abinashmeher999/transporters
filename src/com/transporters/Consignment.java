package com.transporters;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Consignment
 */
public class Consignment {

    //
    // Fields
    //
    enum Status {

        PENDING,
        ENROUTE,
        DELIVERED
    };

    private int id;
    private Time waiting_time;
    private long volume;
    private String name_sender;
    private String name_receiver;
    private String name_billing;
    private Address address_sender;
    private Address address_receiver;
    private Address address_billing;
    private Status status_delivery;
    private List<Truck> carrier_trucks;

    //
    // Constructors
    //
    public Consignment() {
        this.id = -1;
        this.waiting_time = new Time(0);
        this.volume = 0;
        this.name_sender = "0";
        this.name_receiver = "0";
        this.name_billing = "0";
        this.address_sender = null;
        this.address_receiver = null;
        this.address_billing = null;
        this.status_delivery = Status.PENDING;
        this.carrier_trucks = new ArrayList<Truck>();
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
     * @param _consignment_id the new value of id
     */
    public void setConsignment_id(int _consignment_id) {
        id = _consignment_id;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getConsignment_id() {
        return id;
    }

    /**
     * Set the value of waiting_time
     *
     * @param _waiting_time the new value of waiting_time
     */
    public void setWaiting_time(Time _waiting_time) {
        waiting_time = _waiting_time;
    }

    /**
     * Get the value of waiting_time
     *
     * @return the value of waiting_time
     */
    public Time getWaiting_time() {
        return waiting_time;
    }

    /**
     * Set the value of volume
     *
     * @param _volume the new value of volume
     */
    public void setVolume(long _volume) {
        volume = _volume;
    }

    /**
     * Get the value of volume
     *
     * @return the value of volume
     */
    public long getVolume() {
        return volume;
    }

    /**
     * Set the value of name_sender
     *
     * @param _sender_name the new value of name_sender
     */
    public void setName_sender(String _sender_name) {
        name_sender = _sender_name;
    }

    /**
     * Get the value of name_sender
     *
     * @return the value of name_sender
     */
    public String getName_sender() {
        return name_sender;
    }

    /**
     * Set the value of name_receiver
     *
     * @param _receiver_name the new value of name_receiver
     */
    public void setName_receiver(String _receiver_name) {
        name_receiver = _receiver_name;
    }

    /**
     * Get the value of name_receiver
     *
     * @return the value of name_receiver
     */
    public String getName_receiver() {
        return name_receiver;
    }

    /**
     * Set the value of address_sender
     *
     * @param _sender_address the new value of address_sender
     */
    public void setAddress_sender(Address _sender_address) {
        address_sender = _sender_address;
    }

    /**
     * Get the value of address_sender
     *
     * @return the value of address_sender
     */
    public Address getAddress_sender() {
        return address_sender;
    }

    /**
     * Set the value of address_receiver
     *
     * @param _receiver_address the new value of address_receiver
     */
    public void setAddress_receiver(Address _receiver_address) {
        address_receiver = _receiver_address;
    }

    /**
     * Get the value of address_receiver
     *
     * @return the value of address_receiver
     */
    public Address getAddress_receiver() {
        return address_receiver;
    }

    /**
     * Set the value of status_delivery
     *
     * @param newVar the new value of status_delivery
     */
    public void setStatus_delivery(Status newVar) {
        status_delivery = newVar;
    }

    /**
     * Get the value of status_delivery
     *
     * @return the value of status_delivery
     */
    public Status getStatus_delivery() {
        return status_delivery;
    }

    //
    // Other methods
    //
    /**
     * @param _id
     * @param _volume
     * @param _receiver_name
     * @param _receiver_address
     * @param _sender_name
     * @param _sender_address
     */
    public void Consignment(int _id,
            long _volume,
            String _receiver_name,
            Address _receiver_address,
            String _sender_name,
            Address _sender_address) {
    }

    /**
     * @return int
     */
    public int getWaitingTime() {
        return 0;
    }

    /**
     * @param hours
     */
    public void setWaitingTime(int hours) {
    }

    /**
     * @param volume
     */
    public void setVolume(int volume) {
    }

    /**
     * @param name
     */
    public void setSenderName(String name) {
    }

    /**
     * @return String
     */
    public String getSenderName() {
        return name_sender;
    }

    /**
     * @param address
     */
    public void setSenderAddress(Address address) {
    }

    /**
     * @return Address
     */
    public Address getSenderAddress() {
        return null;
    }

    /**
     * @param name
     */
    public void setReceiverName(String name) {
    }

    /**
     * @return String
     */
    public String getReceiverName() {
        return name_receiver;
    }

    /**
     * @param address
     */
    public void setReceiverAddress(Address address) {
    }

    /**
     * @return Address
     */
    public Address getRecevierAddress() {
        return address_receiver;
    }

    /**
     * @param _status
     */
    public void setDeliveryStatus(Status _status) {
        status_delivery = _status;
    }

    /**
     * @return StatusDelivery
     */
    public Status getDeliveryStatus() {
        return status_delivery;
    }

    /**
     * @return long
     */
    public long computeBill() {
        return 0;
    }

    /**
     */
    public void printBill() {
        String bill = null;
        bill.concat("Consignment: "+Integer.toString(id)+"\n");
        //similarly for others
        
    }

}
