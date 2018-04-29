
package tetris.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


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
    
    public void addTetrominoOnBoard() {
        tetromino.getPieces().stream().forEach(piece -> piecesOnBoard.add(piece));
    }
    
    public void newTetromino() {
        tetromino = drawRandomTetromino();
    }
    
    public boolean next() {
        addTetrominoOnBoard();
        if (gameover()) {
            return false;
        }
        dropIfRowComplete();
        newTetromino();
        return true;
    }
    
    public void moveTetrominoDown() {
        tetromino.moveDown();
        if (hitPiecesOnBoard() || hitLowerBorder()) {
            tetromino.moveUp();
            next();
        }
    }
    
    public void moveTetrominoRight() {
        tetromino.moveRight();
        if (hitPiecesOnBoard() || hitRightBorder()) {
            tetromino.moveLeft();
        }  
    }
    
    public void moveTetrominoLeft() {
        tetromino.moveLeft();
        if (hitPiecesOnBoard() || hitLeftBorder()) {
            tetromino.moveRight();
        }  
    }
    
    public boolean hitLowerBorder() {
        if (tetromino.hitY(height)) {
            return true;
        }
        return false;
    }
    
    public boolean hitLeftBorder() {
        if (tetromino.hitX(-1)) {
            return true;
        }
        return false;
    }
    
    public boolean hitRightBorder() {
        if (tetromino.hitX(width)) {
            return true;
        }
        return false;
    }
    
    public boolean hitPiecesOnBoard() {
        return tetromino.hitPiece(piecesOnBoard);
    }
    
    public Tetromino drawRandomTetromino() {
        Random random = new Random();
        int next = random.nextInt(7);
        if (next == 1) {
            return new TetrominoI(width);
        } else if (next == 2) {
            return new TetrominoJ(width);
        } else if (next == 3) {
            return new TetrominoL(width);
        } else if (next == 4) {
            return new TetrominoO(width);
        } else if (next == 5) {
            return new TetrominoS(width);
        } else if (next == 6) {
            return new TetrominoT(width);
        } else {
            return new TetrominoZ(width);
        }  
    }
    
    public void dropIfRowComplete() {
        int minY = tetromino.getMinY();
        int maxY = tetromino.getMaxY();
        for (int i = minY; i <= maxY; i++) {
            if (rowComplete(i)) {
                removeRow(i);
                dropUpperRows(i);
            }
        }
    }
    
    public boolean rowComplete(int i) {
        long l = piecesOnBoard.stream().filter(y -> y.getY() == i).count();
        if (l == width) {
            return true;
        }
        return false;
    }
    
    public void removeRow(int i) {
        piecesOnBoard = piecesOnBoard.stream().filter(y -> !(y.getY() == i)).collect(Collectors.toCollection(ArrayList::new));
    }
    
    public void dropUpperRows(int i) {
        piecesOnBoard.stream().filter(y -> y.getY() < i).forEach(x -> x.setY(x.getY() + 1));
    }
    
    public void rotateTetromino() {
        tetromino.rotate();
        if (hitPiecesOnBoard() || hitLeftBorder() || hitRightBorder() || hitLowerBorder()) {
            tetromino.rotate();
            tetromino.rotate();
            tetromino.rotate();
        }
    }
    
    public boolean gameover() {
        for (int i = 0; i < piecesOnBoard.size(); i++) {
            if (piecesOnBoard.get(i).getY() == -1) {
                return true;
            }
        }
        return false;
    }
}


