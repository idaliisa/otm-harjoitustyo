
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
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isAtLeastFiveCharacters(String username) {
        return username.length() >= 5;
    }
    
    public boolean login(String username) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            return false;
        }
        this.loggedInUser = user;
        return true;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
    
    public void logout() {
        this.loggedInUser = null;
    }
        
}
