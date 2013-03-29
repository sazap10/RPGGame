package main;

import screens.MainMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RPGGame extends Application {
	Pane root;
	MainMenu mainMenu;
	
	

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("UCL of the Dead");
		root = new Pane();
		
		mainMenu = new MainMenu(this);
		
		switchToMainMenu();
		
		Scene scene = new Scene(root,800,600);
		scene.getStylesheets().add("stylesheet.css");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void switchToMainMenu(){
		root.getChildren().clear();
		root.getChildren().add(mainMenu);
		mainMenu.playTransition();
	}
	
	public void switchToCharCreation(){
		//root.getChildren().clear();
		//add char creation here
		//not implemented

	}
	
	public void switchToLoadGame(){
		//root.getChildren().clear();
		//add load game here
		//not implemented

	}

	public static void main(String[] args) {
		launch(args);
	}
}
