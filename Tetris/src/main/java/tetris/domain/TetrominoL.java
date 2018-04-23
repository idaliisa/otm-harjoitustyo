
package tetris.domain;

import java.util.List;


public class TetrominoL extends Tetromino {
    
    private Piece first;
    private Piece second;
    private Piece third;
    private Piece fourth;
    private int direction;

    public TetrominoL(int initialX, int initialY, List<Piece> tetromino) {
        super(initialX, initialY, tetromino);
        this.first = new Piece(initialX - 1, initialY + 1);
        this.second = new Piece(initialX - 1, initialY);
        this.third = new Piece(initialX, initialY);
        this.fourth = new Piece(initialX + 1, initialY);
        this.direction = 1;
   
        tetromino.add(first);
        tetromino.add(second);
        tetromino.add(third);
        tetromino.add(fourth);
        
    }
    
    public void rotate() {
        if (this.direction == 1) {
            first.setX(third.getX() - 1);
            first.setY(third.getY() - 1);
            second.setX(third.getX());
            second.setY(third.getY() - 1);
            third.setX(third.getX());
            third.setY(third.getY());
            fourth.setX(third.getX());
            fourth.setY(third.getY() + 1);
            this.direction = 2;
        }
        if (this.direction == 2) {
            first.setX(third.getX() + 1);
            first.setY(third.getY() - 1);
            second.setX(third.getX() + 1);
            second.setY(third.getY());
            third.setX(third.getX());
            third.setY(third.getY());
            fourth.setX(third.getX() - 1);
            fourth.setY(third.getY());
            this.direction = 3;
        }
        if (this.direction == 3) {
            first.setX(third.getX() + 1);
            first.setY(third.getY() + 1);
            second.setX(third.getX());
            second.setY(third.getY() + 1);
            third.setX(third.getX());
            third.setY(third.getY());
            fourth.setX(third.getX());
            fourth.setY(third.getY() - 1);
            this.direction = 4;
        }
        if (this.direction == 4) {
            first.setX(third.getX() - 1);
            first.setY(third.getY() + 1);
            second.setX(third.getX() - 1);
            second.setY(third.getY());
            third.setX(third.getX());
            third.setY(third.getY());
            fourth.setX(third.getX() + 1);
            fourth.setY(third.getY());
            this.direction = 1;
        }
    }    
}