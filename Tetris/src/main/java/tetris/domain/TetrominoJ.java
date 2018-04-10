
package tetris.domain;

import javafx.scene.shape.Polygon;


public class TetrominoJ extends Tetromino {
    
    public TetrominoJ(int x, int y) {
        super(new Polygon(-45, 0, 45, 0, 45, 60, 15, 60, 15, 30, -45, 30), x, y);
    }
}
