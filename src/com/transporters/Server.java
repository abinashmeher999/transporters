package com.transporters;

/**
 * Class Server
 */
public class Server {

    //
    // Fields
    //
    private static String url = "jdbc:mysql://localhost:3306/tccs";
    private static String user = "root";
    private static String password = "alsk";
    private Database database;

    //
    // Constructors
    //
    public Server() {
    }

    ;
  
	//
	// Methods
	//


	//
	// Accessor methods
	//

	/**
	 * Set the value of database
     * @param newVar the new value of database
     */
    private void setDatabase(Database newVar) {
        database = newVar;
    }

    /**
     * Get the value of database
     *
     * @return the value of database
     */
    private Database getDatabase() {
        return database;
    }

	//
    // Other methods
    //
}
