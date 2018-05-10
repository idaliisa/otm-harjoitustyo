
package tetris.dao;

import tetris.logics.user.User;
import java.util.ArrayList;
import java.util.List;
import tetris.dao.UserDao;


public class FakeUserDao implements UserDao {
    List<User> users = new ArrayList<>();

    public FakeUserDao() {
        users.add(new User("test user"));
    }
    
    

    @Override
    public List<User> getAllUsers() {
         return users;
    }

    @Override
    public void createUser(User user) throws Exception {
        users.add(user);
    }

    @Override
    public User findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
