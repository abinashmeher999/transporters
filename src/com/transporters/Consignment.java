package com.transporters;

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

    private int consignment_id;
    private int waiting_time = Integer.MAX_VALUE;
    private long volume = 0;
    private String name_sender;
    private String name_receiver;
    private Address address_sender;
    private Address address_receiver;
    private Status status_delivery = Status.PENDING;

    //
    // Constructors
    //
    public Consignment() {
    }

    ;
  
	//
	// Methods
	//


	//
	// Accessor methods
	//

	/**
	 * Set the value of consignment_id
	 * @param newVar the new value of consignment_id
	 */
        private void setConsignement_id(int newVar) {
        consignment_id = newVar;
    }

    /**
     * Get the value of consignment_id
     *
     * @return the value of consignment_id
     */
    private int getConsignement_id() {
        return consignment_id;
    }

    /**
     * Set the value of waiting_time
     *
     * @param newVar the new value of waiting_time
     */
    private void setWaiting_time(int newVar) {
        waiting_time = newVar;
    }

    /**
     * Get the value of waiting_time
     *
     * @return the value of waiting_time
     */
    private int getWaiting_time() {
        return waiting_time;
    }

    /**
     * Set the value of volume
     *
     * @param newVar the new value of volume
     */
    private void setVolume(long newVar) {
        volume = newVar;
    }

    /**
     * Get the value of volume
     *
     * @return the value of volume
     */
    private long getVolume() {
        return volume;
    }

    /**
     * Set the value of name_sender
     *
     * @param newVar the new value of name_sender
     */
    private void setName_sender(String newVar) {
        name_sender = newVar;
    }

    /**
     * Get the value of name_sender
     *
     * @return the value of name_sender
     */
    private String getName_sender() {
        return name_sender;
    }

    /**
     * Set the value of name_receiver
     *
     * @param newVar the new value of name_receiver
     */
    private void setName_receiver(String newVar) {
        name_receiver = newVar;
    }

    /**
     * Get the value of name_receiver
     *
     * @return the value of name_receiver
     */
    private String getName_receiver() {
        return name_receiver;
    }

    /**
     * Set the value of address_sender
     *
     * @param newVar the new value of address_sender
     */
    private void setAddress_sender(Address newVar) {
        address_sender = newVar;
    }

    /**
     * Get the value of address_sender
     *
     * @return the value of address_sender
     */
    private Address getAddress_sender() {
        return address_sender;
    }

    /**
     * Set the value of address_receiver
     *
     * @param newVar the new value of address_receiver
     */
    private void setAddress_receiver(Address newVar) {
        address_receiver = newVar;
    }

    /**
     * Get the value of address_receiver
     *
     * @return the value of address_receiver
     */
    private Address getAddress_receiver() {
        return address_receiver;
    }

    /**
     * Set the value of status_delivery
     *
     * @param newVar the new value of status_delivery
     */
    private void setStatus_delivery(Status newVar) {
        status_delivery = newVar;
    }

    /**
     * Get the value of status_delivery
     *
     * @return the value of status_delivery
     */
    private Status getStatus_delivery() {
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
    public void Consignment(int _id, long _volume,
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
     * @param status
     */
    public void setDeliveryStatus(Status status) {
    }

    /**
     * @return StatusDelivery
     */
    public Status getDeliveryStatus() {
        return null;
    }

    /**
     * @return undef
     */
    private Status queryStatus() {
        return null;
    }

    /**
     * @return long
     */
    private long computeBill() {
        return 0;
    }

    /**
     */
    private void printBill() {
    }

}
