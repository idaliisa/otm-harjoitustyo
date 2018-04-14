
package tetris.domain;

import javafx.scene.shape.Polygon;


public class TetrominoL extends Tetromino {
    
    public TetrominoL(int x, int y) {
        super(new Polygon(-30, 0, 60, 0, 60, 30, 0, 30, 0, 60, -30, 60), x, y);
    }
    
}