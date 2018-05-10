
package tetris.ui.controller;

import javafx.fxml.Initializable;
import tetris.logics.TetrisService;
import tetris.ui.TetrisUi;


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
