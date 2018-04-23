
package tetris.domain;

import java.util.List;


public class TetrominoI extends Tetromino {
    
    private Piece first;
    private Piece second;
    private Piece third;
    private Piece fourth;
    private boolean horizontal;

    public TetrominoI(int initialX, int initialY, List<Piece> tetromino) {
        super(initialX, initialY, tetromino);
        this.first = new Piece(initialX - 2, initialY);
        this.second = new Piece(initialX - 1, initialY);
        this.third = new Piece(initialX, initialY);
        this.fourth = new Piece(initialX + 1, initialY);
        this.horizontal = true;
   
        tetromino.add(first);
        tetromino.add(second);
        tetromino.add(third);
        tetromino.add(fourth);
        
    }
    
    public void rotate() {
        if (this.horizontal) {
            first.setX(third.getX());
            first.setY(third.getY() - 2);
            second.setX(third.getX());
            second.setY(third.getY() -1);
            third.setX(third.getX());
            third.setY(third.getY());
            fourth.setX(third.getX());
            fourth.setY(third.getY() + 1);
            this.horizontal = false;
        } else {
            first.setX(third.getX() - 2);
            first.setY(third.getY());
            second.setX(third.getX() - 1);
            second.setY(third.getY());
            third.setX(third.getX());
            third.setY(third.getY());
            fourth.setX(third.getX() + 1);
            fourth.setY(third.getY());
            this.horizontal = true;
        }
        
                
    }
    
}
