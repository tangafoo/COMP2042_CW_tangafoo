package p4_group_8_repo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InfoController {

	public Scene menuScene;
	
    @FXML
    private Button backButton;

    @FXML
    void goToMenu(ActionEvent event) {
    	Stage currentStage = (Stage) backButton.getScene().getWindow();
    	
    	currentStage.setScene(menuScene);
    }

}
