
package tetris.domain;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.shape.Polygon;
import tetris.ui.TetrisUi;


public class TetrominoO extends Tetromino {
    private Piece first;
    private Piece seond;
    private Piece third;
    private Piece fourth;

    public TetrominoO(int initialX, int initialY, List<Piece> tetromino) {
        super(initialX, initialY, tetromino);
        this.first = new Piece(initialX, initialY);
        this.seond = new Piece(initialX + 1, initialY);
        this.third = new Piece(initialX + 1, initialY + 1);
        this.fourth = new Piece(initialX, initialY + 1);
   
        tetromino.add(first);
        tetromino.add(seond);
        tetromino.add(third);
        tetromino.add(fourth);
        
    }    
}
