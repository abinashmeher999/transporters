package com.transporters;

import java.io.IOException;
import java.sql.*;

/**
 * Class Database
 */
public class Database {

    //
    // Fields
    //
    private static String IP_ADDRESS;
    private String url;
    private String user;
    private String password;
    Connection connection;

    //
    // Constructors
    //
    public Database() {

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
    
    public Connection getConnection(){
        return connection;
    }

    /**
     *
     * @throws java.sql.SQLException
     */
    public void connect() throws SQLException {
        if (!url.equals("jdbc:mysql://localhost:3306/tccs")) {
            url = Database.getBranchURL();
        }
        connection = DriverManager.getConnection(
                url,
                user,
                password
        );
    }
    //
    // Other methods
    //
}
