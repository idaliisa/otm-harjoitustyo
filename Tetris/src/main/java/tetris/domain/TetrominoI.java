
package tetris.domain;

import javafx.scene.shape.Polygon;


public class TetrominoI extends Tetromino {
    
    public TetrominoI(int x, int y) {
        super(new Polygon(-60, 0, 60, 0, 60, 30, -60, 30), x, y);
    }
    
}
