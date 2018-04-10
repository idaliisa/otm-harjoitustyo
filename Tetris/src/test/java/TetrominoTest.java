


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.TetrominoI;
import tetris.ui.TetrisUi;


public class TetrominoTest {
    
    TetrominoI tetrominoI;
    
    @Before
    public void setUp() {
        tetrominoI = new TetrominoI(TetrisUi.WIDTH/2, 0);
    }
    
    @Test
    public void returnFalseWhenTetrominoDoesNotIntersectLeftBorder() {
        assertEquals(false, tetrominoI.doesHitLeftBorder(tetrominoI.getTetromino()));
    }
    
    @Test
    public void returnTrueWhenTetrominoDoesIntersectLeftBorder() {
        tetrominoI.moveLeft();
        tetrominoI.moveLeft();
        tetrominoI.moveLeft();
        tetrominoI.moveLeft();
        tetrominoI.moveLeft();
        assertEquals(true, tetrominoI.doesHitLeftBorder(tetrominoI.getTetromino()));
    }
    
    @Test
    public void returnFalseWhenTetrominoDoesNotIntersectRightBorder() {
        assertEquals(false, tetrominoI.doesHitRightBorder(tetrominoI.getTetromino()));
    }
    
    @Test
    public void returnTrueWhenTetrominoDoesIntersectRightBorder() {
        tetrominoI.moveRight();
        tetrominoI.moveRight();
        tetrominoI.moveRight();
        tetrominoI.moveRight();
        tetrominoI.moveRight();
        assertEquals(true, tetrominoI.doesHitRightBorder(tetrominoI.getTetromino()));
    }
    
    @Test
    public void returnFalseWhenTetrominoDoesNotIntersectLowerBorder() {
        assertEquals(false, tetrominoI.doesHitLowerBorder(tetrominoI.getTetromino()));
    }
    
    @Test
    public void returnTrueWhenTetrominoDoesIntersectLowerBorder() {
        for (int i = 0; i < 34; i++) {
            tetrominoI.moveDown();
        }
        assertEquals(true, tetrominoI.doesHitLowerBorder(tetrominoI.getTetromino()));
    }
    
}
