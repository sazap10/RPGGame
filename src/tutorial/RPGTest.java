/**
 * 
 */
package tutorial;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.RectangleBuilder;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * 
 */

/**
 * @author Sachin
 * 
 */
public class RPGTest extends Application {
	ArrayList<Image> upSprites, downSprites, leftSprites, rightSprites;
	Group obstacles;
	ImageView level, player;
	int frame = 0;
	int keyReleased =-1;
	IntegerProperty posx = new SimpleIntegerProperty(320);
	IntegerProperty posy = new SimpleIntegerProperty(80);
	boolean upKeyPressed = false, downKeyPressed = false,
			leftKeyPressed = false, rightKeyPressed = false;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("RPG-like demo");
		setUpSprites();
		setUpObstacles();
		setUpKeyBoardEvents(primaryStage);
		level = new ImageView("tutorial/images/home1.png");
		player = new ImageView("tutorial/images/down1.png");
		player.layoutXProperty().bind(posx);
		player.layoutYProperty().bind(posy);
		// player.relocate(320, 80);
		Pane pane = new Pane();

		Timeline tl = new Timeline();
		tl.setCycleCount(Animation.INDEFINITE);
		KeyFrame moveChar = new KeyFrame(Duration.seconds(.1),
				new EventHandler<ActionEvent>() {

					public void handle(ActionEvent event) {
						int nextposx = posx.intValue();
						int nextposy = posy.intValue();
						if (downKeyPressed) {
							nextposy += 5;
							player.setImage(downSprites.get(++frame % 3));
						}
						if (upKeyPressed) {
							nextposy -= 5;
							player.setImage(upSprites.get(++frame % 3));
						}
						if (rightKeyPressed) {
							nextposx += 5;
							player.setImage(rightSprites.get(++frame % 3));
						}
						if (leftKeyPressed) {
							nextposx -= 5;
							player.setImage(leftSprites.get(++frame % 3));
						}else if(keyReleased != -1){
							switch(keyReleased){
								case 0:
									player.setImage(upSprites.get(1));
									break;
									
								case 1:
									player.setImage(downSprites.get(1));
									break;
									
								case 2:
									player.setImage(leftSprites.get(1));
									break;
									
								case 3: 
									player.setImage(rightSprites.get(1));
									break;
							}
						}
						for (Node obst : obstacles.getChildren()) {
							if (obst.getBoundsInLocal().intersects(
									nextposx + 4, nextposy + 25, 19, 10)) {
								return;
							}
						}

						posx.set(nextposx);
						posy.set(nextposy);
					}
				});

		tl.getKeyFrames().add(moveChar);
		tl.play();

		pane.getChildren().addAll(obstacles, level, player);
		Scene scene = new Scene(pane, 416, 384);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void setUpKeyBoardEvents(Stage primaryStage) {
		primaryStage.addEventHandler(KeyEvent.KEY_PRESSED,
				new EventHandler<KeyEvent>() {
					@Override
					public void handle(KeyEvent e) {
						// TODO Auto-generated method stub
						switch (e.getCode()) {
						case W:
						case UP:
						case KP_UP:
							upKeyPressed = true;
							System.out.println("up pressed");
							keyReleased = -1;
							break;
						case S:
						case DOWN:
						case KP_DOWN:
							downKeyPressed = true;
							System.out.println("down pressed");
							keyReleased = -1;
							break;
						case A:
						case LEFT:
						case KP_LEFT:
							leftKeyPressed = true;
							System.out.println("left pressed");
							keyReleased = -1;
							break;
						case D:
						case RIGHT:
						case KP_RIGHT:
							rightKeyPressed = true;
							System.out.println("right pressed");
							keyReleased = -1;
							break;
						default:
							break;
						}
					}
				});

		primaryStage.addEventHandler(KeyEvent.KEY_RELEASED,
				new EventHandler<KeyEvent>() {
					@Override
					public void handle(KeyEvent e) {
						// TODO Auto-generated method stub
						switch (e.getCode()) {
						case W:
						case UP:
						case KP_UP:
							upKeyPressed = false;
							System.out.println("up released");
							keyReleased = 0;
							break;
						case S:
						case DOWN:
						case KP_DOWN:
							downKeyPressed = false;
							System.out.println("down released");
							keyReleased = 1;
							break;
						case A:
						case LEFT:
						case KP_LEFT:
							leftKeyPressed = false;
							System.out.println("left released");
							keyReleased = 2;
							break;
						case D:
						case RIGHT:
						case KP_RIGHT:
							rightKeyPressed = false;
							System.out.println("right released");
							keyReleased = 3;
							break;
						default:
							break;
						}
					}
				});
	}

	public void setUpSprites() {
		upSprites = new ArrayList<>();
		downSprites = new ArrayList<>();
		leftSprites = new ArrayList<>();
		rightSprites = new ArrayList<>();
		for (int i = 0; i <= 2; i++) {
			upSprites.add(new Image("tutorial/images/up" + i + ".png"));
			downSprites.add(new Image("tutorial/images/down" + i + ".png"));
			leftSprites.add(new Image("tutorial/images/left" + i + ".png"));
			rightSprites.add(new Image("tutorial/images/right" + i + ".png"));
		}
	}

	public void setUpObstacles() {
		obstacles = new Group();
		obstacles.getChildren().add(
				RectangleBuilder.create().x(0).y(0).width(32).height(382)
						.stroke(Color.RED).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(0).y(0).width(414).height(64)
						.stroke(Color.RED).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(384).y(0).width(32).height(382)
						.stroke(Color.RED).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(0).y(192).width(128).height(64)
						.stroke(Color.RED).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(192).y(192).width(64).height(64)
						.stroke(Color.RED).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(224).y(0).width(32).height(288)
						.stroke(Color.RED).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(288).y(128).width(96).height(64)
						.stroke(Color.RED).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(0).y(352).width(128).height(32)
						.stroke(Color.RED).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(192).y(352).width(192).height(32)
						.stroke(Color.RED).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(224).y(320).width(32).height(32)
						.stroke(Color.RED).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(32).y(64).width(32).height(32)
						.stroke(Color.YELLOW).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(64).y(64).width(32).height(32)
						.stroke(Color.YELLOW).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(96).y(64).width(32).height(32)
						.stroke(Color.YELLOW).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(128).y(64).width(64).height(32)
						.stroke(Color.YELLOW).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(192).y(32).width(32).height(32)
						.stroke(Color.YELLOW).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(64).y(128).width(64).height(32)
						.stroke(Color.YELLOW).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(32).y(250).width(32).height(32)
						.stroke(Color.YELLOW).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(64).y(250).width(64).height(32)
						.stroke(Color.YELLOW).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(200).y(255).width(20).height(20)
						.stroke(Color.YELLOW).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(200).y(170).width(20).height(20)
						.stroke(Color.YELLOW).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(257).y(32).width(32).height(32)
						.stroke(Color.YELLOW).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(288).y(32).width(32).height(32)
						.stroke(Color.YELLOW).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(320).y(192).width(64).height(64)
						.stroke(Color.YELLOW).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(352).y(295).width(32).height(60)
						.stroke(Color.YELLOW).build());
		obstacles.getChildren().add(
				RectangleBuilder.create().x(32).y(327).width(64).height(23)
						.stroke(Color.YELLOW).build());
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
