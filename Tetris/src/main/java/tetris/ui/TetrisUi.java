
package tetris.ui;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tetris.domain.Border;
import tetris.domain.TetrominoI;


public class TetrisUi extends Application {
    public static int WIDTH = 360;
    public static int HEIGHT = 540;
    
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        pane.setPrefSize(WIDTH, HEIGHT);
        
        Border bord = new Border(0,0);
        pane.getChildren().add(bord.getPolygonLower());
        pane.getChildren().add(bord.getPolygonLeft());
        pane.getChildren().add(bord.getPolygonRight());
        
        TetrominoI tetromino = new TetrominoI(WIDTH/2, 0);
        pane.getChildren().add(tetromino.getTetromino());
        
        Scene scene = new Scene(pane);
        
        new AnimationTimer() {
            private long previous;
            @Override
            public void handle(long now) {
                if (now - previous < 200_000_000) {
                    return;
                }
                previous = now;
                tetromino.moveDown();
            }    
        }.start();
        
        scene.setOnKeyPressed(event -> {
            //one can use buttons to control tetromino until lower border is reached
            if (event.getCode().equals(KeyCode.RIGHT) && !tetromino.doesHitLowerBorder(tetromino.getTetromino())) {
                tetromino.moveRight();
            } else if (event.getCode().equals(KeyCode.LEFT) && !tetromino.doesHitLowerBorder(tetromino.getTetromino())) {
                tetromino.moveLeft();
            } else if (event.getCode().equals(KeyCode.ENTER) && !tetromino.doesHitLowerBorder(tetromino.getTetromino())) {
                tetromino.rotate();
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
