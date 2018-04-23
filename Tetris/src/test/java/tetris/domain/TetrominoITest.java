
package tetris.domain;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.ui.TetrisUi;


public class TetrominoITest {
    
    TetrominoI tetromino;
    
    public TetrominoITest() {
    }
    
    
    @Before
    public void setUp() {
        tetromino = new TetrominoI(TetrisUi.WIDTH / 2, 0, new ArrayList<>());
    }
    
    
    
    @Test
    public void movesDownCorrectly() {
        tetromino.moveDown();
        assertFalse(tetromino.hitY(0));
        assertTrue(tetromino.hitY(1));
        assertFalse(tetromino.hitY(2));    
    }
    
    @Test
    public void movesLeftCorrectly() {
        tetromino.moveLeft();
        assertFalse(tetromino.hitX(TetrisUi.WIDTH / 2 - 4));
        assertTrue(tetromino.hitX(TetrisUi.WIDTH / 2 - 3));
        assertTrue(tetromino.hitX(TetrisUi.WIDTH / 2 + 0));
        assertFalse(tetromino.hitX(TetrisUi.WIDTH / 2 + 1));    
    }
    
    @Test
    public void movesRightCorrectly() {
        tetromino.moveRight();
        assertFalse(tetromino.hitX(TetrisUi.WIDTH / 2 - 2));
        assertTrue(tetromino.hitX(TetrisUi.WIDTH / 2 - 1));
        assertTrue(tetromino.hitX(TetrisUi.WIDTH / 2 + 2));
        assertFalse(tetromino.hitX(TetrisUi.WIDTH / 2 + 3));    
    }
    
    @Test
    public void rotatesOnceCorrectly() {
        tetromino.rotate();
        assertFalse(tetromino.hitX(TetrisUi.WIDTH / 2 - 1));
        assertTrue(tetromino.hitX(TetrisUi.WIDTH / 2));
        assertFalse(tetromino.hitX(TetrisUi.WIDTH / 2 + 1));
        assertTrue(tetromino.hitY(1));
        assertFalse(tetromino.hitY(2));
    }
    
    @Test
    public void rotatesTwiceCorrectly() {
        tetromino.rotate();
        tetromino.rotate();
        assertFalse(tetromino.hitY(- 1));
        assertTrue(tetromino.hitY(0));
        assertFalse(tetromino.hitY(1));
        assertFalse(tetromino.hitX(TetrisUi.WIDTH / 2 - 3));
        assertTrue(tetromino.hitX(TetrisUi.WIDTH / 2 - 2));
        assertTrue(tetromino.hitX(TetrisUi.WIDTH / 2 + 1));
        assertFalse(tetromino.hitX(TetrisUi.WIDTH / 2 + 2));
    }
}
