
package tetris.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * This class is about the Tetris game logic
 * 
 */
public class Game {
    
    private int width;
    private int height;
    private Tetromino tetromino;
    private List<Piece> piecesOnBoard;

    public Game(int width, int height) {
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
    
    /**
     * This method collects all the pieces on the gameboard and the pieces of the
     * current tetromino
     * @return A list of all the pieces
     */
    public List<Piece> getAllPiecesOnBoard() {
        List<Piece> pieces = new ArrayList<>();
        getPiecesOnBoard().stream().forEach(p -> pieces.add(p));
        getTetromino().getPieces().stream().forEach(p -> pieces.add(p));
        return pieces;
    } 
    
    /**
     * This method adds the pieces building the current tetromino on the gameboard
     */
    public void addTetrominoOnBoard() {
        tetromino.getPieces().stream().forEach(piece -> piecesOnBoard.add(piece));
    }
    
    /**
     * This methdod sets a random tetromino as the current tetromino
     */
    public void newTetromino() {
        tetromino = drawRandomTetromino();
    }
    
    /**
     * This method moves tetromino down. If the tetromino cross the lower border
     * or overlaps pieces on the board, tetromino is not moved down but added on
     * the board. In that case the method also checks if row(s) get complete. If so,
     * the row is removed and upper rows are dropped. In addition, a new tetromino 
     * is set if the game is not over.
     */
    public void moveTetrominoDown() {
        tetromino.moveDown();
        if (hitPiecesOnBoard() || hitLowerBorder()) {
            tetromino.moveUp();
            addTetrominoOnBoard();
            dropIfRowComplete();
            if (!gameover()) {
                newTetromino();
            }
        }        
    }
    
    /**
     * This method moves tetromino right if it does not cross the right border
     * nor overlap with other pieces on the gameboard
     */
    public void moveTetrominoRight() {
        tetromino.moveRight();
        if (hitPiecesOnBoard() || hitRightBorder()) {
            tetromino.moveLeft();
        }  
    }
    
    /**
     * This method moves tetromino left if it does not cross the left border
     * nor overlap with other pieces on the gameboard
     */
    public void moveTetrominoLeft() {
        tetromino.moveLeft();
        if (hitPiecesOnBoard() || hitLeftBorder()) {
            tetromino.moveRight();
        }  
    }
    
    /**
     * This method tells whether the tetromino includes a piece having a y-coordinate 
     * equal to the height of the gameboard
     * @return true, if the lower border is crossed, otherwise false
     */
    public boolean hitLowerBorder() {
        if (tetromino.hitY(height)) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tells whether the tetromino includes a piece having a x-coordinate 
     * equal to - 1
     * @return true, if the left border is crossed, otherwise false
     */
    public boolean hitLeftBorder() {
        if (tetromino.hitX(-1)) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tells whether the tetromino includes a piece having a x-coordinate
     * equal to the width of the gameboard
     * @return true, if the right border is crossed, otherwise false
     */
    public boolean hitRightBorder() {
        if (tetromino.hitX(width)) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tells whether the tetromino does overlap one of the pieces on
     * the gameboard.
     * @return true, if the tetromino does overlap with one of the pieces on
     * the gameboard, otherwise false.
     */
    public boolean hitPiecesOnBoard() {
        return tetromino.hitPiece(piecesOnBoard);
    }
    
    /**
     * This method draw a random tetromino
     * @return TetrmoninoI/-J/-L/-O/-S/-V/-Z
     */
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
    
    /**
     * This method does check the y-coordinate(s) i.e. row(s) of the tetromino
     * and then does check whether the row(s) got complete. If so, that row(s) is 
     * removed and pieces on the upper rows are dropped down.
     * Note: the current tetromino needs to be added on the piecesOnBoard before
     * calling this method
     */
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
    
    /**
     * This method tells whether the number of pieces with a certain y-coordinate
     * equals to the width of the gameboard.
     * @param i y-coordinate
     * @return true, if the row is complete, otherwise false
     */
    public boolean rowComplete(int i) {
        long l = piecesOnBoard.stream().filter(y -> y.getY() == i).count();
        if (l == width) {
            return true;
        }
        return false;
    }
    
    /**
     * This method removes the row by iterating through piececOnBoard and filtering 
     * out all the pieces on the board that have a certain y-coordiante
     * @param i y-coordinate
     */
    public void removeRow(int i) {
        piecesOnBoard = piecesOnBoard.stream().filter(y -> !(y.getY() == i)).collect(Collectors.toCollection(ArrayList::new));
    }
    
    /**
     * This method drops upper rows by iterating through piecesOnBoard and setting 
     * new y-coordinates 
     * @param i y-coordiante
     */
    public void dropUpperRows(int i) {
        piecesOnBoard.stream().filter(y -> y.getY() < i).forEach(x -> x.setY(x.getY() + 1));
    }
    
    /**
     * This method rotates the tetromino if the rotated tetromino would not overlap
     * any border or any piece on the gameboard
     */
    public void rotateTetromino() {
        tetromino.rotate();
        if (hitPiecesOnBoard() || hitLeftBorder() || hitRightBorder() || hitLowerBorder()) {
            tetromino.rotate();
            tetromino.rotate();
            tetromino.rotate();
        }
    }
    
    /**
     * This method tells whether piecesOnBoard contains a piece that locates
     * above the gameboard
     * @return true if gameover, otherwise false
     */
    public boolean gameover() {
        for (int i = 0; i < piecesOnBoard.size(); i++) {
            if (piecesOnBoard.get(i).getY() == -1) {
                return true;
            }
        }
        return false;
    }
}


