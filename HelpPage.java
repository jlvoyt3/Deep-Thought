import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelpPage {

	public HelpPage() {


		Stage helpStage = new Stage();
		Pane helpPane = new Pane();
		Scene helpScene = new Scene(helpPane, 700, 690);

		InstructionsOptions instructionsOptions = new InstructionsOptions();

		Text instructionsTextBox = new Text(instructionsOptions.instructions());
		instructionsTextBox.setLayoutX(20);
		instructionsTextBox.setLayoutY(20);
		instructionsTextBox.setWrappingWidth(300);
		instructionsTextBox.setFont(new Font(18));

		Text optionsTextBox = new Text(instructionsOptions.options());
		optionsTextBox.setLayoutX(370);
		optionsTextBox.setLayoutY(20);
		optionsTextBox.setWrappingWidth(300);
		optionsTextBox.setFont(new Font(18));

		helpPane.getChildren().addAll(instructionsTextBox, optionsTextBox);
		helpStage.setScene(helpScene);
		helpStage.show();

	}
}
