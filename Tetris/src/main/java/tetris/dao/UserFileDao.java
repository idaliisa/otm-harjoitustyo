
package tetris.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tetris.domain.User;


public class UserFileDao implements UserDao {
    private List<User> users;
    private String userFile;

    public UserFileDao(String userFile) throws Exception {
        this.users = new ArrayList<>();
        this.userFile = userFile;
        try {
            Scanner scanner = new Scanner(new File(userFile));
            while (scanner.hasNextLine()) {
                users.add(new User(scanner.nextLine()));
            }
        } catch (Exception e) {
            FileWriter fileWriter = new FileWriter(new File(userFile));
            fileWriter.close();
        }
    }
    
    @Override
    public List<User> getAllUsers() {
        return users;
    }
    
    @Override
    public void createUser(User user) throws Exception {
        users.add(user);
        save();
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
    
    public void save() throws Exception {
        try (FileWriter fileWriter = new FileWriter(new File(userFile))) {
            for (User user : users) {
                fileWriter.write(user.getUsername() + "\n");
            }
        }  
    }    
}
