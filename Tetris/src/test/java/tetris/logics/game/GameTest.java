
package tetris.logics.game;

import tetris.logics.game.Game;
import tetris.logics.game.Piece;
import tetris.logics.game.TetrominoI;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static tetris.ui.TetrisUi.HEIGHT;
import static tetris.ui.TetrisUi.WIDTH;


public class GameTest {
    Game gb;
    
    public GameTest() {
    }
    
    @Before
    public void setUp() {
        gb = new Game(WIDTH, HEIGHT);
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
    public void tetrominoMovesCorrecltyDown() {
        for (int i = 0; i <= HEIGHT; i++) {
            gb.moveTetrominoDown();
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
    public void tetrominoMovesCorrectlyLeft() {
        for (int i = 0; i < WIDTH / 2; i++) {
            gb.moveTetrominoRight();
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
    public void tetrominoMovesCorrectlyRight() {
        for (int i = 2; i < WIDTH / 2; i++){
            gb.moveTetrominoRight();
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
    
    @Test
    public void rowsDropCorrecltyWhenGotComplete() {        
        for (int i = 2; i < WIDTH / 2; i++){
            gb.moveTetrominoRight();
        }
        for (int i = 0; i <= HEIGHT; i++) {
            gb.moveTetrominoDown();
        }
        gb.moveTetrominoLeft();
        for (int i = 0; i <= HEIGHT; i++) {
            gb.moveTetrominoDown();
        }
        gb.moveTetrominoLeft();
        for (int i = 0; i <= HEIGHT; i++) {
            gb.moveTetrominoDown();
        }
        for (int i = 2; i < WIDTH / 2; i++){
            gb.moveTetrominoRight();
        }
        for (int i = 0; i <= HEIGHT; i++) {
            gb.moveTetrominoDown();
        }
        assertFalse(gb.rowComplete(HEIGHT -1));
        assertTrue(gb.getPiecesOnBoard().contains(new Piece(WIDTH / 2,HEIGHT -1)));
        assertFalse(gb.getPiecesOnBoard().contains(new Piece(1, HEIGHT -1)));
        
        
        
    }
}
