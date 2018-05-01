
package tetris.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static tetris.ui.TetrisUi.HEIGHT;
import static tetris.ui.TetrisUi.WIDTH;


public class GameBoardTest {
    GameBoard gb;
    
    public GameBoardTest() {
    }
    
    @Before
    public void setUp() {
        gb = new GameBoard(WIDTH, HEIGHT);
        gb.setTetromino(new TetrominoI(WIDTH));    
    }
    
    @Test
    public void returnTrueWhenTetrominoHitsLowerBorder() {
        for (int i = 0; i <= HEIGHT; i++) {
            gb.getTetromino().moveDown();
        }
        assertTrue(gb.hitLowerBorder());
        
    }
    
    @Test
    public void returnFalseWhenTetrominoDoesNotHitLowerBorder() {
        for (int i = 0; i < HEIGHT; i++){
            gb.getTetromino().moveDown();
        }
        assertFalse(gb.hitLowerBorder());
        
    }
    
    @Test
    public void returnTrueWhenTetrominoHitsLeftBorder() {
        for (int i = 0; i < WIDTH / 2; i++) {
            gb.getTetromino().moveLeft();
        }
        assertTrue(gb.hitLeftBorder());
        
    }
    
    @Test
    public void returnFalseWhenTetrominoDoesNotHitLeftBorder() {
        for (int i = 1; i < WIDTH / 2; i++){
            gb.getTetromino().moveLeft();
        }
        assertFalse(gb.hitLeftBorder());
        
    }
    
    @Test
    public void returnTrueWhenTetrominoHitsRightBorder() {
        for (int i = 2; i < WIDTH / 2; i++) {
            gb.getTetromino().moveRight();
        }
        assertTrue(gb.hitRightBorder());
        
    }
    
    @Test
    public void returnFalseWhenTetrominoDoesNotHitRightBorder() {
        for (int i = 3; i < WIDTH / 2; i++){
            gb.getTetromino().moveRight();
        }
        assertFalse(gb.hitRightBorder());   
    }
    
    @Test
    public void returnTrueWhenRowComplete() {
        for (int i = 0; i < WIDTH; i++) {
            gb.getPiecesOnBoard().add(new Piece(i,0));
        }
        assertTrue(gb.rowComplete(0));
    }
    
    @Test
    public void returnFalseWhenRowNotComplete() {
        for (int i = 1; i < WIDTH; i++) {
            gb.getPiecesOnBoard().add(new Piece(i,0));
        }
        assertFalse(gb.rowComplete(0));
    }
    
    @Test
    public void gameoverIfPiecesAboveCanvas() {
        gb.getPiecesOnBoard().add(new Piece(WIDTH / 2, 0));
        gb.moveTetrominoDown();
        assertTrue(gb.gameover());
    }
    

    
    @Test
    public void rowsDrop() {
        gb.getPiecesOnBoard().add(new Piece(WIDTH - 1,0));
        assertTrue(gb.getPiecesOnBoard().contains(new Piece(WIDTH - 1,0)));
        gb.dropUpperRows(1);
        assertFalse(gb.getPiecesOnBoard().contains(new Piece(WIDTH - 1,0)));
        assertTrue(gb.getPiecesOnBoard().contains(new Piece(WIDTH - 1,1)));
    }
}
