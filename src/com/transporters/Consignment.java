package com.transporters;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Class Consignment
 */
public class Consignment implements Serializable{

    //
    // Fields
    //
    public enum Status {

        PENDING,
        ENROUTE,
        DELIVERED
    };
    
    public enum DeliveryType{
        
        EXPRESS,
        REGULAR
    };
    
    private int id;
    private long waiting_time;
    private double volume;
    private int distance;
    private static double charge;
    private int pieces;
    private String name_sender;
    private String name_receiver;
    private String name_billing;
    private String address_sender;
    private String address_receiver;
    private String address_billing;
    private Status status_delivery;
    private List<Truck> carrier_trucks;
    private DeliveryType type_delivery;
    private Calendar entry_date;
    private Branch to_branch;
    private Branch from_branch;

    public Branch getTo_branch() {
        return to_branch;
    }

    public void setTo_branch(Branch to_branch) {
        this.to_branch = to_branch;
    }

    public Branch getFrom_branch() {
        return from_branch;
    }

    public void setFrom_branch(Branch from_branch) {
        this.from_branch = from_branch;
    }
 
    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }
    
    public Calendar getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Calendar entry_date) {
        this.entry_date = entry_date;
    }

    public String getName_billing() {
        return name_billing;
    }

    public void setName_billing(String name_billing) {
        this.name_billing = name_billing;
    }

    public String getAddress_billing() {
        return address_billing;
    }

    public void setAddress_billing(String address_billing) {
        this.address_billing = address_billing;
    }

    public List<Truck> getCarrier_trucks() {
        return carrier_trucks;
    }

    public void setCarrier_trucks(List<Truck> carrier_trucks) {
        this.carrier_trucks = carrier_trucks;
    }

    public DeliveryType getType_delivery() {
        return type_delivery;
    }

    //
    public void setType_delivery(DeliveryType type_delivery) {
        this.type_delivery = type_delivery;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int _distance) {
        // To Do : Get from distance matrix in database
        this.distance = distance;
    }
    public static double getCharge() {
        return charge;
    }

    public static void setCharge(double charge) {
        Consignment.charge = charge;
    }
    // Constructors
    //
    public Consignment(){
        this.id = -1;
        this.waiting_time = 0;
        this.volume = 0;
        this.name_sender = "0";
        this.name_receiver = "0";
        this.name_billing = "0";
        this.address_sender = null;
        this.address_receiver = null;
        this.address_billing = null;
        this.status_delivery = Status.PENDING;
        this.type_delivery = DeliveryType.REGULAR;
        this.pieces = 1;
        this.carrier_trucks = new ArrayList<Truck>();
        this.entry_date = Calendar.getInstance();
    }
    public Consignment(int id) {
        this.id = id;
        this.waiting_time = 0;
        this.volume = 0;
        this.name_sender = "0";
        this.name_receiver = "0";
        this.name_billing = "0";
        this.address_sender = null;
        this.address_receiver = null;
        this.address_billing = null;
        this.status_delivery = Status.PENDING;
        this.type_delivery = DeliveryType.REGULAR;
        this.pieces = 1;
        this.carrier_trucks = new ArrayList<Truck>();
        this.entry_date = Calendar.getInstance();
    }
  
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
    public void setWaiting_time(long _waiting_time) {
        waiting_time = _waiting_time;
    }

    /**
     * Get the value of waiting_time
     *
     * @return the value of waiting_time
     */
    public long getWaiting_time() {
        waiting_time = (Calendar.getInstance().getTimeInMillis() - getEntry_date().getTimeInMillis())/1000;
        return waiting_time;
    }

    /**
     * Set the value of volume
     *
     * @param _volume the new value of volume
     */
    public void setVolume(double _volume) {
        volume = _volume;
    }

    /**
     * Get the value of volume
     *
     * @return the value of volume
     */
    public double getVolume() {
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
    public void setAddress_sender(String _sender_address) {
        address_sender = _sender_address;
    }

    /**
     * Get the value of address_sender
     *
     * @return the value of address_sender
     */
    public String getAddress_sender() {
        return address_sender;
    }

    /**
     * Set the value of address_receiver
     *
     * @param _receiver_address the new value of address_receiver
     */
    public void setAddress_receiver(String _receiver_address) {
        address_receiver = _receiver_address;
    }

    /**
     * Get the value of address_receiver
     *
     * @return the value of address_receiver
     */
    public String getAddress_receiver() {
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

    public int getId() {
        return id;        
    }

    //
    // Other methods
    //
    public void setId(int id) {
        this.id = id;
    }

    public double computeBill() {
        return 100*volume*getDistance();        
    }
    
    private static final long serialVersionUID = 8927227389351703299L;

}
