package tetris.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import tetris.domain.Border;
import tetris.domain.Tetromino;
import tetris.domain.TetrominoI;
import tetris.domain.TetrominoJ;
import tetris.domain.TetrominoL;
import tetris.domain.TetrominoO;
import tetris.domain.TetrominoS;
import tetris.domain.TetrominoT;
import tetris.domain.TetrominoZ;


public class TetrisUi extends Application {
    public static int WIDTH = 360;
    public static int HEIGHT = 540;
    private Tetromino tetromino = drawRandomTetromino();
    private List<Polygon> tetrominos = new ArrayList<>();
    
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        pane.setPrefSize(WIDTH, HEIGHT);
        pane.getChildren().add(this.tetromino.getTetromino());
        
        Scene scene = new Scene(pane);
        
        new AnimationTimer() {
            private long previous;
            @Override
            public void handle(long now) {
                if (now - previous < 400_000_000) {
                    return;
                }
                previous = now;
                
                if (tetromino.doesHitLowerBorder(tetromino.getTetromino()) || tetromino.doesHitAnotherTetromino(tetromino.getTetromino(), tetrominos)) {
                    tetrominos.add(tetromino.getTetromino());
                    tetromino = drawRandomTetromino();
                    pane.getChildren().add(tetromino.getTetromino());
                } else {
                    tetromino.moveDown();
                }   
            }    
        }.start();
        
        scene.setOnKeyPressed(event -> {
            //one can use buttons to control tetromino until lower border is reached
            if (event.getCode().equals(KeyCode.RIGHT) && !tetromino.doesHitLowerBorder(tetromino.getTetromino()) && !tetromino.doesHitAnotherTetromino(tetromino.getTetromino(), tetrominos)) {
                tetromino.moveRight();
            } else if (event.getCode().equals(KeyCode.LEFT) && !tetromino.doesHitLowerBorder(tetromino.getTetromino()) && !tetromino.doesHitAnotherTetromino(tetromino.getTetromino(), tetrominos)) {
                tetromino.moveLeft();
            } else if (event.getCode().equals(KeyCode.DOWN) && !tetromino.doesHitLowerBorder(tetromino.getTetromino()) && !tetromino.doesHitAnotherTetromino(tetromino.getTetromino(), tetrominos)) {
                tetromino.moveDown();
            } else if (event.getCode().equals(KeyCode.ENTER) && !tetromino.doesHitLowerBorder(tetromino.getTetromino()) && !tetromino.doesHitAnotherTetromino(tetromino.getTetromino(), tetrominos)) {
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
    
    public Tetromino drawRandomTetromino() {
        Random random = new Random();
        int next = random.nextInt(7);
        if (next == 1) {
            return new TetrominoI(WIDTH/2, 0);
        } else if (next == 2) {
            return new TetrominoJ(WIDTH/2, 0);
        } else if (next == 3) {
            return new TetrominoL(WIDTH/2, 0);
        } else if (next == 4) {
            return new TetrominoO(WIDTH/2, 0);
        } else if (next == 5) {
            return new TetrominoS(WIDTH/2, 0);
        } else if (next == 6) {
            return new TetrominoT(WIDTH/2, 0);
        } else {
            return new TetrominoZ(WIDTH/2, 0);
        }  
    }
    
}