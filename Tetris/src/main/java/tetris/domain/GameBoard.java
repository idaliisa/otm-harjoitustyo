
package tetris.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameBoard {
    
    private int width;
    private int height;
    private Tetromino tetromino;
    private List<Piece> piecesOnBoard;

    public GameBoard(int width, int height) {
        this.width = width;
        this.height = height;
        this.tetromino = drawRandomTetromino();
        this.piecesOnBoard = new ArrayList<>();
    }

    public Tetromino getTetromino() {
        return tetromino;
    }

    public void setTetromino(Tetromino tetromino) {
        this.tetromino = tetromino;
    }

    public List<Piece> getPiecesOnBoard() {
        return piecesOnBoard;
    }
    
    public boolean newTetromino() {
        if (hitLowerBorder()) {
            tetromino.getTetromino().stream().forEach(piece -> piecesOnBoard.add(piece));
            tetromino = drawRandomTetromino();
            return true;
        }
        return false;
    }
    
    public boolean hitLowerBorder() {
        if (tetromino.hitY(height - 1)) {
            return true;
        }
        return false;
    }
    
    public boolean hitLeftBorder() {
        if (tetromino.hitX(0)) {
            return true;
        }
        return false;
    }
    
    public boolean hitRightBorder() {
        if (tetromino.hitX(width - 1)) {
            return true;
        }
        return false;
    }
    
    public Tetromino drawRandomTetromino() {
        Random random = new Random();
        int next = random.nextInt(7);
        if (next == 1) {
            return new TetrominoI(width / 2, 0, new ArrayList<>());
        } else if (next == 2) {
            return new TetrominoJ(width / 2, 0, new ArrayList<>());
        } else if (next == 3) {
            return new TetrominoL(width / 2, 0, new ArrayList<>());
        } else if (next == 4) {
            return new TetrominoO(width / 2, 0, new ArrayList<>());
        } else if (next == 5) {
            return new TetrominoS(width / 2, 0, new ArrayList<>());
        } else if (next == 6) {
            return new TetrominoT(width / 2, 0, new ArrayList<>());
        } else {
            return new TetrominoZ(width / 2, 0, new ArrayList<>());
        }  
    }
}


