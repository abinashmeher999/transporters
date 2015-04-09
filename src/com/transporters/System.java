package com.transporters;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class System
 */
public class System {

    //
    // Fields
    //
    //
    // Constructors
    //
    public System() {
    }

    ;
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    //
    // Other methods
    //

	/**
	 * @return        int
	 */
    public int allotNextTruck() {
        return (0);
    }

    public static String printBill(Consignment consignment) {
        String bill = null;
        bill = "Consignment ID : " + consignment.getConsignment_id() + "\n";
        bill += "Sender : " + consignment.getName_sender() + "\n" + "\t" + consignment.getAddress_sender() + "\n";
        bill += "Receiver : " + consignment.getName_receiver() + "\n" + "\t" + consignment.getAddress_receiver() + "\n";
        bill += "Billing : " + consignment.getName_billing() + "\n" + "\t" + consignment.getAddress_billing() + "\n";
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a ");
        bill += "Entry date and time : " + ft.format(consignment.getEntry_date().DATE) + "\n";
        bill += "Volume : " + consignment.getVolume() + "\n";
        bill += "Pieces : " + consignment.getPieces() + "\n";
        bill += "Charge : INR " + consignment.computeBill() + "\n";
        return bill;
    }

    /**
     * @param truck_id
     */
    public static String printDispatchDetails(Truck truck) {
        String details = null;
        details = "Truck Plate Number : " + truck.getPlate_number() + "\n\t";
        details += "Destination Branch : " + truck.getCurrent_office() + "\n\t";
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a ");
        details += "Dispatch Time : " + ft.format(Calendar.getInstance().DATE) + "\n";
        details += "Consignment List" + "\n\t";
        int count = 1;
        for (Consignment consignment : truck.getConsignment_list()) {
            details += count++ + ". " + consignment.getConsignment_id() + "\n\t";
        }
        return details;
    }

}
