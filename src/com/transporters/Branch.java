package com.transporters;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.*;

/**
 * Class Branch
 */
public class Branch extends Office implements Serializable{

    //
    // Fields
    //
    //
    // Constructors
    //
    /**
     *
     * @param _id
     * @param _name
     * @param _address
     * @param _database
     * @throws java.sql.SQLException
     */
    public Branch(int _id, String _name, Address _address, Database _database) throws SQLException {
        super(_id, _name, _address);
        setPassword("branch" + _id);
        this.setDatabase(_database);
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
    private static final long serialVersionUID = -320077864029228146L;

}
