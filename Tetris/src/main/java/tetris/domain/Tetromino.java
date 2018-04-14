
package tetris.domain;


import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public abstract class Tetromino {
    private Polygon polygon;
    private Point2D point;
    private Border bord;
    private int move;
    
    public Tetromino(Polygon polygon, int x, int y) {
        this.polygon = polygon;
        this.point = new Point2D(x, y);
        this.bord = new Border(0,0);
        this.move = 30;
        initLocation();
    }

    public void initLocation() {
        this.polygon.setTranslateX(this.point.getX());
        this.polygon.setTranslateY(this.point.getY());
    }
    
    public void setLocation(int x, int y) {
        this.polygon.setTranslateX(this.polygon.getTranslateX() + x);
        this.polygon.setTranslateY(this.polygon.getTranslateY() + y);
    }
    
    public Polygon leftMovedPolygon() {
        this.polygon.setTranslateX(this.polygon.getTranslateX() - move);
        Polygon leftMovedPolygon = this.polygon;
        this.polygon.setTranslateX(this.polygon.getTranslateX() + move);
        return leftMovedPolygon;
    }

    public Polygon rightMovedPolygon() {
        this.polygon.setTranslateX(this.polygon.getTranslateX() + move);
        Polygon rightMovedPolygon = this.polygon;
        this.polygon.setTranslateX(this.polygon.getTranslateX() - move);
        return rightMovedPolygon;        
    }

    public Polygon downMovedPolygon() {
        this.polygon.setTranslateY(this.polygon.getTranslateY() + move);
        Polygon downMovedPolygon = this.polygon;
        this.polygon.setTranslateY(this.polygon.getTranslateY() - move);
        return downMovedPolygon;
    }
    
    public Polygon rotatedPolygon() {
        this.polygon.setRotate(this.polygon.getRotate() + 90);
        Polygon rotatedPolygon = this.polygon;
        this.polygon.setRotate(this.polygon.getRotate() - 90);
        return rotatedPolygon;
    }
    
    public void moveDown() {
        this.polygon.setTranslateY(this.polygon.getTranslateY() + move);
    }
    
    public void moveLeft() {
        this.polygon.setTranslateX(this.polygon.getTranslateX() - move);
    }
    
    public void moveRight() {
        this.polygon.setTranslateX(this.polygon.getTranslateX() + move);
    }
    

    
    public boolean doesHitBorder(Polygon movedPolygon, Polygon border) {
        return this.polygon.intersect(movedPolygon, border).getBoundsInLocal().isEmpty() == false;
    }
    
    public boolean doesHitAnotherTetromino(Polygon movedPolygon, List<Polygon> tetrominos) {
        for (int i = tetrominos.size() - 1; i > -1; i--) {
            if (this.polygon.intersect(movedPolygon, tetrominos.get(i)).getBoundsInLocal().isEmpty() == false) {
                return true;
            }
        }
        return false;
    }


    public Polygon getPolygon() {
        return polygon;
    }
    
    public void rotate() {
        this.polygon.setRotate(this.polygon.getRotate() + 90);
    }
    
}

