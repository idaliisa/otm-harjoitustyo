package tetris.domain;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.User;


public class UserTest {
    User user;
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        user = new User("user name");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void returnsTrueWhenUserNamesAreEqual() {
        assertEquals(true, user.equals(new User("user name")));
        
    }
    
    @Test
    public void returnsFalseWhenUserNamesAreNotEqual() {
        assertEquals(false, user.equals(new User("User name")));
        
    }

   
}
