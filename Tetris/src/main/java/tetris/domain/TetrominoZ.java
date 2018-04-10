
package tetris.domain;

import javafx.scene.shape.Polygon;


public class TetrominoZ extends Tetromino {
    
    public TetrominoZ(int x, int y) {
        super(new Polygon(-45, 0, 15, 0, 15, 30, 45, 30, 45, 60, -15, 60, -15, 30, -45, 30), x, y);
    }
    
}