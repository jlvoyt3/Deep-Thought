package thepackage;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ScorePage {

	public ScorePage() {
		
		Stage scoreStage = new Stage();
		Pane scorePane = new Pane();
		Scene scoreScene = new Scene(scorePane, 700, 700);
		
		
		
		
		scorePane.setStyle("-fx-background: #16A500");
		scorePane.getChildren().addAll();
		scoreStage.setScene(scoreScene);
		scoreStage.show();
		
	}
	
}
