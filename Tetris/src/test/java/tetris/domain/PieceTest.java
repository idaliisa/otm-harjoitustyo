
package tetris.domain;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PieceTest {
    Piece testPiece1;
    Piece testPiece2;
    Piece testPiece3;
    
    public PieceTest() {
    }
    
    @Before
    public void setUp() {
        testPiece1 = new Piece(0,0);
        testPiece2 = new Piece(0,1); 
        testPiece3 = new Piece(0,1); 
    }
    
    @Test
    public void returnsTrueWhenPieceHitsAnotherPiece() {
        assertTrue(testPiece2.hit(testPiece3));
    }
    
    @Test
    public void returnsFalseWhenPieceDoesNotHitAnotherPiece() {
        assertFalse(testPiece1.hit(testPiece2));
    }
    
    @Test
    public void returnsTrueWhenPiecesAreEqual() {
        assertTrue(testPiece2.equals(testPiece3));
    }
    
    @Test
    public void returnsFlaseWhenPiecesAreNotEqual() {
        assertFalse(testPiece1.equals(testPiece2));
    }
    
    
}
