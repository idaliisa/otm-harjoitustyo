
package tetris.domain;

import javafx.scene.shape.Polygon;
import static tetris.ui.TetrisUi.HEIGHT;
import static tetris.ui.TetrisUi.WIDTH;


public class Border {

    //private Polygon polygonUpper;
    private Polygon polygonLower;
    private Polygon polygonLeft;
    private Polygon polygonRight;

    public Border(int x, int y) {
        //this.polygonUpper = new Polygon(0, 0, WIDTH, 0, WIDTH, 15, 0, 15);
        this.polygonLower = new Polygon(0, HEIGHT - 15, WIDTH, HEIGHT -15, WIDTH, HEIGHT, 0, HEIGHT);
        this.polygonLeft = new Polygon(0, 0, 15, 0, 15, HEIGHT, 0, HEIGHT);
        this.polygonRight = new Polygon(WIDTH - 15, 0, WIDTH, 0, WIDTH, HEIGHT - 15, WIDTH - 15, HEIGHT - 15);
        
        //this.polygonUpper.setTranslateX(x);
        //this.polygonUpper.setTranslateY(y);
        
        this.polygonLower.setTranslateX(x);
        this.polygonLower.setTranslateY(y);
        
        this.polygonLeft.setTranslateX(x);
        this.polygonLeft.setTranslateY(y);
        
        this.polygonRight.setTranslateX(x);
        this.polygonRight.setTranslateY(y);
    }

//    public Polygon getPolygonUpper() {
//        return polygonUpper;
//    }

    public Polygon getPolygonLower() {
        return polygonLower;
    }

    public Polygon getPolygonLeft() {
        return polygonLeft;
    }

    public Polygon getPolygonRight() {
        return polygonRight;
    }
   
}
