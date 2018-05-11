
package tetris.logics.game;


import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class describes tetromino
 * @author mikko
 */
public abstract class Tetromino {
    /**
     * Reference point at X-coordinate when Tetromino is created
     */
    public int initialX;
    /**
     * Reference point at Y-coordinate when Tetromino is created
     */
    public int initialY;
    /**
     * Each tetromino consists of four Piece objects that are stored in this list
     */
    public List<Piece> pieces;
    
    /**
     * One of four pieces that buid Tetromino
     */
    public Piece first;
    /**
     * One of four pieces that buid Tetromino
     */
    public Piece second;
    /**
     * One of four pieces that buid Tetromino
     */
    public Piece third;
    /**
     * One of four pieces that buid Tetromino
     */
    public Piece fourth;
    /**
     * Variable that facilitate to rotate Tetromino. It knows the orientation of Tetromino.
     */
    public int direction;
    

    public Tetromino(int width) {
        this.initialX = width / 2;
        this.initialY = 0;
        this.pieces = new ArrayList<>();
        this.direction = 1;
    }
    
    /**
     * This method tells the initial x-coordinate of the second piece
     * @return initial x-coordinate
     */
    public int getInitialX() {
        return initialX;
    }

    /**
     * This method tells the initial y-coordinate of the second piece
     * @return initial y-coordinate
     */
    public int getInitialY() {
        return initialY;
    }

    /**
     * This method collects the pieces that build a tetromino
     * @return a list of pieces
     */
    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }
    
    /**
     * This method iterates through the pieces that build a tetromino
     * @return the lowest y-coordinate value
     */
    public int getMinY() {
        int min = pieces.get(0).getY();
        for (int i = 1; i < pieces.size(); i++) {
            int next = pieces.get(i).getY();
            if (next < min) {
                min = next;
            }
        }
        return min;
    }
    
    /**
     * This method iterates through the pieces that build a tetromino
     * @return the highest y-coordinate value
     */
    public int getMaxY() {
        int max = pieces.get(0).getY();
        for (int i = 1; i < pieces.size(); i++) {
            int next = pieces.get(i).getY();
            if (next > max) {
                max = next;
            }
        }
        return max;
    }
    
    /**
     * This method iterates through the pieces and substacts y-coordinate values
     * by one i.e moves the tetromino one step up
     */
    public void moveUp() {
        this.pieces.stream().forEach(piece -> piece.setY(piece.getY() - 1));
    }
    
    /**
     * This method iterates through the pieces and adds y-coordinate values
     * by one i.e moves the tetromino one step down
     */
    public void moveDown() {
        this.pieces.stream().forEach(piece -> piece.setY(piece.getY() + 1));
    }
    
    /**
     * This method iterates through the pieces and substracts x-coordinate values
     * by one i.e moves the tetromino one step left
     */
    public void moveLeft() {
        this.pieces.stream().forEach(piece -> piece.setX(piece.getX() - 1));
    }
    
    /**
     * This method iterates through the pieces and adds x-coordinate values
     * by one i.e moves the tetromino one step right
     */
    public void moveRight() {
        this.pieces.stream().forEach(piece -> piece.setX(piece.getX() + 1));
    }
     
    /**
     * This method does check whether pieces overlap
     * @param pieces List of pieces
     * @return true, if the provided list has a piece that overlaps with one of tetromino's
     * pieces, otherwise false
     */
    public boolean hitPiece(List<Piece> pieces) {
        for (Piece piece : pieces) {
            if (this.pieces.contains(piece)) {
                return true;
            }   
        }
        return false;
    }
    
    /**
     * This method iterates through tetromino's pieces and does check if the x-coordinates
     * do match
     * @param x x-coordinate
     * @return true, if the tetromino overlaps the x-coordinate, otherwise false
     */
    public boolean hitX(int x) {
        for (Piece piece : pieces) {
            if (piece.getX() == x) {
                return true;
            }   
        }
        return false;
    }
    
    /**
     * This method iterates through tetromino's pieces and does check if the y-coordinates
     * do match
     * @param y y-coordinate
     * @return true, if the tetromino overlaps the y-coordinate, otherwise false
     */
    public boolean hitY(int y) {
        for (Piece piece : pieces) {
            if (piece.getY() == y) {
                return true;
            }   
        }
        return false;
    }
    
    /**
     * This astact method sets tetromino's orientation 90 degrees cloclwise
     */
    abstract void rotate();
    
    /**
     * This method sets the tetromino to the new position which is in relation to the
     * second piece
     * @param x1    new x-xoordinate of the first piece
     * @param y1    new y-xoordinate of the first piece
     * @param x3    new x-xoordinate of the third piece
     * @param y3    new y-xoordinate of the third piece
     * @param x4    new x-xoordinate of the fourth piece
     * @param y4    new y-xoordinate of the fourth piece
     */
    public void setTetromino(int x1, int y1, int x3, int y3, int x4, int y4) {
        setPiece(first, x1, y1);
        setPiece(third, x3, y3);
        setPiece(fourth, x4, y4);
    }
    
    /**
     * This method sets a piece to the new position which is in relation to the
     * second piece
     * @param piece piece that will be relocated
     * @param x new x-coordinate in relation to the one of the second piece
     * @param y new y-coordinate in relation to the one of the second piece
     */
    public void setPiece(Piece piece, int x, int y) {
        piece.setX(second.getX() + x);
        piece.setY(second.getY() + y);
    }
    
    /**
     * This method enables setting the tetromino above the gameboard
     * @param initialY new initial y-coordinate
     */
    public void initTetrominoAboveCanvas(int initialY) {
        this.initialY = initialY;
    }
}