
package tetris.domain;


public class TetrominoT extends Tetromino {
    

    private int direction;

    public TetrominoT(int width) {
        super(width);
        this.first = new Piece(initialX - 1, initialY);
        this.second = new Piece(initialX, initialY);
        this.third = new Piece(initialX + 1, initialY);
        this.fourth = new Piece(initialX, initialY + 1);
        this.x = second.getX();
        this.y = second.getY();
        this.direction = 1;
   
        pieces.add(first);
        pieces.add(second);
        pieces.add(third);
        pieces.add(fourth);
        
    }
    
    public void rotate() {
        if (this.direction == 1) {
            first.setX(x);
            first.setY(y - 1);
            second.setX(x);
            second.setY(y);
            third.setX(x);
            third.setY(y + 1);
            fourth.setX(x - 1);
            fourth.setY(y);
            this.direction = 2;
        }
        if (this.direction == 2) {
            first.setX(x + 1);
            first.setY(y);
            second.setX(x);
            second.setY(y);
            third.setX(x - 1);
            third.setY(y);
            fourth.setX(x);
            fourth.setY(y - 1);
            this.direction = 3;
        }
        if (this.direction == 3) {
            first.setX(x);
            first.setY(y + 1);
            second.setX(x);
            second.setY(y);
            third.setX(x);
            third.setY(y - 1);
            fourth.setX(x + 1);
            fourth.setY(y);
            this.direction = 4;
        }
        if (this.direction == 4) {
            first.setX(x - 1);
            first.setY(y);
            second.setX(x);
            second.setY(y);
            third.setX(x + 1);
            third.setY(y);
            fourth.setX(x);
            fourth.setY(y + 1);
            this.direction = 1;
        }
    }
    
}