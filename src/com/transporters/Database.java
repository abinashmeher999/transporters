package com.transporters;

import java.io.IOException;
import java.io.Serializable;
import java.sql.*;

/**
 * Class Database
 */
public class Database implements Serializable{

    //
    // Fields
    //
    private static String IP_ADDRESS;
    private String url;
    private String user;
    private String password;

    //
    // Constructors
    //
    public Database() {
        url = "";
        user = "";
        password = "";
    }

    ;

//
// Methods
//
    
    //
    // Accessor methods
    //
    public void setUrl(String url) {
        this.url = url;
    }

    public static String getBranchURL() {
        return ("jdbc:mysql://" + Database.IP_ADDRESS + ":3306/tccs");
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void setIPAddress(String _ip_address) {
        Database.IP_ADDRESS = _ip_address;
    }

    /**
     *
     * @return 
     * @throws java.sql.SQLException
     */
    public Connection getConnection() throws SQLException {
        if (url.equals("")) {
            url = Database.getBranchURL();
        }
        return DriverManager.getConnection(
                url,
                user,
                password
        );
        
    }

    public static String getIP_ADDRESS() {
        return IP_ADDRESS;
    }
    
    //
    // Other methods
    //
    private static final long serialVersionUID = 2418519852800895063L;
}
