
package tetris.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import tetris.domain.Game;
import static tetris.ui.TetrisUi.HEIGHT;
import static tetris.ui.TetrisUi.WIDTH;
import static tetris.ui.TetrisUi.squareSize;

public class PlayTetrisSceneController extends FXMLController {
    

    @FXML
    private Canvas canvas;  
    private GraphicsContext gc;   
    private Button startButton;
 
    
    
    @FXML 
    private void handleStartGame(ActionEvent event) {
        
        tetrisService.setGame(new Game(WIDTH, HEIGHT));
        
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
                tetrisService.getGame().getAllPiecesOnBoard().stream().forEach(piece -> {
                    gc.fillRect(piece.getX() * squareSize, piece.getY() * squareSize, squareSize, squareSize);
                });

                tetrisService.getGame().moveTetrominoDown();

                if (tetrisService.getGame().gameover()) {
                    this.stop();
                };
            }           
        }.start();
    }
    
    
    
    @FXML
    private void handleOnKeyPressed(KeyEvent event) {
        if (event.getCode().equals(KeyCode.LEFT)) {
            tetrisService.getGame().moveTetrominoLeft();
        } else if (event.getCode().equals(KeyCode.RIGHT)) {
            tetrisService.getGame().moveTetrominoRight();
        } else if (event.getCode().equals(KeyCode.DOWN)) {
            tetrisService.getGame().moveTetrominoDown();
        } else if (event.getCode().equals(KeyCode.UP)) {
            tetrisService.getGame().rotateTetromino();
        }
    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = canvas.getGraphicsContext2D();        
    }
    
}
