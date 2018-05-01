
package tetris.domain;



public class TetrominoL extends Tetromino {
    

    public TetrominoL(int width) {
        super(width);
        initTetrominoAboveCanvas(-2);
        this.first = new Piece(initialX, initialY + 1);
        this.second = new Piece(initialX, initialY);
        this.third = new Piece(initialX + 1, initialY);
        this.fourth = new Piece(initialX + 2, initialY);
   
        pieces.add(first);
        pieces.add(second);
        pieces.add(third);
        pieces.add(fourth);        
    }
    
    public void rotate() {
        if (this.direction == 1) {
            setTetromino(-1, 0, 0, 1, 0, 2);
            this.direction = 2;
        } else if (this.direction == 2) {
            setTetromino(0, -1, -1, 0, -2, 0);
            this.direction = 3;
        } else if (this.direction == 3) {
            setTetromino(1, 0, 0, -1, 0, -2);
            this.direction = 4;
        } else {
            setTetromino(0, 1, 1, 0, 2, 0);
            this.direction = 1;
        }
    }
}