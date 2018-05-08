
package tetris.domain;

import java.sql.Connection;
import java.sql.*;


public class Database {
    private String dbAddress;

    public Database(String dbAddress) {
        this.dbAddress = dbAddress;
    }
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbAddress);
    }
}
