
package tetris.domain;


import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public abstract class Tetromino {
    private Polygon tetromino;
    private Point2D point;
    private Border bord;
    private int move;
    private boolean active;
    
    public Tetromino(Polygon polygon, int x, int y) {
        this.tetromino = polygon;
        this.point = new Point2D(x, y);
        this.bord = new Border(0,0);
        this.move = 30;
        initLocation();
        this.active = true;
    }
    
    public void initLocation() {
        this.tetromino.setTranslateX(this.point.getX());
        this.tetromino.setTranslateY(this.point.getY());
    }
    
    public Polygon leftMovedPolygon() {
        this.tetromino.setTranslateX(this.tetromino.getTranslateX() - move);
        Polygon leftMovedPolygon = this.tetromino;
        this.tetromino.setTranslateX(this.tetromino.getTranslateX() + move);
        return leftMovedPolygon;
    }

    public Polygon rightMovedPolygon() {
        this.tetromino.setTranslateX(this.tetromino.getTranslateX() + move);
        Polygon rightMovedPolygon = this.tetromino;
        this.tetromino.setTranslateX(this.tetromino.getTranslateX() - move);
        return rightMovedPolygon;        
    }

    public Polygon downMovedPolygon() {
        this.tetromino.setTranslateY(this.tetromino.getTranslateY() + move);
        Polygon downMovedPolygon = this.tetromino;
        this.tetromino.setTranslateY(this.tetromino.getTranslateY() - move);
        return downMovedPolygon;
    }
    
    public void moveLeft() {
        if (!doesHitLeftBorder(leftMovedPolygon())) {
            this.tetromino.setTranslateX(this.tetromino.getTranslateX() - move);
        }
    }
    
    
    
    public void moveRight() {
        if (!doesHitRightBorder(rightMovedPolygon())) {
            this.tetromino.setTranslateX(this.tetromino.getTranslateX() + move);
        }
    }
    
    public void moveDown() {
        if (!doesHitLowerBorder(downMovedPolygon())) {
            this.tetromino.setTranslateY(this.tetromino.getTranslateY() + move);
        } else {
            this.active = false;
        }
    }
    
    public boolean isActive() {
        return this.active;
    }
     
    
    public boolean doesHitLeftBorder(Polygon polygon) {
        Polygon leftBorder = bord.getPolygonLeft();
        return Shape.intersect(polygon, leftBorder).getBoundsInLocal().isEmpty() == false;
    }
    
    public boolean doesHitRightBorder(Polygon polygon) {
        Polygon rightBorder = bord.getPolygonRight();
        return Shape.intersect(polygon, rightBorder).getBoundsInLocal().isEmpty() == false;
    }
    
    public boolean doesHitLowerBorder(Polygon polygon) {
        Polygon lowerBorder = bord.getPolygonLower();
        return Shape.intersect(polygon, lowerBorder).getBoundsInLocal().isEmpty() == false;
    }
    
    public boolean doesHitAnotherTetromino(Polygon polygon, List<Polygon> polygons ) {
        for (int i = 0; i < polygons.size(); i++) {
            if (Shape.intersect(polygon, polygons.get(i)).getBoundsInLocal().isEmpty() == false) {
                return true;
            }
        }
        return false;
    }

    public Polygon getTetromino() {
        return tetromino;
    }
    
    public void rotate() {
        this.tetromino.setRotate(this.tetromino.getRotate() + 90);
    }
    
}

