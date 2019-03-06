
// This creates the start up menu for the game

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MainMenu extends Pane {

		//attributes
	private Stage stage = new Stage();
	private Pane pane = new Pane();
	private BorderPane borderpane = new BorderPane();
	private Pane optionPane = new Pane();
	private BorderPane optionBorderPane = new BorderPane();	
	Scene optionScene = new Scene(optionBorderPane, 600, 500);	
	private Text text = new Text();	
	
		// buttons
	private Button newGameButton = new Button("Start Game");
	private Button helpButton = new Button("Instructions");
	private Button scoreButton = new Button("Top Scores");


	
	public MainMenu() {
		
		
		newGameButton.setLayoutX(350);
		newGameButton.setLayoutY(200);
		newGameButton.setFont( new Font(24));
		
		helpButton.setLayoutX(350);
		helpButton.setLayoutY(400);
		helpButton.setFont( new Font(24));
		
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
		getChildren().add(scoreButton);
		getChildren().add(text);

		borderpane.setCenter(pane);
		optionBorderPane.setCenter(optionPane);
		
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
		
		Text title = new Text();
		
		title.setText("Options");
		title.setLayoutX(200);
		title.setLayoutY(150);
		title.setFont( new Font(60));
		title.setFill(Color.WHITE);
		
		Button backButton = new Button();
		
		backButton.setText("Back");
		backButton.setFont( new Font(24) );
		backButton.setLayoutX(200);
		backButton.setLayoutY(400);
		
		Button startButton = new Button();
		
		startButton.setText("Start Game");
		startButton.setLayoutX(350);
		startButton.setLayoutY(400);
		startButton.setFont( new Font(24));
		
		final ComboBox<String> pickPlayers = new ComboBox<String>();
		pickPlayers.getItems().addAll("Player VS AI","Player VS Player","AI VS AI");
		pickPlayers.setLayoutX(50);
		pickPlayers.setLayoutY(300);
		pickPlayers.setPromptText("Choose Game Type");

		
		final ComboBox<String> pickDifficulty = new ComboBox<String>();
		pickDifficulty.getItems().addAll("Easy","Medium","Hard");
		pickDifficulty.setLayoutX(250);
		pickDifficulty.setLayoutY(300);
		pickDifficulty.setPromptText("Choose Difficulty");
		
		final ComboBox<String> pickAI = new ComboBox<String>();
		pickAI.getItems().addAll("AI Jerry","AI Fred","AI Chad");
		pickAI.setLayoutX(450);
		pickAI.setLayoutY(300);
		pickAI.setPromptText("Choose AI");
		
		optionPane.getChildren().add(pickPlayers);
		optionPane.getChildren().add(pickDifficulty);
		optionPane.getChildren().add(pickAI);
		optionPane.getChildren().add(title);
		optionPane.getChildren().add(startButton);
//		optionPane.getChildren().add(backButton);
		optionBorderPane.setStyle("-fx-background: #161D61");
		
		
		Pane gamePane = new Pane();
		BorderPane gameBorderPane = new BorderPane();
		gameBorderPane.setCenter(gamePane);
		Scene gameScene =  new Scene(gameBorderPane, 1000, 850);
		
		startButton.setOnAction(e->{
			stage.setScene(gameScene);
		});
		
//		backButton.setOnAction(e->{
//			stage.setScene(optionScene);
//		});
		

	}
}
