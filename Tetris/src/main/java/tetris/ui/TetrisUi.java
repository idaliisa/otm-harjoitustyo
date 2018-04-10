
package tetris.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tetris.domain.Border;
import tetris.domain.TetrominoI;


public class TetrisUi extends Application {
    public static int WIDTH = 360;
    public static int HEIGHT = 540;
    
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        pane.setPrefSize(WIDTH, HEIGHT);
        
        Border bord = new Border(0,0);
        pane.getChildren().add(bord.getPolygonLower());
        pane.getChildren().add(bord.getPolygonLeft());
        pane.getChildren().add(bord.getPolygonRight());
        
        TetrominoI tetrominoI = new TetrominoI(WIDTH/2, 0);
        pane.getChildren().add(tetrominoI.getTetromino());
        
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();    
    }
    
    public static void main(String[] args) {
        launch(args);
        System.out.println("Hello world");
    }
    
}
