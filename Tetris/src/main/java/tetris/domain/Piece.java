
package tetris.domain;

public class Piece {
    private int X;
    private int Y;

    public Piece(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setX(int X) {
        this.X = X;
    }

    public void setY(int Y) {
        this.Y = Y;
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
        if (this.X != piece.getX()) {
            return false;
        }
        
        if (this.Y != piece.getY()) {
            return false;
        }
        
        return true;
    }
}
