/**
 * @author Justin Andrews
 * @version 1.0
 * @created 13-Feb-2019 4:08:00 PM
 * This creates the Instructions and Options text for the Help Menu.
 */
public class InstructionsOptions {

	/**
	 * @return returns instructionsText which is used by the MainMenu.java
	 */
	public String instructions(){

		/**
		 * instructionsText is a String variable that contains the text about the instructions for the game for the help menu
		 */
		String instructionsText = 
				"INSTRUCTIONS:\n\n"

				+ "1.) Player 1 controls their paddle using 'W' for up and 'S' for down.\n"
				+ "Player 2 controls their paddle using 'Up Arrow' for up and 'Down Arrow' for down.\n\n"

				+ "2.) The User can choose the game mode to be Player vs AI, Player vs Player, or AI vs AI.\n\n"

				+ "3.) The goal of the game is to block the ball from going past your paddle into the Score Zone "
				+ "by moving your paddle up and down.\n\n"

				+ "4.) When a player scores the ball is reset to the middle of the field and is shot in a random direction.\n\n"

				+ "5.) The first player to reach 10 points wins!";

		return instructionsText;
	}

	/**
	 * @return returns optionsText which is used by the MainMenu.java file
	 */
	public String options() {

		/**
		 * optionsText is a String variable that contains the text about the options for the game for the help menu
		 */
		String optionsText =
				"OPTIONS:\n\n"

				+ "GAME TYPE: The game type determines who the 2 players are. Player vs AI will be the user playing against an AI.\n"
				+ "Player vs Player will be the user playing against another user. AI vs AI will be 2 AI’s playing against each other.\n\n"

				+ "DIFFICULTY: The difficulty option determines the speed of the ball and the size of the paddles.\n"
				+ "Easy:\n"
				+ "Medium:\n"
				+ "Hard\n\n"

				+ "SCORING: A player scores when the ball goes past their opponents paddle into the Score Zone.\n";

		return optionsText;
	}
}