
package tetris.domain;

import javafx.scene.shape.Polygon;

public class TetrominoT extends Tetromino {
    
    public TetrominoT(int x, int y) {
        super(new Polygon(-30, 0, 60, 0, 60, 30, 30, 30, 30, 60, 0, 60, 0, 30, -30, 30), x, y);
    }
    
}