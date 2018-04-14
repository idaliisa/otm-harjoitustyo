package tetris.ui;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tetris.domain.Border;
import tetris.domain.GameBoard;


public class TetrisUi extends Application {
    public static int WIDTH = 360;
    public static int HEIGHT = 540;
    
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        pane.setPrefSize(WIDTH, HEIGHT);
        
        GameBoard canvas = new GameBoard();
        
        //adding a tetromino that a player can control
        pane.getChildren().add(canvas.getTetromino().getPolygon());
        
        
        Border border = new Border(0, 0);
        pane.getChildren().add(border.getPolygonLower());
        
        Scene scene = new Scene(pane);
        
        new AnimationTimer() {
            private long previous;
            @Override
            public void handle(long now) {
                
                if (now - previous < 400_000_000) {
                    return;
                }
                previous = now;
                
                //if the tetromino hits a lower border or another tetromino, new tetromino is added. Otherwise the tetromino moves down.
                if (canvas.NewTetrominoOrMoveDown()) {
                    pane.getChildren().add(canvas.getTetromino().getPolygon());
                }
            }    
        }.start();
        
        scene.setOnKeyPressed(event -> {
            //one can use buttons to control tetromino until lower border is reached
            if (event.getCode().equals(KeyCode.LEFT) && canvas.moveLeft()) {
                ;
            } else if (event.getCode().equals(KeyCode.RIGHT) && canvas.moveRight()) {
                ;
            } else if (event.getCode().equals(KeyCode.ENTER) && canvas.rotate()) {
                ;
            }
        });
        
        stage.setScene(scene);
        stage.show();    
    }
    
    public static void main(String[] args) {
        launch(args);
        System.out.println("Hello world");
    }  
}