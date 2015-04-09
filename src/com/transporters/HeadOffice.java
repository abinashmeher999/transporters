package com.transporters;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * Class HeadOffice
 */
public class HeadOffice extends Office implements Serializable{
    
    
    //
    // Fields
    //
    //
    // Constructors
    //

    /**
     *
     * @param _name
     * @param _address
     * @throws SQLException
     */
        public HeadOffice(String _name, Address _address) throws SQLException{
        super(0,_name,_address);
        this.getDatabase().setUser("root");
        this.getDatabase().setUrl("jdbc:mysql://localhost:3306/tccs");
        this.getDatabase().setPassword("alsk");
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
    private static final long serialVersionUID = 1L;
}
