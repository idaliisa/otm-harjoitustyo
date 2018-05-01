
package tetris.domain;

/**
 * This class describes the user or the player
 */
public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    /**
     * This method does check whether a user as a parameter and whether these 
     * users have the same username
     * @param object a piece
     * @return true if these users have the same username, otherwise false
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        
        if (getClass() != object.getClass()) {
            return false;
        }
        
        User user = (User) object;
        if (this.username == null || !this.username.equals(user.username)) {
            return false;
        }
        
        return true;
    }
    
    
    
}
