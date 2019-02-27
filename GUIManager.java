// This class creates the GUI 

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GUIManager extends Application {
	MainMenu pane = new MainMenu();
	BorderPane borderpane = new BorderPane();
	Scene scene = new Scene(borderpane);
	
		
	public GUIManager() {
		borderpane.setCenter(pane);	
		borderpane.setStyle("-fx-background: #161D61");
	}
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