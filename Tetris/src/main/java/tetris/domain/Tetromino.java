
package tetris.domain;


import java.util.List;


public abstract class Tetromino {
    public int initialX;
    public int initialY;
    public List<Piece> tetromino;

    public Tetromino(int initialX, int initialY, List<Piece> tetromino) {
        this.initialX = initialX;
        this.initialY = initialY;
        this.tetromino = tetromino;
    }
    
    public int getInitialX() {
        return initialX;
    }

    public int getInitialY() {
        return initialY;
    }

    public List<Piece> getTetromino() {
        return tetromino;
    }
    
    public void moveDown() {
        this.tetromino.stream().forEach(piece -> piece.setY(piece.getY() + 1));
    }
    
    public void moveLeft() {
        this.tetromino.stream().forEach(piece -> piece.setX(piece.getX() - 1));
    }
    
    public void moveRight() {
        this.tetromino.stream().forEach(piece -> piece.setX(piece.getX() + 1));
    }
    
    public boolean hitPiece(List<Piece> pieces) {
        for (Piece piece : pieces) {
            if (tetromino.contains(piece)) {
                return true;
            }   
        }
        return false;
    }
    
    public boolean hitX(int x) {
        for (Piece piece : tetromino) {
            if (piece.getX() == x) {
                return true;
            }   
        }
        return false;
    }
    
    public boolean hitY(int y) {
        for (Piece piece : tetromino) {
            if (piece.getY() == y) {
                return true;
            }   
        }
        return false;
    }
}