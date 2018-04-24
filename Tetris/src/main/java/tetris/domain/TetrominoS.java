
package tetris.domain;



public class TetrominoS extends Tetromino {
    
    private int direction;

    public TetrominoS(int width) {
        super(width);
        this.first = new Piece(initialX - 1, initialY + 1);
        this.second = new Piece(initialX, initialY + 1);
        this.third = new Piece(initialX, initialY);
        this.fourth = new Piece(initialX + 1, initialY);
        this.x = third.getX();
        this.y = third.getY();
        this.direction = 1;
   
        pieces.add(first);
        pieces.add(second);
        pieces.add(third);
        pieces.add(fourth);
        
    }
    
    public void rotate() {
        if (this.direction == 1) {
            first.setX(x - 1);
            first.setY(y - 1);
            second.setX(x - 1);
            second.setY(y);
            third.setX(x);
            third.setY(y);
            fourth.setX(x);
            fourth.setY(y + 1);
            this.direction = 2;
        }
        if (this.direction == 2) {
            first.setX(x + 1);
            first.setY(y - 1);
            second.setX(x);
            second.setY(y - 1);
            third.setX(x);
            third.setY(y);
            fourth.setX(x - 1);
            fourth.setY(y);
            this.direction = 3;
        }
        if (this.direction == 3) {
            first.setX(x + 1);
            first.setY(y + 1);
            second.setX(x + 1);
            second.setY(y);
            third.setX(x);
            third.setY(y);
            fourth.setX(x);
            fourth.setY(y - 1);
            this.direction = 4;
        }
        if (this.direction == 4) {
            first.setX(x - 1);
            first.setY(y + 1);
            second.setX(x);
            second.setY(y + 1);
            third.setX(x);
            third.setY(y);
            fourth.setX(x + 1);
            fourth.setY(y);
            this.direction = 1;
        }
    }
    
}

