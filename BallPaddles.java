/**
 * @author willd
 * @version 1.0
 * @created 13-Feb-2019 4:08:00 PM
 */
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class BallPaddles extends Application{
	
	Pane root;
	Rectangle player1,player2;
	Circle ball;
	Text score1;
	Text score2;
	AnimationTimer timer;
	private final int WIDTH = 1000, HEIGHT = 400;
	private int speedX = 5, speedY = 5, dx = speedX, dy = speedY, scorePlayer1 = 0, scorePlayer2 = 0;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		primaryStage.setTitle("pong");
		primaryStage.setScene(new Scene(createContent()));
		primaryStage.show();
		primaryStage.getScene().setOnKeyPressed(event ->{
			if (event.getCode() == KeyCode.UP && player2.getLayoutY() > 30) {
				player2.setLayoutY(player2.getLayoutY()-30);
			}
			if (event.getCode() == KeyCode.DOWN  && player2.getLayoutY() < 320) {
				player2.setLayoutY(player2.getLayoutY()+30);
			}
			if (event.getCode() == KeyCode.W  && player1.getLayoutY() > 30) {
				player1.setLayoutY(player1.getLayoutY()-30);
			}
			if (event.getCode() == KeyCode.S  && player1.getLayoutY() < 320) {
				player1.setLayoutY(player1.getLayoutY()+30);
			}
		});
	
	}
	
	private Parent createContent() {
		
		root = new Pane();
		root.setPrefSize(WIDTH, HEIGHT);
		root.setStyle("-fx-background-color: white");
		
		
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
		score1.setLayoutX(800);
		score1.setLayoutY(300);
		score1.setText("0");
		
		score2 = new Text();
		score2.setLayoutX(300);
		score2.setLayoutY(300);
		score2.setText("0");
		
		
		root.getChildren().addAll(player1,player2,ball,score1,score2);
		
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				gameUpdate();
			}
		};
		timer.start();
		
		return root;
	}
	private void gameUpdate() {	
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
			root.getChildren().remove(score2);
			//convert score to string
			String scorePlayer2string = Integer.toString(scorePlayer2);
			//set text to score
			score2.setText(scorePlayer2string);
			//add score to pane
			root.getChildren().add(score2);
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
			root.getChildren().remove(score1);
			//convert score to string
			String scorePlayer1string = Integer.toString(scorePlayer1);
			//set text to score
			score1.setText(scorePlayer1string);
			//add score to pane
			root.getChildren().add(score1);
		}
		if(y <= 0) {
			dy = speedY;
		}
		if (y >= HEIGHT-5) {
			dy = -speedY;
		}
		
		ball.setLayoutX(ball.getLayoutX()+dx);
		ball.setLayoutY(ball.getLayoutY()+dy);
		
	}
	public void score() {
		
		
	}
	
	public static void main(String[] args) { 
		launch(args);
	}
	
}
