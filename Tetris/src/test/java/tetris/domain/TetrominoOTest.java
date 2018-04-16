
package tetris.domain;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.ui.TetrisUi;


public class TetrominoOTest {
    TetrominoO tetromino;
    
    public TetrominoOTest() {
    }
    
    
    @Before
    public void setUp() {
        tetromino = new TetrominoO(TetrisUi.WIDTH / 2, 0, new ArrayList<>());
    }
    
    @Test
    public void returnTrueWhenTetrominoHitX() {
        assertTrue(tetromino.hitX(TetrisUi.WIDTH / 2));
    }
    
    @Test
    public void returnFalseWhenTetrominoDoesNotHitX() {
        assertFalse(tetromino.hitX(TetrisUi.WIDTH / 2 - 1));
    }
    
    @Test
    public void returnTrueWhenTetrominoHitY() {
        assertTrue(tetromino.hitY(0));
    }
    
    @Test
    public void returnFalseWhenTetrominoDoesNotHitY() {
        assertFalse(tetromino.hitY(3));
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
        assertFalse(tetromino.hitX(TetrisUi.WIDTH / 2 - 2));
        assertTrue(tetromino.hitX(TetrisUi.WIDTH / 2 - 1));
        assertTrue(tetromino.hitX(TetrisUi.WIDTH / 2));
        assertFalse(tetromino.hitX(TetrisUi.WIDTH / 2 + 1));    
    }
    
    @Test
    public void movesRightCorrectly() {
        tetromino.moveRight();
        assertFalse(tetromino.hitX(TetrisUi.WIDTH / 2));
        assertTrue(tetromino.hitX(TetrisUi.WIDTH / 2 + 1));
        assertTrue(tetromino.hitX(TetrisUi.WIDTH / 2 + 2));
        assertFalse(tetromino.hitX(TetrisUi.WIDTH / 2 + 3));    
    }
    
    
}
