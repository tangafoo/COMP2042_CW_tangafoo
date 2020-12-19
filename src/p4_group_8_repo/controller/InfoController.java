package p4_group_8_repo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Controller class in charge of listening to events from the InfoView
 * @author Tan Ga Foo
 *
 */

public class InfoController {

	/**
	 * A reference to the menuScene existing in the infoScene
	 */
	public Scene menuScene;
	
    @FXML
    private Button backButton;

    /**
     * Function to change the scene to the main menu
     * @param event
     */
    @FXML
    void goToMenu(ActionEvent event) {
    	Stage currentStage = (Stage) backButton.getScene().getWindow();
    	
    	currentStage.setScene(menuScene);
    }

}
