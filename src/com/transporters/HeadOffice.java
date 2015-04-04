package com.transporters;


import java.util.*;


/**
 * Class HeadOffice
 */
public class HeadOffice extends Office {

	//
	// Fields
	//

  private Server base_server_system;
  
	//
	// Constructors
	//
	public HeadOffice () { };
  
	//
	// Methods
	//


	//
	// Accessor methods
	//

	/**
	 * Set the value of base_server_system
	 * @param newVar the new value of base_server_system
	 */
  private void setBase_server_system (Server newVar) {//convert string to server
  	base_server_system = newVar;
  }

	/**
	 * Get the value of base_server_system
	 * @return the value of base_server_system
	 */
  private Server getBase_server_system () {
  	return base_server_system;
  }

	//
	// Other methods
	//

	/**
	 * @param        _name
	 */
  public void Head(String _name)
  {
	}


}
