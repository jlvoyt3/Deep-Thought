
// This creates the start up menu for the game

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MainMenu extends Pane {

	// buttons
	private Button newGameButton = new Button("Start Game");
	private Button helpButton = new Button("Instructions");
	private Button optionsButton = new Button("Options");
	private Button scoreButton = new Button("Top Scores");
	private Text text= new Text();
	
	private Stage stage = new Stage();
	private BorderPane optionBorderPane = new BorderPane();	
	private Pane optionPane = new Pane();
	Scene optionScene = new Scene(optionBorderPane, 1500, 800);
	
	public MainMenu() {
		newGameButton.setLayoutX(350);
		newGameButton.setLayoutY(200);
		newGameButton.setFont( new Font(24));
		
		helpButton.setLayoutX(350);
		helpButton.setLayoutY(400);
		helpButton.setFont( new Font(24));
		
		optionsButton.setLayoutX(365);
		optionsButton.setLayoutY(300);
		optionsButton.setFont( new Font(24));
		
		scoreButton.setLayoutX(355);
		scoreButton.setLayoutY(500);
		scoreButton.setFont( new Font(24));
		
		text.setText("Deep Learning Pong");
		text.setLayoutX(175);
		text.setLayoutY(100);
		text.setFill(Color.WHITE);
		text.setFont(new Font(60) );

		
		setPrefWidth(900);
		setPrefHeight(600);

		getChildren().add(newGameButton);
		getChildren().add(helpButton);
		getChildren().add(optionsButton);
		getChildren().add(scoreButton);
		getChildren().add(text);

		optionPane.setCenter(pane);
		optionBorderPane.setCenter(optionPane);
		
	//	borderpane.setCenter(pane);
	//  gameBorderPane.setCenter(gamePane);
		newGameButton.setOnAction(e-> {
			
			stage.setScene(optionScene);
			stage.show();
		});
		
		helpButton.setOnAction(e-> {
			new HelpPage();
		});
		
		scoreButton.setOnAction(e-> {
			new ScorePage();
		});
	}
}
