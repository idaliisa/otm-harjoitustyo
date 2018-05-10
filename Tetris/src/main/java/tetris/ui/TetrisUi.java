package tetris.ui;



import tetris.ui.controller.PlayTetrisSceneController;
import tetris.ui.controller.LoginAndNewUserSceneController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import tetris.dao.UserDbDao;
import tetris.dao.Database;
import tetris.logics.game.Game;
import tetris.logics.TetrisService;


public class TetrisUi extends Application {
    public static int WIDTH = 12;
    public static int HEIGHT = 18;
    public static double squareSize = 30.0;
    private Stage stage;
    private TetrisService tetrisService;
    private Scene loginAndNewUserScene;
    private Scene startGameScene;
    private Scene playTetrisScene;
    
    
    @FXML
    public Canvas canvas = new Canvas(WIDTH * squareSize, HEIGHT * squareSize);
    public GraphicsContext gc = canvas.getGraphicsContext2D();
    
    
        
    @Override
    public void init() throws Exception {
        try {
            Database db = new Database("jdbc:sqlite:users.db");
            UserDbDao userDbDao = new UserDbDao(db);
            tetrisService = new TetrisService(userDbDao, new Game(WIDTH, HEIGHT));
        } catch (Exception e) {
            System.out.println("SqLite not availabe: " + e.getMessage());
        }
        
        
        FXMLLoader loginAndNewUserLoader = new FXMLLoader(getClass().getResource("/fxml/LoginAndNewUserScene.fxml"));
        Parent loginAndNewUserPane = loginAndNewUserLoader.load();
        LoginAndNewUserSceneController loginAndNewUserSceneController = loginAndNewUserLoader.getController();
        loginAndNewUserSceneController.setTetrisService(tetrisService);
        loginAndNewUserSceneController.setApplication(this);
        loginAndNewUserScene = new Scene(loginAndNewUserPane);
        
           
        FXMLLoader playTetrisLoader = new FXMLLoader(getClass().getResource("/fxml/PlayTetrisScene.fxml"));
        Parent playTetrisPane = playTetrisLoader.load();
        PlayTetrisSceneController playTetrisSceneController = playTetrisLoader.getController();
        playTetrisSceneController.setTetrisService(tetrisService);
        playTetrisSceneController.setApplication(this);
        playTetrisScene = new Scene(playTetrisPane); 
    }
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("Tetris");
        setLoginAndNewUserScene();
        stage.show();
    }
    
    
    
    public void setLoginAndNewUserScene() {
        stage.setScene(loginAndNewUserScene);
    }
    
    
    
    public void setPlayTetrisScene() {
        stage.setScene(playTetrisScene);
    }
    
    
    
    public static void main(String[] args) {
        launch(args);
    }  
    
}