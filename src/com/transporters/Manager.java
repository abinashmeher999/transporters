package com.transporters;

/**
 * Class Manager
 */
public class Manager extends Employee {

	//
    // Fields
    //
    //
    // Constructors
    //
    public Manager() {
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
	 * @param        _quantity
	 */
  public void buyNewTruck(int _quantity) {
    }

    /**
     * @return StatusTruck
     * @param _truck_id
     */
    public Truck.Status queryTruckStatus(int _truck_id) {
        return null;
    }

    /**
     * @return int
     * @param truck_id
     */
    public int queryTruckUsage(int truck_id) {
        return 0;
    }

    /**
     * @return undef
     * @param consignment_id
     */
    public Consignment.Status queryConsignmentStatus(int consignment_id) {
        return null;
    }

    /**
     * @return long
     * @param branch_name
     */
    public long queryBranchTotalHandling(String branch_name) {
        return 0;
    }

    /**
     * @return int
     */
    public int queryAvgConsignmentWaitTime(String branch_name) {
        return 0;
    }

    /**
     * @return int
     */
    public int queryTruckIdleTimeAtBranch(String branch_name) {
        return 0;
    }
    
    public void addNewBranch(){
        
    }
    
}
