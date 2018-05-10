
package tetris.dao;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import tetris.logics.user.User;


public class UserDbDaoTest {
    
    File userFile;
    UserDao userDao;
    
    @Before
    public void setUp() throws Exception {
        
        userFile = new File("userTest.db");
        Database db = new Database("jdbc:sqlite:userTest.db");
        userDao = new UserDbDao(db);
        
        try {
            Connection con = db.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO User (username) VALUES (?)");
            stmt.setString(1, "user name");
            stmt.executeUpdate();
            stmt.close();
            con.close(); 
        } catch (Exception e) {
            throw new AbstractMethodError("User not created: " + e.getMessage());
        } 
    }

    
    @Test
    public void usersAreCorrectlyReadFromDatabase() {
        List<User> users = userDao.getAllUsers();
        User user = users.get(0);
        assertEquals("user name", user.getUsername());
    }
    
    @Test
    public void returnUsernameIfexistingUserIsFound() {
        User user = userDao.findByUsername("user name");
        assertEquals("user name", user.getUsername());
    }
    
    @Test
    public void returnNullIfUserIsNotFound() {
        assertEquals(null, userDao.findByUsername("username"));
    }
    
    @Test
    public void usersAreCorrectlyCreatedAndSaved() throws Exception {
        User newUser = new User("new user");
        userDao.createUser(newUser);
        User user = userDao.findByUsername("new user");
        assertEquals("new user", user.getUsername());
    }
    
    @After
    public void tearDown() {
        userFile.delete();
    }
    
}