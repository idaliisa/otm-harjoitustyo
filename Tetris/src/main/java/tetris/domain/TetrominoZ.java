
package tetris.domain;

import javafx.scene.shape.Polygon;


public class TetrominoZ extends Tetromino {
    
    public TetrominoZ(int x, int y) {
        super(new Polygon(-30, 0, 30, 0, 30, 30, 60, 30, 60, 60, 0, 60, 0, 30, -30, 30), x, y);
    }
    
}