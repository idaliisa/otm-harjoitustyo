
package tetris.domain;


public class TetrominoT extends Tetromino {
    


    public TetrominoT(int width) {
        super(width);
        this.first = new Piece(initialX - 1, initialY);
        this.second = new Piece(initialX, initialY);
        this.third = new Piece(initialX + 1, initialY);
        this.fourth = new Piece(initialX, initialY + 1);
   
        pieces.add(first);
        pieces.add(second);
        pieces.add(third);
        pieces.add(fourth);        
    }
    
    public void rotate() {
        if (this.direction == 1) {
            setPiece(first, 0, -1);
            setPiece(third, 0, -1);
            setPiece(fourth, -1, 0);
            this.direction = 2;
        }
        if (this.direction == 2) {
            setPiece(first, 1, 0);
            setPiece(third, -1, 0);
            setPiece(fourth, 0, -1);
            this.direction = 3;
        }
        if (this.direction == 3) {
            setPiece(first, 0, 1);
            setPiece(third, 0, -1);
            setPiece(fourth, 1, 0);
            this.direction = 4;
        }
        if (this.direction == 4) {
            setPiece(first, -1, 0);
            setPiece(third, 1, 0);
            setPiece(fourth, 0, 1);
            this.direction = 1;
        }
    }   
}