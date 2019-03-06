import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Hailey
 * @version 1.0
 * @created 13-Feb-2019 4:08:00 PM
 * This creates the start menu, options menu, and game menu for the game
 */
public class MainMenu extends Pane {

	/**
	 * create the stage for the main menu
	 */
	private Stage stage = new Stage();
	/**
	 * create pane for the main menu
	 */
	private Pane pane = new Pane();
	/**
	 * create the borderpane the pane is placed into
	 */
	private BorderPane borderpane = new BorderPane();
	/**
	 * create the pane for the options menu
	 */
	private Pane optionPane = new Pane();
	/**
	 * create the borderpane the optionPane is placed into
	 */
	private BorderPane optionBorderPane = new BorderPane();	
	/**
	 * place the optionBorderPane into the scene
	 */
	Scene optionScene = new Scene(optionBorderPane, 600, 500);	
	/**
	 * create Text for the game name
	 */
	private Text text = new Text();	

	/**
	 * create button to start game
	 */
	private Button newGameButton = new Button("Start Game");
	/**
	 * create button for the help menu
	 */
	private Button helpButton = new Button("Instructions");
	/**
	 * create button to display the top scores
	 */
	private Button scoreButton = new Button("Top Scores");

	/**
	 * creates and contains the features and functionality of the main menu, options menu, and help menu
	 */
	public MainMenu() {

		/**
		 * set details of newGameButton
		 */
		newGameButton.setLayoutX(350);
		newGameButton.setLayoutY(200);
		newGameButton.setFont( new Font(24));

		/**
		 * set details of helpButton
		 */
		helpButton.setLayoutX(350);
		helpButton.setLayoutY(400);
		helpButton.setFont( new Font(24));

		/**
		 * set details of scoreButton
		 */
		scoreButton.setLayoutX(355);
		scoreButton.setLayoutY(500);
		scoreButton.setFont( new Font(24));

		/** 
		 * set main menu title text
		 */
		text.setText("Deep Learning Pong");
		text.setLayoutX(175);
		text.setLayoutY(100);
		text.setFill(Color.WHITE);
		text.setFont(new Font(60) );

		/**
		 * set width and height of main menu scene
		 */
		setPrefWidth(900);
		setPrefHeight(600);

		/**
		 * add newGameButton, helpButton, scoreButton, and text to the pane
		 */
		getChildren().addAll(newGameButton, helpButton, scoreButton, text);

		/**
		 * format pane and optionPane
		 */
		borderpane.setCenter(pane);
		optionBorderPane.setCenter(optionPane);

		/**
		 * set action for newGameButton
		 */
		newGameButton.setOnAction(e-> {
			stage.setScene(optionScene);
			stage.show();
		});

		/**
		 * set action for helpButton
		 */
		helpButton.setOnAction(e-> {
			new HelpPage();
		});

		/**
		 * set action for scoreButton
		 */
		scoreButton.setOnAction(e-> {
			new ScorePage();
		});

		/**
		 * create and format title text for the options menu
		 */
		Text title = new Text();
		title.setText("Options");
		title.setLayoutX(200);
		title.setLayoutY(150);
		title.setFont( new Font(60));
		title.setFill(Color.WHITE);

		/**
		 * create back button
		 */
		Button backButton = new Button();

		/**
		 * format back button
		 */
		backButton.setText("Back");
		backButton.setFont( new Font(24) );
		backButton.setLayoutX(200);
		backButton.setLayoutY(400);

		/**
		 * create start button
		 */
		Button startButton = new Button();

		/**
		 * format start button
		 */
		startButton.setText("Start Game");
		startButton.setLayoutX(350);
		startButton.setLayoutY(400);
		startButton.setFont( new Font(24));

		/**
		 * create and format combo box/drop down box to choose game type
		 */
		final ComboBox<String> pickPlayers = new ComboBox<String>();
		pickPlayers.getItems().addAll("Player VS AI","Player VS Player","AI VS AI");
		pickPlayers.setLayoutX(50);
		pickPlayers.setLayoutY(300);
		pickPlayers.setPromptText("Choose Game Type");

		/**
		 * create and format combo box/drop down box to choose difficulty
		 */
		final ComboBox<String> pickDifficulty = new ComboBox<String>();
		pickDifficulty.getItems().addAll("Easy","Medium","Hard");
		pickDifficulty.setLayoutX(250);
		pickDifficulty.setLayoutY(300);
		pickDifficulty.setPromptText("Choose Difficulty");

		/**
		 * create and format combo box/drop down box to choose AI
		 */
		final ComboBox<String> pickAI = new ComboBox<String>();
		pickAI.getItems().addAll("AI Jerry","AI Fred","AI Chad");
		pickAI.setLayoutX(450);
		pickAI.setLayoutY(300);
		pickAI.setPromptText("Choose AI");

		/**
		 * add features to optionPane and format background
		 */
		optionPane.getChildren().addAll(pickPlayers, pickDifficulty, pickAI, title, startButton);
		//optionPane.getChildren().add(backButton);
		optionBorderPane.setStyle("-fx-background: #161D61");

		/**
		 * create and format gamePane, gamePorderPane, gameScene
		 */
		Pane gamePane = new Pane();
		BorderPane gameBorderPane = new BorderPane();
		gameBorderPane.setCenter(gamePane);
		Scene gameScene =  new Scene(gameBorderPane, 1000, 850);

		/**
		 * set action of startButton to display gameScene
		 */
		startButton.setOnAction(e->{
			stage.setScene(gameScene);
		});

		//backButton.setOnAction(e->{
		//	stage.setScene(optionScene);
		//});
	}
}