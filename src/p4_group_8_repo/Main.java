package p4_group_8_repo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import p4_group_8_repo.controller.InfoController;
import p4_group_8_repo.controller.MenuController;
import p4_group_8_repo.model.Animal;
import p4_group_8_repo.model.BackgroundImage;
import p4_group_8_repo.model.Digit;
import p4_group_8_repo.model.End;
import p4_group_8_repo.model.Log;
import p4_group_8_repo.model.MyStage;
import p4_group_8_repo.model.Obstacle;
import p4_group_8_repo.model.Turtle;
import p4_group_8_repo.model.WetTurtle;

public class Main extends Application {
	
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	
	Stage primaryStage;
	AnchorPane menuLayout, infoLayout, gameLayout;
	
	Scene menuScene, gameScene, infoScene;
	
	MenuController menuController;
	InfoController infoController;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("UoN FROGGER!");  
		
		createGameView();
		createInfoView();
		
		showMenuView();
		
		linkScenes();
	}
	
	public void showMenuView() throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MenuView.fxml"));
		menuLayout = (AnchorPane) loader.load();
		
		menuController = (MenuController) loader.getController();
		
		menuScene = new Scene (menuLayout);
		
		primaryStage.setScene(menuScene);
		primaryStage.show();
	}
	
	public void createInfoView() throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/InfoView.fxml"));
		infoLayout = (AnchorPane) loader.load();
		
		infoController = (InfoController) loader.getController();
		
		infoScene = new Scene (infoLayout);
		
	}
	
	public void linkScenes() {
		menuController.gameScene = this.gameScene;
		menuController.infoScene = this.infoScene;
		
		infoController.menuScene = this.menuScene;
	}
	
	public void createGameView() throws IOException {
		
		background = new MyStage();
	    gameScene  = new Scene(background,600,800);

		BackgroundImage froggerback = new BackgroundImage("file:src/p4_group_8_repo/resources/iKogsKW.png");
	    
		background.add(froggerback);
		
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 220, 166, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 440, 166, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/resources/logs.png", 300, 0, 276, -2));
		background.add(new Log("file:src/p4_group_8_repo/resources/logs.png", 300, 400, 276, -2));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 50, 329, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 270, 329, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 490, 329, 0.75));
		
		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
		
		background.add(new End(13,96));
		background.add(new End(141,96));
		background.add(new End(141 + 141-13,96));
		background.add(new End(141 + 141-13+141-13+1,96));
		background.add(new End(141 + 141-13+141-13+141-13+3,96));
		
		animal = new Animal("file:src/p4_group_8_repo/resources/froggerUp.png");
		background.add(animal);
		
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck1"+"Right.png", 0, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck1"+"Right.png", 300, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck1"+"Right.png", 600, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 100, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 250, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 400, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 550, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck2Right.png", 0, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck2Right.png", 500, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 500, 490, -5, 50, 50));
		
		background.add(new Digit(0, 30, 360, 25));
		background.start();
				
		start();
		
	}
	
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        };
    }
	
	public void start() {
		background.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }
    
}
