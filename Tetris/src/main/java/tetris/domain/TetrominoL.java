
package tetris.domain;

import java.util.List;


public class TetrominoL extends Tetromino {
    
    private Piece first;
    private Piece second;
    private Piece third;
    private Piece fourth;

    public TetrominoL(int initialX, int initialY, List<Piece> tetromino) {
        super(initialX, initialY, tetromino);
        this.first = new Piece(initialX - 1, initialY + 1);
        this.second = new Piece(initialX - 1, initialY);
        this.third = new Piece(initialX, initialY);
        this.fourth = new Piece(initialX + 1, initialY);
   
        tetromino.add(first);
        tetromino.add(second);
        tetromino.add(third);
        tetromino.add(fourth);
        
    }
    
}