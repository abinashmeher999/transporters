package com.transporters;

import java.sql.SQLException;
import java.util.*;

/**
 * Class Branch
 */
public class Branch extends Office {

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
     * @param _database
     * @throws java.sql.SQLException
     */
    public Branch(int _id, String _name, Address _address, Database _database) throws SQLException {
        super(_id, _name, _address);
        this.setDatabase(_database);
        this.getDatabase().connect();
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
