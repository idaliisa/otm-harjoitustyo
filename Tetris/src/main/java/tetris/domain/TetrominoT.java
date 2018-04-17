
package tetris.domain;

import java.util.List;

public class TetrominoT extends Tetromino {
    
    private Piece first;
    private Piece second;
    private Piece third;
    private Piece fourth;

    public TetrominoT(int initialX, int initialY, List<Piece> tetromino) {
        super(initialX, initialY, tetromino);
        this.first = new Piece(initialX - 1, initialY);
        this.second = new Piece(initialX, initialY);
        this.third = new Piece(initialX + 1, initialY);
        this.fourth = new Piece(initialX, initialY + 1);
   
        tetromino.add(first);
        tetromino.add(second);
        tetromino.add(third);
        tetromino.add(fourth);
        
    }
    
}