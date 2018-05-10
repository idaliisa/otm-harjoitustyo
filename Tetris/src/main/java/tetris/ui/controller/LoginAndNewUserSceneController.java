
package tetris.ui.controller;

import tetris.ui.controller.FXMLController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class LoginAndNewUserSceneController extends FXMLController {
    
    
    @FXML
    private Label message;
    public TextField usernameInput;
    private Button loginButton;
    private Button createButton;
    

    
    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameInput.getText();
        if (tetrisService.login(username)) {
            application.setPlayTetrisScene();
        } else {
            message.setText("user does not exist");
        }
    }
    
    
    
    @FXML 
    private void handleCreate(ActionEvent event) {
        String username = usernameInput.getText();
        if (!tetrisService.isAtLeastFiveCharacters(username)) {
            message.setText("username must have at least five characters, please try again");
        } else if (tetrisService.createUser(username)) {
            message.setText("user created, please log in");
        } else {
            message.setText("username already exists, please log in or create a new user");
            usernameInput.setText("");
        }
    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        message.setText("log in or sign up");
    }
    
    
}
