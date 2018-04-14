
package tetris.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.shape.Polygon;
import static tetris.ui.TetrisUi.WIDTH;


public class GameBoard {
    private Border bord;
    private Tetromino tetromino;
    private List<Polygon> tetrominos = new ArrayList<>();
    private int move;
    

    public GameBoard() {
        this.bord = new Border(0,0);
        this.tetromino = drawRandomTetromino();
        this.move = 30;
    }

    public Tetromino getTetromino() {
        return tetromino;
    }

    public List<Polygon> getTetrominos() {
        return tetrominos;
    }

    
    public boolean NewTetrominoOrMoveDown() {
        if (tetromino.doesHitBorder(this.tetromino.downMovedPolygon(), this.bord.getPolygonLower()) || tetromino.doesHitAnotherTetromino(this.tetromino.downMovedPolygon(), this.tetrominos)) {
            //tetromino.setLocation(0, - move);
            tetrominos.add(this.tetromino.getPolygon());
            tetromino = drawRandomTetromino();
            return true;
        } else {
            this.tetromino.moveDown();
            return false;
        } 
    }
    
    public boolean moveLeft() {
        if (tetromino.doesHitBorder(this.tetromino.leftMovedPolygon(), this.bord.getPolygonLeft()) || tetromino.doesHitAnotherTetromino(this.tetromino.leftMovedPolygon(), this.tetrominos)) {
            return false;
        } else {
            tetromino.moveLeft();
            return true;
        }
    }
    
    public boolean moveRight() {
        if (tetromino.doesHitBorder(this.tetromino.rightMovedPolygon(), this.bord.getPolygonRight()) || tetromino.doesHitAnotherTetromino(this.tetromino.rightMovedPolygon(), this.tetrominos)) {
            return false;
        } else {
            tetromino.moveRight();
            return true;
        }
    }
    
    public boolean rotate() {
        if (tetromino.doesHitBorder(this.tetromino.rotatedPolygon(), this.bord.getPolygonLeft())) {
            return false; 
        } else if (tetromino.doesHitBorder(this.tetromino.rotatedPolygon(), this.bord.getPolygonRight())) {
            return false; 
        } else if (tetromino.doesHitBorder(this.tetromino.rotatedPolygon(), this.bord.getPolygonLower())) {
            return false;
        } else if (tetromino.doesHitAnotherTetromino(this.tetromino.rotatedPolygon(), this.tetrominos)) {
            return false;
        } else {
            tetromino.rotate();
            return true;
        }
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


