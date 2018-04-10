
package tetris.domain;

import javafx.scene.shape.Polygon;


public class TetrominoO extends Tetromino {
    
    public TetrominoO(int x, int y) {
        super(new Polygon(-30, 0, 30, 0, 30, 60, -30, 60), x, y);
    }
}
