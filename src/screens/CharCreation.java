/**
 * 
 */
package screens;

import java.io.File;

import character.Player;
import main.RPGGame;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * @author Sachin
 * 
 */
public class CharCreation extends AnchorPane {
	RPGGame game;
	Player player;
	ImageView charAV,second;
	int currentImage;
	File[] charImagesList;
	Image avImage;
	public CharCreation(RPGGame game) {
		this.game = game;
		// set up folder of the character images, setting the list of files as
		// an array of File
		File charImagesFolder = new File("src/media/char_images/");
		charImagesList = charImagesFolder.listFiles();
		currentImage = 0;
		second = new ImageView("media/second.png");
		// setup the grid of the character creation
		GridPane grid = new GridPane();
		// grid.setGridLinesVisible(true);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(30);
		grid.setVgap(30);
		grid.setPadding(new Insets(50, 50, 50, 50));

		// Title of the screen
		Text scenetitle = new Text("New Character");
		scenetitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		grid.add(scenetitle, 0, 0, 3, 1);

		// character name label and textfield
		Label charName = new Label("Name:");
		grid.add(charName, 0, 1);
		TextField charNameTextField = new TextField();
		grid.add(charNameTextField, 1, 1, 2, 1);

		// setup the gender toggle group and their buttons
		final ToggleGroup genderToggleGroup = new ToggleGroup();

		RadioButton maleRadioButton = new RadioButton("Male");
		maleRadioButton.setToggleGroup(genderToggleGroup);
		maleRadioButton.setSelected(true);

		RadioButton femRadioButton = new RadioButton("Female");
		femRadioButton.setToggleGroup(genderToggleGroup);

		// create the gender label and add to the grid
		Label sex = new Label("Gender:");
		grid.add(sex, 0, 2);
		grid.add(maleRadioButton, 1, 2);
		grid.add(femRadioButton, 2, 2);

		// setups the character images and label, setting the viewport as the
		// image's width and height
		Label charAVLbl = new Label("Character Image:");
		avImage = new Image("media/char_images/"
				+ charImagesList[currentImage].getName());
		charAV = new ImageView(avImage);
		charAV.setViewport(new Rectangle2D(0, 0, avImage.getWidth() / 4,
				avImage.getHeight() / 4));
		charAV.setPreserveRatio(true);
		// charAV.setFitWidth(100);

		// add the label to grid
		grid.add(charAVLbl, 0, 3);
		// grid.add(charAV, 0, 4,3,1);

		FlowPane charImagePane = new FlowPane(Orientation.VERTICAL, 0, 0);
		// setup the container for the arrows
		BorderPane navBar = new BorderPane();

		// create the left and right arrows using polygons and setting a mouse
		// click event to navigate the character images
		Polygon left = new Polygon();
		left.getPoints().addAll(
				new Double[] { 10.39, 0.0, 10.39, 12.0, 0.0, 5.20 });

		Polygon right = new Polygon();
		right.getPoints().addAll(
				new Double[] { 0.0, 0.0, 0.0, 12.0, 10.39, 5.20 });

		right.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				setImage(1);
			}

		});

		left.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				setImage(-1);
			}

		});

		// add these arrows to navbar
		navBar.setLeft(left);
		navBar.setRight(right);
		navBar.setMinWidth(charImagePane.getWidth());
		charImagePane.getChildren().addAll(charAV, navBar);
		// grid.add(polygon, 0, 5);
		// grid.add(right, 2, 5);
		grid.add(charImagePane, 1, 3, 2, 2);
		this.getChildren().addAll(second,grid);

	}

	// sets the images in the character ImageView depending which of the arrows
	// is pressed, by selecting either the previous or next image in the arrow,
	// then setting the viewport to match the height and width of the new image
	private void setImage(int i) {
		if (currentImage + i == charImagesList.length) {
			currentImage = 0;
		} else if (currentImage + i == -1) {
			currentImage = charImagesList.length - 1;
		} else {
			currentImage += i;
		}
		avImage = new Image("media/char_images/"
				+ charImagesList[currentImage].getName());
		charAV.setImage(avImage);
		charAV.setViewport(new Rectangle2D(0, 0, avImage.getWidth() / 4,
				avImage.getHeight() / 4));
	}
	
	public Player returnPlayer(){
		
		return player;
	}
}
