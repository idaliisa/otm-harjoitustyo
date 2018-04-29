
package tetris.domain;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.ui.TetrisUi;


public class TetrominoLTest {
    
    TetrominoL tetromino;
    int x;
    
    public TetrominoLTest() {
    }
    
    
    @Before
    public void setUp() {
        tetromino = new TetrominoL(TetrisUi.WIDTH);
        x = TetrisUi.WIDTH / 2;
    }
    
    
    
    @Test
    public void movesDownCorrectly() {
        tetromino.moveDown();
        assertFalse(tetromino.hitY(0));
        assertTrue(tetromino.hitY(1));
        assertTrue(tetromino.hitY(2));
        assertFalse(tetromino.hitY(3));
    }
    
    @Test
    public void movesLeftCorrectly() {
        tetromino.moveLeft();
        assertFalse(tetromino.hitX(x - 2));
        assertTrue(tetromino.hitX(x - 1));
        assertTrue(tetromino.hitX(x + 1));
        assertFalse(tetromino.hitX(x + 2));    
    }
    
    @Test
    public void movesRightCorrectly() {
        tetromino.moveRight();
        assertFalse(tetromino.hitX(x));
        assertTrue(tetromino.hitX(x + 1));
        assertTrue(tetromino.hitX(x + 3));
        assertFalse(tetromino.hitX(x + 4));    
    }
    
    @Test
    public void rotatesOnceCorrectly() {
        tetromino.rotate();
        assertFalse(tetromino.hitX(x - 2));
        assertTrue(tetromino.hitX(x - 1));
        assertTrue(tetromino.hitX(x));
        assertFalse(tetromino.hitX(x + 1));
        assertFalse(tetromino.hitY(- 1));
        assertTrue(tetromino.hitY(0));
        assertTrue(tetromino.hitY(2));
        assertFalse(tetromino.hitY(3));
    }
    
    @Test
    public void rotatesTwiceCorrectly() {
        tetromino.rotate();
        tetromino.rotate();
        assertFalse(tetromino.hitX(x - 3));
        assertTrue(tetromino.hitX(x - 2));
        assertTrue(tetromino.hitX(x));
        assertFalse(tetromino.hitX(x + 1));
        assertFalse(tetromino.hitY(- 2));
        assertTrue(tetromino.hitY(- 1));
        assertTrue(tetromino.hitY(0));
        assertFalse(tetromino.hitY(1));
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
        assertFalse(tetromino.hitY(- 3));
        assertTrue(tetromino.hitY(- 2));
        assertTrue(tetromino.hitY(0));
        assertFalse(tetromino.hitY(1));
    }
    
    @Test
    public void rotatesFourTimesCorrectly() {
        tetromino.rotate();
        tetromino.rotate();
        tetromino.rotate();
        tetromino.rotate();
        assertFalse(tetromino.hitX(x - 1));
        assertTrue(tetromino.hitX(x));
        assertTrue(tetromino.hitX(x + 2));
        assertFalse(tetromino.hitX(x + 3));
        assertFalse(tetromino.hitY(- 1));
        assertTrue(tetromino.hitY(0));
        assertTrue(tetromino.hitY(1));
        assertFalse(tetromino.hitY(2));
    }
}
