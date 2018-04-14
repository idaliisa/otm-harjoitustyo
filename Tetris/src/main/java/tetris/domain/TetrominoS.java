
package tetris.domain;

import javafx.scene.shape.Polygon;


public class TetrominoS extends Tetromino {
    
    public TetrominoS(int x, int y) {
        super(new Polygon(0, 0, 60, 0, 60, 30, 30, 30, 30, 60, -30, 60, -30, 30, 0, 30), x, y);
    }
    
}

