import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Hailey
 * @version 1.0
 * @created 13-Feb-2019 4:08:00 PM
 * This creates the start menu, options menu, and game menu for the game
 */
public class MainMenu extends Application {

	//change size of panes

	//


	Rectangle player1,player2,lowerBorder,lowerColor;
	// paddle size
	int paddleHeight = 80;
	Circle ball;
	Text score1;
	Text score2;
	int WIDTH = 1000, HEIGHT = 400;
	int playStyle = 0;
	int speedX = 0, speedY = 0, dx = speedX, dy = speedY, scorePlayer1 = 0, scorePlayer2 = 0, winner = 0;
	//

	/**
	 * create the stage for the main menu
	 */
	Stage stage = new Stage();
	
	
	/**
	 * create pane for the main menu
	 */
	Pane mainPane = new Pane();
	Scene mainScene = new Scene(mainPane, 1000, 600);

	Pane optionsPane = new Pane();


	/**
	 * create Text for the game name
	 */
	private Text text = new Text();	
	/**
	 * create button to start game
	 */
	private Button startButton = new Button("Start Game");
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

		mainPane.setStyle("-fx-background: #16A500");
		/**
		 * set details of newGameButton
		 */
		startButton.setLayoutX(400);
		startButton.setLayoutY(200);
		startButton.setFont(new Font(24));

		/**
		 * set details of helpButton
		 */
		helpButton.setLayoutX(400);
		helpButton.setLayoutY(300);
		helpButton.setFont( new Font(24));

		/**
		 * set details of scoreButton
		 */
		scoreButton.setLayoutX(405);
		scoreButton.setLayoutY(400);
		scoreButton.setFont( new Font(24));

		/** 
		 * set main menu title text
		 */
		text.setText("Deep Learning Pong");
		text.setLayoutX(125);
		text.setLayoutY(100);
		text.setFill(Color.BLACK);
		text.setFont(Font.font ("Gill Sans Ultra Bold", 60) );

		/**
		 * add newGameButton, helpButton, scoreButton, and text to the pane
		 */
		mainPane.getChildren().addAll(startButton, helpButton, scoreButton, text);

		/**
		 * create and format title text for the options menu
		 */
		Text title = new Text("Options");

		title.setLayoutX(325);
		title.setLayoutY(150);
		title.setFill(Color.BLACK);
		title.setFont(Font.font ("Gill Sans Ultra Bold", 60) );
		/**
		 * create back button
		 */
		Button backButton = new Button();

		/**
		 * format back button
		 */
		backButton.setText("Back");
		backButton.setFont(new Font(24) );
		backButton.setLayoutX(320);
		backButton.setLayoutY(450);

		/**
		 * create start button
		 */
		Button startGameButton = new Button();

		/**
		 * format start button
		 */
		startGameButton.setText("Start Game");
		startGameButton.setLayoutX(520);
		startGameButton.setLayoutY(450);
		startGameButton.setFont(new Font(24));

		/**
		 * create and format combo box/drop down box to choose game type
		 */
		final ComboBox<String> pickPlayers = new ComboBox<String>();
		pickPlayers.getItems().addAll(
				"Player VS Player",
				"Player VS Traditional AI",
				"Player VS Deep Learning AI"
				);
		pickPlayers.setLayoutX(220);
		pickPlayers.setLayoutY(300);
		pickPlayers.setPromptText("Choose Game Type");
		



		/**
		 * create and format combo box/drop down box to choose difficulty
		 */
		final ComboBox<String> pickDifficulty = new ComboBox<String>();
		pickDifficulty.getItems().addAll(
				"Easy",
				"Medium",
				"Hard"
				);
		pickDifficulty.setLayoutX(520);
		pickDifficulty.setLayoutY(300);
		pickDifficulty.setPromptText("Choose Difficulty");

		/**
		 * create and format combo box/drop down box to choose AI
		 */


