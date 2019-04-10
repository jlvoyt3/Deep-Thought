/**
 * @author willd
 * @version 1.0
 * @created 13-Feb-2019 4:08:00 PM
 */
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class BallPaddles extends Pane {

	Rectangle player1,player2;
	Circle ball;
	Text score1;
	Text score2;
	int WIDTH = 1000, HEIGHT = 400;
	int speedX = 5, speedY = 5, dx = speedX, dy = speedY, scorePlayer1 = 0, scorePlayer2 = 0, winner = 0;

	public void createGame() {

		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent ke) {
				if (ke.getCode() == KeyCode.W && player1.getLayoutX() < 30) {
					player1.setLayoutY(player1.getLayoutY() + 30);
				}
				if (ke.getCode() == KeyCode.S && player1.getLayoutX() < 320) {
					player1.setLayoutY(player1.getLayoutY() + 30);
				}
				if (ke.getCode() == KeyCode.UP && player2.getLayoutY() > 30) {
					player2.setLayoutY(player2.getLayoutY()-30);
				}
				if (ke.getCode() == KeyCode.DOWN  && player2.getLayoutY() < 320) {
					player2.setLayoutY(player2.getLayoutY()+30);
				}
			}
		});

		setPrefSize(WIDTH, HEIGHT);
		setStyle("-fx-background-color: white");

		player1 = new Rectangle(10,80, Color.BLACK);
		player1.setLayoutX(0);
		player1.setLayoutY(HEIGHT/2-40);

		player2 = new Rectangle(10,80, Color.BLACK);
		player2.setLayoutX(WIDTH-10);
		player2.setLayoutY(HEIGHT/2-40);

		ball = new Circle(5);
		ball.setFill(Color.BLACK);
		ball.setLayoutX(WIDTH/2);
		ball.setLayoutY(HEIGHT/2);

		score1 = new Text();
		score1.setLayoutX(300);
		score1.setLayoutY(300);
		score1.setText("0");

		score2 = new Text();
		score2.setLayoutX(800);
		score2.setLayoutY(300);
		score2.setText("0");

		getChildren().addAll(player1,player2,ball,score1,score2);
		
		Timeline timelineGame = new Timeline();
		timelineGame.setCycleCount(Timeline.INDEFINITE);
		KeyFrame keyframeTargets = new KeyFrame(Duration.seconds(.1), action -> {
			//
			//gameUpdate
			double x = ball.getLayoutX(), y = ball.getLayoutY();

			if (x <=10 && x > -10 && y > player1.getLayoutY() && y < player1.getLayoutY()+80) {
				dx = speedX;
			} else if (ball.getLayoutX() < -10) {
				player1.setLayoutY(HEIGHT/2-40);
				player2.setLayoutY(HEIGHT/2-40);
				ball.setLayoutX(WIDTH/2);
				ball.setLayoutY(HEIGHT/2);
				speedX = 5;
				speedY = 5;
				scorePlayer2++;

				//remove old score
				getChildren().remove(score2);
				//convert score to string
				String scorePlayer2string = Integer.toString(scorePlayer2);
				//set text to score
				score2.setText(scorePlayer2string);
				//add score to pane
				getChildren().add(score2);
			}
			
			if(x >= WIDTH-10 && x < WIDTH+10 && y > player2.getLayoutY() && y< player2.getLayoutY()+80) {
				speedX++;
				dx = -speedX;
			} else if (ball.getLayoutX() > 1010) {
				player1.setLayoutY(HEIGHT/2-40);
				player2.setLayoutY(HEIGHT/2-40);
				ball.setLayoutX(WIDTH/2);
				ball.setLayoutY(HEIGHT/2);
				speedX = 5;
				speedY = 5;
				scorePlayer1++;

				//remove old score
				getChildren().remove(score1);
				//convert score to string
				String scorePlayer1string = Integer.toString(scorePlayer1);
				//set text to score
				score1.setText(scorePlayer1string);
				//add score to pane
				getChildren().add(score1);
			}
			
			if(y <= 0) {
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
				getChildren().removeAll(ball, score1, score2, player1, player2);
				Text win1 = new Text();
				win1.setLayoutX(450);
				win1.setWrappingWidth(100);
				win1.setLayoutY(200);
				win1.setText("Player 1 wins!");
				getChildren().add(win1);
				winner = 1;
			}
			if (scorePlayer2 == 10) {
				player1.setLayoutY(HEIGHT/2-40);
				player2.setLayoutY(HEIGHT/2-40);
				ball.setLayoutX(WIDTH/2);
				ball.setLayoutY(HEIGHT/2);
				speedX = 0;
				speedY = 0;
				getChildren().removeAll(ball, score1, score2, player1, player2);
				Text win2 = new Text();
				win2.setLayoutX(450);
				win2.setWrappingWidth(100);
				win2.setLayoutY(200);
				win2.setText("Player 2 wins!");
				getChildren().add(win2);
				winner = 2;
			}

			ball.setLayoutX(ball.getLayoutX()+dx);
			ball.setLayoutY(ball.getLayoutY()+dy);
			//
			//
		});
		timelineGame.getKeyFrames().add(keyframeTargets);
		timelineGame.play();
	}
}
