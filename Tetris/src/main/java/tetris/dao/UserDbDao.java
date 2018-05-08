
package tetris.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tetris.domain.Database;
import tetris.domain.User;


public class UserDbDao implements UserDao {
    
    private Database database;

    public UserDbDao(Database db) {
        this.database = db;
        
        try {
            Connection con = db.getConnection();
            PreparedStatement createTable = con.prepareStatement(
                "CREATE TABLE IF NOT EXISTS User ("
                + "id integer PRIMARY KEY,"
                + "username varchar(50)"
                + ");");
            createTable.executeUpdate();
            createTable.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Table User could not be created: " + e.getMessage());
            
        }
    }
    
    

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        
        try (Connection con = database.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM User;");
            ResultSet results = stmt.executeQuery();
            
            while (results.next()) {
                users.add(new User(results.getString("username")));
            }
            stmt.close();
            con.close(); 
        } catch (Exception e) {
            throw new AbstractMethodError("All users not found: " + e.getMessage());
        }
        return users;
            
    }

    @Override
    public void createUser(User user) {
        
        try {
            Connection con = database.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO User (username) VALUES (?)");
            stmt.setString(1, user.getUsername());
            stmt.executeUpdate();
            stmt.close();
            con.close(); 
        } catch (Exception e) {
            throw new AbstractMethodError("User not created: " + e.getMessage());
        }  
    }

    @Override
    public User findByUsername(String username) {
        try {
            
            Connection con = database.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM User WHERE username = ?");
            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();
            
            if (!result.next()) {
                return null;
            }
            User user = new User(result.getString("username"));
 
            stmt.close();
            result.close();
            con.close();
            return user;
        } catch (Exception e) {
            throw new AbstractMethodError("User not found: " + e.getMessage());
        }     
    }
    
}
