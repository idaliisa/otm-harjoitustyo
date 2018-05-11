
package tetris.logics.game;


/**
 * Sets Tetromino with shape of O
 * 
 */
public class TetrominoO extends Tetromino {


    public TetrominoO(int width) {
        super(width);
        initTetrominoAboveCanvas(-2);
        this.first = new Piece(initialX, initialY);
        this.second = new Piece(initialX + 1, initialY);
        this.third = new Piece(initialX + 1, initialY + 1);
        this.fourth = new Piece(initialX, initialY + 1);
   
        pieces.add(first);
        pieces.add(second);
        pieces.add(third);
        pieces.add(fourth);        
    }
    
    /**
     * Sets tetromino's orientation 90 degrees cloclwise
     */
    public void rotate() {
        
    }
}
