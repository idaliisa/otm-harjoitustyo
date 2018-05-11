
package tetris.dao;

import java.sql.Connection;
import java.sql.*;

/**
 * Describes Database
 * 
 */
public class Database {
    private String dbAddress;

    public Database(String dbAddress) {
        this.dbAddress = dbAddress;
    }
    
    /**
     * Connects to database
     * @return Connection
     * @throws SQLException 
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbAddress);
    }
}
