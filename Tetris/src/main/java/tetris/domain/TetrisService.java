
package tetris.domain;

import tetris.dao.UserDao;


public class TetrisService {
    private UserDao userDao;
    private User loggedInUser;

    public TetrisService(UserDao userDao) {
        this.userDao = userDao;
    }
    
    public boolean createUser(String username) {
        if (!isAtLeastFiveCharacters(username)) {
            return false;
        }
        if (userDao.findByUsername(username) != null) {
            return false;
        }
        User user = new User(username);
        try {
            userDao.createUser(user);
        } catch (Exception e) {
            return false;
        }
        return false;
        
    }
    
    public boolean isAtLeastFiveCharacters(String username) {
        return username.length() >= 5;
    }
    
    
}
