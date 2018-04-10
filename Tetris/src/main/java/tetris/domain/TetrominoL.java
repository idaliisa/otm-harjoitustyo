
package tetris.domain;

import javafx.scene.shape.Polygon;


public class TetrominoL extends Tetromino {
    
    public TetrominoL(int x, int y) {
        super(new Polygon(-45, 0, 45, 0, 45, 30, -15, 30, -15, 60, -45, 60), x, y);
    }
    
}