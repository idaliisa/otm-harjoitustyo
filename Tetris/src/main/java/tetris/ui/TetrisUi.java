package tetris.ui;


import java.io.FileInputStream;
import java.util.Properties;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tetris.dao.UserFileDao;
import tetris.domain.GameBoard;
import tetris.domain.TetrisService;


public class TetrisUi extends Application {
    public static int WIDTH = 12;
    public static int HEIGHT = 18;
    private double squareSize = 30.0;
    private TetrisService tetrisService;
    
    @Override
    public void init() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));
        String userFile = properties.getProperty("userFile");
        UserFileDao userFileDao = new UserFileDao(userFile);
        tetrisService = new TetrisService(userFileDao);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox loginPane = new VBox(10);
        Label message = new Label();
        TextField usernameInput = new TextField();
        Button loginButton = new Button("login");
        Button createButton = new Button("new user");
        
        loginPane.getChildren().addAll(message, usernameInput, loginButton, createButton);
        Scene loginScene = new Scene(loginPane);
        
        loginButton.setOnAction(event -> {
            String username = usernameInput.getText();
            if ( tetrisService.login(username) ){
                startGame(primaryStage);
            } else {
                message.setText("user does not exist");
            }
        });
        
        createButton.setOnAction(event -> {
            String username = usernameInput.getText();
            if (!tetrisService.isAtLeastFiveCharacters(username)) {
                message.setText("username must have at least five characters, please try again");
            }
            else if (tetrisService.createUser(username)) {
                message.setText("user created, please login in");
                usernameInput.setText("");
            } else {
                message.setText("username already exists, please log in or create a new user");
                usernameInput.setText("");
            }
        });
        
        primaryStage.setScene(loginScene);
        primaryStage.show();    
    }
    
    
    public void startGame(Stage secondaryStage) {
        VBox startPane = new VBox(10);
        Button startButton = new Button("Start");
        
        startPane.getChildren().add(startButton);
        Scene startScene = new Scene(startPane);
        
        startButton.setOnAction(event -> {
            playTetris(secondaryStage);  
        });
        
        secondaryStage.setScene(startScene);
        secondaryStage.show();
    }
    
    public void playTetris(Stage tertiaryStage) {
        Canvas canvas = new Canvas(WIDTH * squareSize, HEIGHT * squareSize);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        GameBoard gb = new GameBoard(WIDTH, HEIGHT);
        BorderPane pane = new BorderPane();
        pane.setCenter(canvas);
        Scene tetrisScene = new Scene(pane);
        
        new AnimationTimer() {
            private long previous;
            @Override
            public void handle(long now) {                
                if (now - previous < 400_000_000) {
                    return;
                }
                previous = now;
                
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, WIDTH * squareSize, HEIGHT * squareSize);
                
                gc.setFill(Color.AQUA);
                gb.getTetromino().getPieces().stream().forEach(piece -> {
                    gc.fillRect(piece.getX() * squareSize, piece.getY() * squareSize, squareSize, squareSize);
                });
                gb.moveTetrominoDown();
                
                gc.setFill(Color.AQUA);
                gb.getPiecesOnBoard().stream().forEach(piece -> {
                    gc.fillRect(piece.getX() * squareSize, piece.getY() * squareSize, squareSize, squareSize);
                });
            }
        }.start();
        
        tetrisScene.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.LEFT)) {
                gb.moveTetrominoLeft();
            } else if (event.getCode().equals(KeyCode.RIGHT)) {
                gb.moveTetrominoRight();
            } else if (event.getCode().equals(KeyCode.DOWN)) {
                gb.moveTetrominoDown();
            } else if (event.getCode().equals(KeyCode.UP)) {
                gb.rotateTetromino();
            }
        });
        
        tertiaryStage.setScene(tetrisScene);
        tertiaryStage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
        System.out.println("Hello world");
    }  
}