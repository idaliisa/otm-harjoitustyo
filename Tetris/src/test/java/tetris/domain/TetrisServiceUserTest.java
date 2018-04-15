
package tetris.domain;

import com.sun.xml.internal.bind.v2.TODO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TetrisServiceUserTest {
    FakeUserDao fakeUserDao;
    TetrisService tetrisService;
    
    @Before
    public void setUp() {
        fakeUserDao = new FakeUserDao();
        tetrisService = new TetrisService(fakeUserDao);
    }
    
    @Test
    public void returnTrueIfUsernameIsAtLeastFiveCharacters() {
        assertEquals(true, tetrisService.isAtLeastFiveCharacters("usern"));
    }
    
    @Test
    public void returnFalseIfUsernameIsLessThanFiveCharacters() {
        assertEquals(false, tetrisService.isAtLeastFiveCharacters("user"));
    }
    
    @Test
    public void returnTrueIfUsernameIsUnique() throws Exception {    
        assertEquals(true, tetrisService.createUser("user name"));
    }
    
    @Test
    public void returnFalseIfUsernameIsNotUnique() throws Exception {
        assertEquals(false, tetrisService.createUser("test user"));
    }
    
    @Test
    public void returnFalseIfNonExistingUserTryLogin() {
        assertEquals(false, tetrisService.login("new user"));
    }
    
    @Test
    public void returnTrueIfExistingUserTryLogin() {
        assertEquals(true, tetrisService.login("test user"));
    }
    
    @Test
    public void loggedInUserIsCorrect() {
        tetrisService.login("test user");
        assertEquals("test user", tetrisService.getLoggedInUser().getUsername());
    }
    
    @Test
    public void noUserLoggedIn() {
        tetrisService.login("test user");
        tetrisService.logout();
        assertEquals(null, tetrisService.getLoggedInUser());
    }
    
    
}