		/**
		 * set action for newGameButton
		 */
		startButton.setOnAction(e-> {
			
			mainPane.getChildren().removeAll(startButton, helpButton, scoreButton, text);

			mainPane.getChildren().addAll(pickPlayers, pickDifficulty, title, backButton, startGameButton);
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
		 * set action of startButton to display gameScene
		 */
		
		backButton.setOnAction(e-> {

			mainPane.getChildren().removeAll(pickPlayers, pickDifficulty, title, backButton, startGameButton);
			mainPane.getChildren().addAll(startButton, helpButton, scoreButton, text);
		});
		
		startGameButton.setOnAction(e->{

			if ( pickPlayers.getValue() == null || pickDifficulty.getValue() == null) {
				
				AlertBox.display("Error", "You must set your options before the game begins.");
				
			} else {
				
				if (pickPlayers.getValue() == "Player VS Player") {
					setPlayStyle(1);
				} else if (pickPlayers.getValue() == "Player VS Traditional AI") {
					setPlayStyle(2);
				} else if (pickPlayers.getValue() == "Player VS Deep Learning AI") {
					setPlayStyle(3);
				}
				
				int playDifficulty = 0;
				
				if (pickDifficulty.getValue() == "Easy") {
					playDifficulty = 1;
					speedX = 10;
					speedY = 10;
					dx = speedX;
					dy = speedY;
				} else if (pickDifficulty.getValue() == "Medium") {
					playDifficulty = 2;
					speedX = 15;
					speedY = 15;
					dx = speedX;
					dy = speedY;
				} else if (pickDifficulty.getValue() == "Hard") {
					playDifficulty = 3;
					speedX = 20;
					speedY = 20;
					dx = speedX;
					dy = speedY;
				}
				
				mainPane.getChildren().removeAll(pickPlayers, pickDifficulty, title, startGameButton);

				if (playStyle == 1) { //starts full controls for pvp
					mainScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
						public void handle(KeyEvent ke) {
							if (ke.getCode() == KeyCode.W && player1.getLayoutY() > 1) {
								player1.setLayoutY(player1.getLayoutY() - 15);
							}
							if (ke.getCode() == KeyCode.S && player1.getLayoutY() < 320) {
								player1.setLayoutY(player1.getLayoutY() + 15);
							}
							if (ke.getCode() == KeyCode.UP && player2.getLayoutY() > 1) {
								player2.setLayoutY(player2.getLayoutY() - 15);
							}
							if (ke.getCode() == KeyCode.DOWN  && player2.getLayoutY() < 320) {
								player2.setLayoutY(player2.getLayoutY() + 15);
							}
						}
					});
				}
				else { //starts only w/s controls for pve
					mainScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
						public void handle(KeyEvent ke) {
							if (ke.getCode() == KeyCode.W && player1.getLayoutY() > 1) {
								player1.setLayoutY(player1.getLayoutY() - 15);
							}
							if (ke.getCode() == KeyCode.S && player1.getLayoutY() < 320) {
								player1.setLayoutY(player1.getLayoutY() + 15);
							}
						}
					});
				}
				mainPane.setMaxSize(WIDTH, HEIGHT);
				mainPane.setStyle("-fx-background-color: #86DB64");


				lowerColor = new Rectangle(1000,200, Color.GREEN);
				lowerColor.setLayoutX(0);
				lowerColor.setLayoutY(405);

				lowerBorder = new Rectangle(1000,10, Color.BLACK);
				lowerBorder.setLayoutX(0);
				lowerBorder.setLayoutY(400);



				if (playDifficulty == 1) {
					paddleHeight = 80;
					
				} else if (playDifficulty == 2) {
					paddleHeight = 60;
					
				} else if (playDifficulty == 3) {
					paddleHeight = 40;
				}

				player1 = new Rectangle(10,paddleHeight, Color.BLACK);
				player2 = new Rectangle(10,paddleHeight, Color.BLACK);
				
				player1.setLayoutX(0);
				player1.setLayoutY(HEIGHT/2-40);
				
				player2.setLayoutX(WIDTH-10);
				player2.setLayoutY(HEIGHT/2-40);

				ball = new Circle(5);
				ball.setFill(Color.BLACK);
				ball.setLayoutX(WIDTH/2);
				ball.setLayoutY(HEIGHT/2);

				score1 = new Text();
				score1.setLayoutX(100);
				score1.setLayoutY(500);
				score1.setFont(new Font(20));
				score1.setText("Player 1's Score: 0");
				score1.setWrappingWidth(158);

				score2 = new Text();
				score2.setLayoutX(742);
				score2.setLayoutY(500);
				score2.setFont(new Font(20));
				score2.setText("Player 2's Score: 0");
				score2.setWrappingWidth(158);
				
				helpButton.setLayoutX(425);
				helpButton.setLayoutY(450);

				mainPane.getChildren().addAll(player1,player2,ball,lowerBorder,lowerColor,score1,score2,helpButton);
				
				displayGameTime();

				Timeline timelineGame = new Timeline();
				timelineGame.setCycleCount(Timeline.INDEFINITE);
				KeyFrame keyframeTargets = new KeyFrame(Duration.seconds(.08), action -> {
					//
					//gameUpdate
					double x = ball.getLayoutX(), y = ball.getLayoutY();

					if (getPlayStyle() == 2) {
						player2.setLayoutY(MovePaddle(ball.getLayoutY(),player2.getLayoutY())+player2.getLayoutY());
					}
					
					//Move ball
					if (x <=10 && x > -10 && y > player1.getLayoutY() && y < player1.getLayoutY()+80) {
						dx = speedX;
						//Player2 score
					} else if (ball.getLayoutX() < -10) {
						player1.setLayoutY(HEIGHT/2-40);
						player2.setLayoutY(HEIGHT/2-40);
						ball.setLayoutX(WIDTH/2);
						ball.setLayoutY(HEIGHT/2);
						//speedX = 20;
						//speedY = 20;
						scorePlayer2++;

						//remove old score
						mainPane.getChildren().remove(score2);
						//convert score to string
						String scorePlayer2string = Integer.toString(scorePlayer2);
						//set text to score
						score2.setText("Player 2's Score: " + scorePlayer2string);
						//add score to pane
						mainPane.getChildren().add(score2);
					}

					//Move ball
					if(x >= WIDTH-10 && x < WIDTH+10 && y > player2.getLayoutY() && y< player2.getLayoutY()+80) {
						speedX++;
						dx = -speedX;
						//Player1 score
					} else if (ball.getLayoutX() > 1010) {
						player1.setLayoutY(HEIGHT/2-40);
						player2.setLayoutY(HEIGHT/2-40);
						ball.setLayoutX(WIDTH/2);
						ball.setLayoutY(HEIGHT/2);
						//speedX = 20;
						//speedY = 20;
						scorePlayer1++;

						//remove old score
						mainPane.getChildren().remove(score1);
						//convert score to string
						String scorePlayer1string = Integer.toString(scorePlayer1);
						//set text to score
						score1.setText("Player 1's Score: " + scorePlayer1string);
						//add score to pane
						mainPane.getChildren().add(score1);
					}

					if (y <= 0) {
						dy = speedY;
					}

					if (y >= HEIGHT-5) {
						dy = -speedY;
					}

					//end game
					if (scorePlayer1 == 10) {
						player1.setLayoutY(HEIGHT/2-40);
						player2.setLayoutY(HEIGHT/2-40);
						ball.setLayoutX(WIDTH/2);
						ball.setLayoutY(HEIGHT/2);
						speedX = 0;
						speedY = 0;
						mainPane.getChildren().removeAll(ball, score1, score2, player1, player2, helpButton);
						Text win1 = new Text();
	                    win1.setLayoutX(400);
	                    win1.setLayoutY(200);
	                   // win1.setWrappingWidth(183);
	            		win1.setFont(Font.font ("Gill Sans Ultra Bold", 28) );
	                    win1.setText("Player 1 WINS!");
	                    mainPane.getChildren().add(win1);
						winner = 1;
					}
					if (scorePlayer2 == 10) {
						player1.setLayoutY(HEIGHT/2-40);
						player2.setLayoutY(HEIGHT/2-40);
						ball.setLayoutX(WIDTH/2);
						ball.setLayoutY(HEIGHT/2);
						speedX = 0;
						speedY = 0;
						mainPane.getChildren().removeAll(ball, score1, score2, player1, player2, helpButton);
						Text win2 = new Text();
	                    win2.setLayoutX(400);
	                    win2.setLayoutY(200);
	                   // win2.setWrappingWidth(183);
	            		win2.setFont(Font.font ("Gill Sans Ultra Bold", 28) );
	                    win2.setText("Player 2 WINS!");
	                    mainPane.getChildren().add(win2);
						winner = 2;
					}

					ball.setLayoutX(ball.getLayoutX()+dx);
					ball.setLayoutY(ball.getLayoutY()+dy);
					//
					//
				});
				timelineGame.getKeyFrames().add(keyframeTargets);
				timelineGame.play();
				//
			}});
	}

	/**
	 * Start method for the program that titles and displays the stage
	 */
	public void start(Stage stage) {

		stage.setScene(mainScene);
		stage.setTitle("Deep Learning Pong");
		stage.setResizable(false);
		stage.sizeToScene();
		stage.show();

	}
	public void setPlayStyle(int x) {
		playStyle = x;
	}
	
	public int getPlayStyle() {
		return playStyle;
	}
	
	public double MovePaddle(double ballY, double paddleY) {
		double movement = 0;
		if (ballY > paddleY+15) {
			movement = 10;
		}
		else if (ballY < paddleY+15) {
			movement = -10;
		}
		return movement;
	}
	
	public void displayGameTime() {
		
		//create KeepTime variable
		KeepTime keepTime = new KeepTime();
		
		//create text box for the countdown timer
		Text time = new Text();
		time.setLayoutX(435);
		time.setLayoutY(550);
		time.setFont(new Font(20));
		mainPane.getChildren().add(time);
		//create timeline to keep time
		Timeline timelineTime = new Timeline();
		timelineTime.setCycleCount(Timeline.INDEFINITE);
		KeyFrame keyframeTime = new KeyFrame(Duration.seconds(1), action -> {
			//update with current time left
			mainPane.getChildren().removeAll(lowerBorder, lowerColor, score1, score2, helpButton, time);
			time.setText("Game Time: " + keepTime.countTime());
			mainPane.getChildren().addAll(lowerBorder, lowerColor, score1, score2, helpButton, time);
		});
		timelineTime.getKeyFrames().add(keyframeTime);
		timelineTime.play();
		//
	}

	public static void main(String[] args) {
		launch(args);
	}
}