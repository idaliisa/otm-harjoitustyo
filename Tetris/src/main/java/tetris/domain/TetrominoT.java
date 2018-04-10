
package tetris.domain;

import javafx.scene.shape.Polygon;

public class TetrominoT extends Tetromino {
    
    public TetrominoT(int x, int y) {
        super(new Polygon(-45, 0, 45, 0, 45, 30, 15, 30, 15, 60, -15, 60, -15, 30, -45, 30), x, y);
    }
    
}