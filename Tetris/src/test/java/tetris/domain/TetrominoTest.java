package tetris.domain;




import java.util.ArrayList;
import java.util.List;
import javafx.scene.shape.Polygon;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.Border;
import tetris.domain.TetrominoI;
import tetris.ui.TetrisUi;


public class TetrominoTest {
    
    TetrominoI tetrominoI;
    Border bord;
    
    @Before
    public void setUp() {
        tetrominoI = new TetrominoI(TetrisUi.WIDTH/2, 0);
        bord = new Border(0,0);
    }
    
    @Test
    public void returnFalseWhenTetrominoDoesNotIntersectBorder() {
        for (int i = 0; i < TetrisUi.HEIGHT/30 - 3; i++) {
            tetrominoI.moveDown();
        }
        assertEquals(false, tetrominoI.doesHitBorder(tetrominoI.leftMovedPolygon(), bord.getPolygonLeft()));
    }
    
    @Test
    public void returnTrueWhenTetrominoDoesIntersectBorder() {
        for (int i = 0; i < TetrisUi.HEIGHT/30 - 2; i++) {
            tetrominoI.moveDown();
        }
        assertEquals(true, tetrominoI.doesHitBorder(tetrominoI.downMovedPolygon(), bord.getPolygonLower()));
    }
    
//    @Test
//    public void returnFalseWhenTetrominoDoesNotIntersectLeftBorder() {
//        assertEquals(false, tetrominoI.doesHitLeftBorder(tetrominoI.getPolygon()));
//    }
//    
//    @Test
//    public void returnTrueWhenTetrominoDoesIntersectLeftBorder() {
//        tetrominoI.moveLeft();
//        tetrominoI.moveLeft();
//        tetrominoI.moveLeft();
//        tetrominoI.moveLeft();
//        tetrominoI.moveLeft();
//        assertEquals(true, tetrominoI.doesHitLeftBorder(tetrominoI.getPolygon()));
//    }
//    
//    @Test
//    public void returnFalseWhenTetrominoDoesNotIntersectRightBorder() {
//        assertEquals(false, tetrominoI.doesHitRightBorder(tetrominoI.getPolygon()));
//    }
//    
//    @Test
//    public void returnTrueWhenTetrominoDoesIntersectRightBorder() {
//        tetrominoI.moveRight();
//        tetrominoI.moveRight();
//        tetrominoI.moveRight();
//        tetrominoI.moveRight();
//        tetrominoI.moveRight();
//        assertEquals(true, tetrominoI.doesHitRightBorder(tetrominoI.getPolygon()));
//    }
//    
//    @Test
//    public void returnFalseWhenTetrominoDoesNotIntersectLowerBorder() {
//        assertEquals(false, tetrominoI.doesHitLowerBorder(tetrominoI.getPolygon()));
//    }
//    
//    @Test
//    public void returnTrueWhenTetrominoDoesIntersectLowerBorder() {
//        for (int i = 0; i < 34; i++) {
//            tetrominoI.moveDown();
//        }
//        assertEquals(true, tetrominoI.doesHitLowerBorder(tetrominoI.getPolygon()));
//    }
//    
//    @Test
//    public void returnFalseWhenTetrominoDoesNotIntersectAnotherTetromino() {
//        List<Polygon> polygons = new ArrayList<>();
//        TetrominoI tetrominoTest = tetrominoI;
//        
//        //places a tetromino on the lowerBorder
//        int i = 0;
//        while (!tetrominoTest.doesHitLowerBorder(tetrominoTest.getPolygon())) {
//            tetrominoTest.moveDown();
//            i++;
//        }
//        polygons.add(tetrominoTest.getPolygon());
//        
//        //places another tetromino on top of previous tetromino
//        while (i > 1) {
//            tetrominoI.moveDown();
//            i--;
//        }
//        
//        assertEquals(false, tetrominoI.doesHitAnotherTetromino(tetrominoI.getPolygon(), polygons));
//    }
//    
//    @Test
//    public void returnTrueWhenTetrominoDoesIntersectAnotherTetromino() {
//        List<Polygon> polygons = new ArrayList<>();
//        TetrominoI tetrominoTest = tetrominoI;
//        
//        //places a tetromino on the lowerBorder
//        int i = 0;
//        while (!tetrominoTest.doesHitLowerBorder(tetrominoTest.getPolygon())) {
//            tetrominoTest.moveDown();
//            i++;
//        }
//        polygons.add(tetrominoTest.getPolygon());
//        
//        //another tetromino intersects the previous tetromino
//        while (i >= 0) {
//            tetrominoI.moveDown();
//            i--;
//        }
//        
//        assertEquals(true, tetrominoI.doesHitAnotherTetromino(tetrominoI.getPolygon(), polygons));
//    }
}
