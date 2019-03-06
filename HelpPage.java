import javafx.scene.Scene;

import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Justin
 * @version 1.0
 * @created 13-Feb-2019 4:08:00 PM
 * This creates the stage, scene, pane, and text boxes for the help page
 */
public class HelpPage {

	/**
	 * creates display for help page
	 */
	public HelpPage() {

		/**
		 * creates stage used for the help menu
		 */
		Stage helpStage = new Stage();
		/**
		 * creates pane for the help menu
		 */
		Pane helpPane = new Pane();
		/**
		 * creates scene for the help menu
		 */
		Scene helpScene = new Scene(helpPane, 700, 690);

		/**
		 * create object to call instructions and options text
		 */
		InstructionsOptions instructionsOptions = new InstructionsOptions();

		/**
		 * create text box for the instructions on the help menu
		 */
		Text instructionsTextBox = new Text(instructionsOptions.instructions());
		instructionsTextBox.setLayoutX(20);
		instructionsTextBox.setLayoutY(20);
		instructionsTextBox.setWrappingWidth(300);
		instructionsTextBox.setFont(new Font(18));

		/**
		 * create text box for the options on the help menu
		 */
		Text optionsTextBox = new Text(instructionsOptions.options());
		optionsTextBox.setLayoutX(370);
		optionsTextBox.setLayoutY(20);
		optionsTextBox.setWrappingWidth(300);
		optionsTextBox.setFont(new Font(18));

		/**
		 * add text boxes to the pane then display the help menu
		 */
		//helpPane.setStyle("-fx-background: #161D61");
		helpPane.getChildren().addAll(instructionsTextBox, optionsTextBox);
		helpStage.setScene(helpScene);
		helpStage.show();

	}
}