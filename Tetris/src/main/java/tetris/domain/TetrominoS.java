
package tetris.domain;

import javafx.scene.shape.Polygon;


public class TetrominoS extends Tetromino {
    
    public TetrominoS(int x, int y) {
        super(new Polygon(-15, 0, 45, 0, 45, 30, 15, 30, 15, 60, -45, 60, -45, 30, -15, 30), x, y);
    }
    
}

