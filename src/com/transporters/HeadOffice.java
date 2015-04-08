package com.transporters;

import java.sql.SQLException;
import java.util.*;

/**
 * Class HeadOffice
 */
public class HeadOffice extends Office {
    public static int count_employee_id = 20;
    public static int count_truck_id = 0;
    public static int count_consignment_id = 0;
    
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
        super(-1,_name,_address);
        setPassword("head0");
        Database _database = this.getDatabase();
        _database.setUser("root");
        _database.setUrl("jdbc:mysql://localhost:3306/tccs");
        _database.setPassword("alsk");
        _database.connect();
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
}
