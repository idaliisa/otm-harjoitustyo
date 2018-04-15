
package tetris.domain;


public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

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
