
package tetris.ui;

import javafx.fxml.Initializable;
import tetris.domain.TetrisService;


public abstract class FXMLController implements Initializable {
    
    public TetrisService tetrisService;
    public TetrisUi application;
    
    
    
    public void setTetrisService(TetrisService tetrisService) {
        this.tetrisService = tetrisService;
    }
    
    
    
    public void setApplication(TetrisUi application) {
        this.application = application;
    }
    
}
