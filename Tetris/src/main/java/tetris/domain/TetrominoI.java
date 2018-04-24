
package tetris.domain;


public class TetrominoI extends Tetromino {
    
    private boolean horizontal;

    public TetrominoI(int width) {
        super(width);
        this.first = new Piece(initialX - 2, initialY);
        this.second = new Piece(initialX - 1, initialY);
        this.third = new Piece(initialX, initialY);
        this.fourth = new Piece(initialX + 1, initialY);
        this.x = third.getX();
        this.y = third.getY();
        this.horizontal = true;
        
   
        pieces.add(first);
        pieces.add(second);
        pieces.add(third);
        pieces.add(fourth);
        
    }
    
    public void rotate() {
        if (this.horizontal) {
            first.setX(x);
            first.setY(y - 2);
            second.setX(x);
            second.setY(y -1);
            third.setX(x);
            third.setY(y);
            fourth.setX(x);
            fourth.setY(y + 1);
            this.horizontal = false;
        } else {
            first.setX(x - 2);
            first.setY(y);
            second.setX(x - 1);
            second.setY(y);
            third.setX(x);
            third.setY(y);
            fourth.setX(x + 1);
            fourth.setY(y);
            this.horizontal = true;
        }
        
                
    }
    
}
