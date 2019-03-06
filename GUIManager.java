import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Hailey 
 * @version 1.0
 * @created 13-Feb-2019 4:08:00 PM
 * This creates the GUI, formats the pane, and displays the stage
 */
public class GUIManager extends Application {

	/**
	 * create pane used for the main menu
	 */
	MainMenu pane = new MainMenu();
	/**
	 * create borderpane used for the main menu pane
	 */
	BorderPane borderpane = new BorderPane();
	/**
	 * add borderpane to the scene
	 */
	Scene scene = new Scene(borderpane);

	/**
	 * GUIManager that sets the style for the border pane
	 */
	public GUIManager() {

		borderpane.setCenter(pane);	
		borderpane.setStyle("-fx-background: #161D61");

	}

	/**
	 * Start method for the program that titles and displays the stage
	 */
	@Override
	public void start(Stage stage) {

		stage.setScene(scene);
		stage.setTitle("Deep Learning Pong");
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}