
package tetris.logics.user;


import tetris.dao.FakeUserDao;
import tetris.logics.TetrisService;
import org.junit.Before;
import org.junit.Test;
import tetris.logics.TetrisService;
import static org.junit.Assert.*;


public class TetrisServiceUserTest {
    FakeUserDao fakeUserDao;
    TetrisService tetrisService;
    
    @Before
    public void setUp() {
        fakeUserDao = new FakeUserDao();
        tetrisService = new TetrisService(fakeUserDao, null);
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
    
    
}
