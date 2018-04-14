
package tetris.domain;

import javafx.scene.shape.Polygon;


public class TetrominoJ extends Tetromino {
    
    public TetrominoJ(int x, int y) {
        super(new Polygon(-30, 0, 60, 0, 60, 60, 30, 60, 30, 30, -30, 30), x, y);
    }
}
