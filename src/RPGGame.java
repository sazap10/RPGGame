
import screens.MainMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RPGGame extends Application {
	Pane root;

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("UCL of the Dead");
		root = new Pane();
		
		MainMenu mm = new MainMenu();
		root.getChildren().add(mm);
		mm.playTransition();
		
		Scene scene = new Scene(root,800,600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
