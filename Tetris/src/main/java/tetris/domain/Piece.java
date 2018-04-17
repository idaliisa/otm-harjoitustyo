
package tetris.domain;

public class Piece {
    private int x;
    private int y;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public boolean hit(Piece piece) {
        if (piece.getX() == this.getX() && piece.getY() == this.getY()) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        
        if (getClass() != object.getClass()) {
            return false;
        }
        
        Piece piece = (Piece) object;
        if (this.x != piece.getX()) {
            return false;
        }
        
        if (this.y != piece.getY()) {
            return false;
        }
        
        return true;
    }
}
