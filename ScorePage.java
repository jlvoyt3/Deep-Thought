import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScorePage {

	public ScorePage() {

		Stage scoreStage = new Stage();
		Pane scorePane = new Pane();
		Scene scoreScene = new Scene(scorePane, 700, 700);

		Text title = new Text("Top Times");
		title.setLayoutX(175);
		title.setLayoutY(100);
		title.setFont(Font.font("Gill Sans Ultra Bold", 60));

		scorePane.setStyle("-fx-background: #16A500");
		scorePane.getChildren().addAll(title);
		scoreStage.setScene(scoreScene);
		scoreStage.show();
	}
}