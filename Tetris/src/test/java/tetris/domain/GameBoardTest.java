
package tetris.domain;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
        gb.setTetromino(new TetrominoI(WIDTH / 2, 0, new ArrayList<>()));    
    }
    
    @Test
    public void returnTrueWhenTetrominoHitsLowerBorder() {
        for (int i = 1; i < HEIGHT; i++) {
            gb.getTetromino().moveDown();
        }
        assertTrue(gb.hitLowerBorder());
        
    }
    
    @Test
    public void returnFalseeWhenTetrominoDoesNotHitLowerBorder() {
        for (int i = 1; i < HEIGHT - 1; i++){
            gb.getTetromino().moveDown();
        }
        assertFalse(gb.hitLowerBorder());
        
    }
    
}
