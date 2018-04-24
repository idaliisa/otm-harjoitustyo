
package tetris.domain;


public class TetrominoI extends Tetromino {
    

    public TetrominoI(int width) {
        super(width);
        this.first = new Piece(initialX - 1, initialY);
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
            setPiece(first, 0, -1);
            setPiece(third, 0, 1);
            setPiece(fourth, 0, 2);
            this.direction = 2;
        } else {
            setPiece(first, -1, 0);
            setPiece(third, 1, 0);
            setPiece(fourth, 2, 0);
            this.direction = 1;
        }
    }    
}
