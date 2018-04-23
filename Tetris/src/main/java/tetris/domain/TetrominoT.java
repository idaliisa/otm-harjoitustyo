
package tetris.domain;

import java.util.List;

public class TetrominoT extends Tetromino {
    
    private Piece first;
    private Piece second;
    private Piece third;
    private Piece fourth;
    private int direction;

    public TetrominoT(int initialX, int initialY, List<Piece> tetromino) {
        super(initialX, initialY, tetromino);
        this.first = new Piece(initialX - 1, initialY);
        this.second = new Piece(initialX, initialY);
        this.third = new Piece(initialX + 1, initialY);
        this.fourth = new Piece(initialX, initialY + 1);
        this.direction = 1;
   
        tetromino.add(first);
        tetromino.add(second);
        tetromino.add(third);
        tetromino.add(fourth);
        
    }
    
    public void rotate() {
        if (this.direction == 1) {
            first.setX(second.getX());
            first.setY(second.getY() - 1);
            second.setX(second.getX());
            second.setY(second.getY());
            third.setX(second.getX());
            third.setY(second.getY() + 1);
            fourth.setX(second.getX() - 1);
            fourth.setY(second.getY());
            this.direction = 2;
        }
        if (this.direction == 2) {
            first.setX(second.getX() + 1);
            first.setY(second.getY());
            second.setX(second.getX());
            second.setY(second.getY());
            third.setX(second.getX() - 1);
            third.setY(second.getY());
            fourth.setX(second.getX());
            fourth.setY(second.getY() - 1);
            this.direction = 3;
        }
        if (this.direction == 3) {
            first.setX(second.getX());
            first.setY(second.getY() + 1);
            second.setX(second.getX());
            second.setY(second.getY());
            third.setX(second.getX());
            third.setY(second.getY() - 1);
            fourth.setX(second.getX() + 1);
            fourth.setY(second.getY());
            this.direction = 4;
        }
        if (this.direction == 4) {
            first.setX(second.getX() - 1);
            first.setY(second.getY());
            second.setX(second.getX());
            second.setY(second.getY());
            third.setX(second.getX() + 1);
            third.setY(second.getY());
            fourth.setX(second.getX());
            fourth.setY(second.getY() + 1);
            this.direction = 1;
        }
    }
    
}