
package tetris.dao;

import java.util.List;
import tetris.domain.User;


public interface UserDao {
    List<User> getAllUsers();
    void createUser(User user) throws Exception;
    User findByUsername(String username);    
}
