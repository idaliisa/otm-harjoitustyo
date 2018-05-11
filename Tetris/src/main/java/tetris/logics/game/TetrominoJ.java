
package tetris.logics.game;

/**
 * Sets Tetromino with shape of J
 * 
 */
public class TetrominoJ extends Tetromino {
    

    public TetrominoJ(int width) {
        super(width);
        initTetrominoAboveCanvas(-2);
        this.first = new Piece(initialX - 1, initialY);
        this.second = new Piece(initialX, initialY);
        this.third = new Piece(initialX + 1, initialY);
        this.fourth = new Piece(initialX + 1, initialY + 1);
   
        pieces.add(first);
        pieces.add(second);
        pieces.add(third);
        pieces.add(fourth);
        
    }
    
    /**
     * Sets tetromino's orientation 90 degrees cloclwise
     */
    public void rotate() {
        if (this.direction == 1) {
            setTetromino(0, -1, 0, 1, -1, 1);
            this.direction = 2;
        } else if (this.direction == 2) {
            setTetromino(1, 0, -1, 0, -1, -1);
            this.direction = 3;
        } else if (this.direction == 3) {
            setTetromino(0, 1, 0, -1, 1, -1);
            this.direction = 4;
        } else {
            setTetromino(-1, 0, 1, 0, 1, 1);
            this.direction = 1;
        }
    }
}
