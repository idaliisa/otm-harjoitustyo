
package tetris.logics.game;


import tetris.logics.game.TetrominoZ;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.ui.TetrisUi;


public class TetrominoZTest {
    
    TetrominoZ tetromino;
    int x;
    int y;
    
    public TetrominoZTest() {
    }
    
    
    @Before
    public void setUp() {
        tetromino = new TetrominoZ(TetrisUi.WIDTH);
        x = TetrisUi.WIDTH / 2;
        y = -2;
    }
    
    
    
    @Test
    public void movesDownCorrectly() {
        tetromino.moveDown();
        assertFalse(tetromino.hitY(y));
        assertTrue(tetromino.hitY(y + 1));
        assertTrue(tetromino.hitY(y + 2));
        assertFalse(tetromino.hitY(y + 3));
    }
    
    @Test
    public void movesLeftCorrectly() {
        tetromino.moveLeft();
        assertFalse(tetromino.hitX(x - 3));
        assertTrue(tetromino.hitX(x - 2));
        assertTrue(tetromino.hitX(x + 0));
        assertFalse(tetromino.hitX(x + 1));    
    }
    
    @Test
    public void movesRightCorrectly() {
        tetromino.moveRight();
        assertFalse(tetromino.hitX(x - 1));
        assertTrue(tetromino.hitX(x));
        assertTrue(tetromino.hitX(x + 2));
        assertFalse(tetromino.hitX(x + 3));    
    }
    
    @Test
    public void rotatesOnceCorrectly() {
        tetromino.rotate();
        assertFalse(tetromino.hitX(x - 2));
        assertTrue(tetromino.hitX(x - 1));
        assertTrue(tetromino.hitX(x));
        assertFalse(tetromino.hitX(x + 1));
        assertFalse(tetromino.hitY(y - 2));
        assertTrue(tetromino.hitY(y - 1));
        assertTrue(tetromino.hitY(y + 1));
        assertFalse(tetromino.hitY(y + 2));
    }
    
    @Test
    public void rotatesTwiceCorrectly() {
        tetromino.rotate();
        tetromino.rotate();
        assertFalse(tetromino.hitX(x - 2));
        assertTrue(tetromino.hitX(x - 1));
        assertTrue(tetromino.hitX(x + 1));
        assertFalse(tetromino.hitX(x + 2));
        assertFalse(tetromino.hitY(y - 2));
        assertTrue(tetromino.hitY(y - 1));
        assertTrue(tetromino.hitY(y));
        assertFalse(tetromino.hitY(y + 1));
    }
    
    @Test
    public void rotatesThreeTimesCorrectly() {
        tetromino.rotate();
        tetromino.rotate();
        tetromino.rotate();
        assertFalse(tetromino.hitX(x - 1));
        assertTrue(tetromino.hitX(x));
        assertTrue(tetromino.hitX(x + 1));
        assertFalse(tetromino.hitX(x + 2));
        assertFalse(tetromino.hitY(y - 2));
        assertTrue(tetromino.hitY(y - 1));
        assertTrue(tetromino.hitY(y + 1));
        assertFalse(tetromino.hitY(y + 2));
    }
    
    @Test
    public void rotatesFourTimesCorrectly() {
        tetromino.rotate();
        tetromino.rotate();
        tetromino.rotate();
        tetromino.rotate();
        assertFalse(tetromino.hitX(x - 2));
        assertTrue(tetromino.hitX(x - 1));
        assertTrue(tetromino.hitX(x + 1));
        assertFalse(tetromino.hitX(x + 2));
        assertFalse(tetromino.hitY(y- 1));
        assertTrue(tetromino.hitY(y));
        assertTrue(tetromino.hitY(y + 1));
        assertFalse(tetromino.hitY(y + 2));
    }
}
