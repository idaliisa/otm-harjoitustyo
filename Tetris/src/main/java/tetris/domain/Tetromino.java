
package tetris.domain;


import java.util.ArrayList;
import java.util.List;


public abstract class Tetromino {
    public int initialX;
    public int initialY;
    public List<Piece> pieces;
    
    public Piece first;
    public Piece second;
    public Piece third;
    public Piece fourth;
    public int direction;
    

    public Tetromino(int width) {
        this.initialX = width / 2;
        this.initialY = 0;
        this.pieces = new ArrayList<>();     
    }
    
    public int getInitialX() {
        return initialX;
    }

    public int getInitialY() {
        return initialY;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }
    
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
    
    public void moveUp() {
        this.pieces.stream().forEach(piece -> piece.setY(piece.getY() - 1));
    }
    
    public void moveDown() {
        this.pieces.stream().forEach(piece -> piece.setY(piece.getY() + 1));
    }
    
    public void moveLeft() {
        this.pieces.stream().forEach(piece -> piece.setX(piece.getX() - 1));
    }
    
    public void moveRight() {
        this.pieces.stream().forEach(piece -> piece.setX(piece.getX() + 1));
    }
        
    public boolean hitPiece(List<Piece> pieces) {
        for (Piece piece : pieces) {
            if (this.pieces.contains(piece)) {
                return true;
            }   
        }
        return false;
    }
    
    public boolean hitX(int x) {
        for (Piece piece : pieces) {
            if (piece.getX() == x) {
                return true;
            }   
        }
        return false;
    }
    
    public boolean hitY(int y) {
        for (Piece piece : pieces) {
            if (piece.getY() == y) {
                return true;
            }   
        }
        return false;
    }
    
    abstract void rotate();
    
    public void setTetromino(int x1, int y1, int x3, int y3, int x4, int y4) {
        setPiece(first, x1, y1);
        setPiece(third, x3, y3);
        setPiece(fourth, x4, y4);
    }
    
    public void setPiece(Piece piece, int x, int y) {
        piece.setX(second.getX() + x);
        piece.setY(second.getY() + y);
    }
}