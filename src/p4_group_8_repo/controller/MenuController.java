package p4_group_8_repo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * A controller for the MenuView
 * @author Tan Ga Foo
 *
 */

public class MenuController {

	
    @FXML
    private Button startGameButton;

    @FXML
    private Button infoButton;
    
    public Scene gameScene, infoScene;

    /**
     * display InfoView in the event the info button is clicked.
     * @param event
     */
    
    @FXML
    void infoButtonClicked(ActionEvent event) {
    	
    	Stage currentStage = (Stage) infoButton.getScene().getWindow();
    	
    	currentStage.setScene(infoScene);
    }
    
    /**
     * Start the game in the event the start game button is clicked.
     * @param event
     */

    @FXML
    void startGameClicked(ActionEvent event) {
    	
    	Stage currentStage = (Stage) startGameButton.getScene().getWindow();
    	
    	currentStage.setScene(gameScene);
    }

}

