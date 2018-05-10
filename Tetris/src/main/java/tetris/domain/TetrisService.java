
package tetris.domain;


import tetris.dao.UserDao;

/**
 * 
 * This class is about the user login logic
 */
public class TetrisService {
    
    
    private UserDao userDao;
    private User loggedInUser;
    private Game game;

    
    
    public TetrisService(UserDao userDao, Game game) {
        this.userDao = userDao;
        this.game = game;
    }
    
    
    
    /**
     * This method creates a new user if the username does not exist before and 
     * if the username has at least five characters
     * @param username username
     * @return true, if a new user is created, otherwise false
     */
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
            System.out.println("user not created: " + e.getMessage());
            return false;
        }
    }
    
    
    
    /**
     * This method tells if the username has at least five characters
     * @param username username
     * @return true, if the username has at least five characters, otherwise false
     */
    public boolean isAtLeastFiveCharacters(String username) {
        return username.length() >= 5;
    }
    
    
    
    /**
     * This method sets the user loggedin if the username already exists
     * @param username username
     * @return true, if the username does exists, otherwise false
     */
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
    
 
    
    public Game getGame() {
        return game;
    }

    
    
    public void setGame(Game game) {
        this.game = game;
    }    
           
}
