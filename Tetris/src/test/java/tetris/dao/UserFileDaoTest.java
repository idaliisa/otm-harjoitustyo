
package tetris.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import tetris.domain.User;


public class UserFileDaoTest {
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();
    File userFile;
    UserDao userDao;
    
    
    @Before
    public void setUp() throws Exception {
        userFile = temporaryFolder.newFile("userTet.txt");
        
        try (FileWriter fileWriter = new FileWriter(userFile.getAbsolutePath())){
            fileWriter.write("user name\n");
        }
        
        userDao = new UserFileDao(userFile.getAbsolutePath());
    }
    
    @Test
    public void usersAreCorrectlyReadFromFile() {
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
