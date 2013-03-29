/**
 * 
 */
package screens;

import main.RPGGame;
import javafx.animation.FadeTransition;
import javafx.animation.FadeTransitionBuilder;
import javafx.animation.ParallelTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * @author Sachin
 * @
 *
 */
public class MainMenu extends AnchorPane{
	FadeTransition fadeOutFstImage,fadeInSndImage, fadeInTitle, fadeInButtons;
	ParallelTransition pt;
	ImageView first,second,title;
	FlowPane buttonPane;
	Button newGame, loadGame, quitGame;
	RPGGame game;

	public MainMenu(RPGGame game){
		Pane pane = new Pane();
		first = new ImageView("media/first.jpg");
		second = new ImageView("media/second.png");
		title = new ImageView("media/title.png");
		title.relocate(100, -9);
		this.game = game;
		buttonPane = new FlowPane(Orientation.VERTICAL,0,20);
		buttonPane.setPrefHeight(200);
		buttonPane.setPrefWidth(200);
		buttonPane.setAlignment(Pos.CENTER);	
		buttonPane.relocate(300, 325);
		
		setUpButtons();

		buttonPane.getChildren().addAll(newGame,loadGame,quitGame);
		
		setUpTransitions();
		
		pane.getChildren().addAll(second,first,title);
		this.getChildren().addAll(pane,buttonPane);
	}
	
	private void setUpTransitions(){
		fadeOutFstImage = FadeTransitionBuilder.create()
    			.duration(Duration.seconds(5))
    			.node(first)
    			.fromValue(1.0)
    			.toValue(0)
    			.cycleCount(1)
    			.autoReverse(true)
    			.build();
        
		fadeInSndImage = FadeTransitionBuilder.create()
    			.duration(Duration.seconds(5))
    			.node(second)
    			.fromValue(0)
    			.toValue(1)
    			.cycleCount(1)
    			.autoReverse(true)
    			.build();
        
		fadeInTitle = FadeTransitionBuilder.create()
    			.duration(Duration.seconds(6))
    			.node(title)
    			.fromValue(0)
    			.toValue(1)
    			.cycleCount(1)
    			.autoReverse(true)
    			.build();
        
		fadeInButtons = FadeTransitionBuilder.create()
    			.duration(Duration.seconds(2))
    			.node(buttonPane)
    			.fromValue(0)
    			.toValue(1)
    			.cycleCount(1)
    			.autoReverse(true)
    			.build();

        pt = new ParallelTransition();
        pt.getChildren().addAll(fadeOutFstImage, fadeInSndImage,fadeInTitle,fadeInButtons);
        pt.setCycleCount(1);
        
	}
	
	private void setUpButtons(){
		newGame = new Button("New Game");
		newGame.setPrefHeight(50);
		newGame.setPrefWidth(200);
		newGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO set the scene as the character creation one
				game.switchToCharCreation();
			}});
		
		loadGame = new Button("Load Game");
		loadGame.setPrefHeight(50);
		loadGame.setPrefWidth(200);
		loadGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO set the scene as load game one
				game.switchToLoadGame();
			}});
		
		quitGame = new Button("Quit");
		quitGame.setPrefHeight(50);
		quitGame.setPrefWidth(200);
		quitGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}});
	}
	
	public void playTransition(){
		pt.play();
	}
	

}
