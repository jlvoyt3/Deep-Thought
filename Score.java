import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author Justin Andrews
 * @version 1.0
 * @created 13-Feb-2019 4:08:00 PM
 */

public class Score {

	//create variables for Score file
	/**
	 * winner is an int that holds the value of who won, player 1 or 2
	 */
	int winner;
	/**
	 * loser is an int that holds the value of who lost, player 1 or 2
	 */
	int loser;
	/**
	 * maxWinner is a String that holds the top score winner
	 */
	String maxWinner;
	/**
	 * maxLoser is an int that holds the top score loser
	 */
	int maxLoser;
	/**
	 * maxScoreLoser is an int that holds the score of the loser from the best game
	 */
	int maxScoreLoser = 10;
	/**
	 * maxGameTime is an int that holds the gameTime value from the best game
	 */
	int maxGameTime = 10000;
	/**
	 * maxPlayStyle is an int that holds the playStyle value from the best game
	 */
	int maxPlayStyle;

	//create variables for values from MainMenu
	/**
	 * prevScore1 is an int thats holds the value of player1's score from the just completed game
	 */
	int prevScore1;
	/**
	 * prevScore2 is an int that holds the value of player2's score from the just completed game
	 */
	int prevScore2;
	/**
	 * prevWinner is an int that holds the value, 1 or 2, of who won from the just completed game
	 */
	int prevWinner;
	/**
	 * prevLoserScore is an int that holds the value of the loser's score from the just completed game
	 */
	int prevLoserScore;
	/**
	 * prevGameTime is an int that holds the value of the finalGameTime from the just completed game
	 */
	int prevGameTime;
	/**
	 * prevPlayStyle is an int that holds the value, 1 or 2 or 3, of the playStyle from the just completed game
	 */
	int prevPlayStyle;

	//create file
	/**
	 * file holds the name of the file the scores are being written to
	 */
	File file = new File("Deep_Learning_Pong_Highscores.txt");
	
	/**
	 * this function determines the results from the just completed game so that other methods can use the results
	 * @param mgr mgr object from MainMenu so that this function can call functions from MainMenu
	 */
	public void determineMatchResults(MainMenu mgr) {
		prevScore1 = mgr.getFinalScore1();
		prevScore2 = mgr.getFinalScore2();
		prevGameTime = mgr.getFinalGameTime();
		prevPlayStyle = mgr.getPlayStyle();

		if (prevScore1 == 10) {
			prevWinner = 1;
			prevLoserScore = prevScore2;
		} else {
			prevWinner = 2;
			prevLoserScore = prevScore1;
		}
	}

	/**
	 * this function sorts the list of high scores to find the best
	 * @param mgr mgr object from MainMenu so that this function can call functions from MainMenu
	 */
	public void sortHighscores(MainMenu mgr) {
		try {
			// make file reader
			FileReader fileReader = new FileReader(file);
			// buffer the file reader
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			//
			String currentLine = bufferedReader.readLine();
			//read file
			while (currentLine != null) {
				//split line
				String[] splitLin = currentLine.split(" ");
				//
				int currentPlayStyle = Integer.parseInt(splitLin[3]);
				//get current game time
				int currentGameTime = Integer.parseInt(splitLin[2]);
				//get current score loser
				int currentScoreLoser = Integer.parseInt(splitLin[1]);
				//check if current score is the high score
				if (currentGameTime < maxGameTime) {
					maxWinner = splitLin[0];
					maxScoreLoser = currentScoreLoser;
					maxGameTime = currentGameTime;
					maxPlayStyle = currentPlayStyle;
				} 
				//read next line
				currentLine = bufferedReader.readLine();
			}
			//close reader
			bufferedReader.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * this function writes the game data from the just completed game to the high score file
	 * @param mgr mgr object from MainMenu so that this function can call functions from MainMenu
	 */
	public void writeScore(MainMenu mgr) {
		try {
			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			//write current score into file
			bufferedWriter.newLine();
			bufferedWriter.write(mgr.getWinner() + " " + mgr.getLoserScore() + " " + mgr.getFinalGameTime() + " " + mgr.getPlayStyle());
			bufferedWriter.close();
		} catch (Exception exp) {
		}
	}

	/**
	 * this function is used to return the winner, 1 or 2, of the best game score
	 * @return value of maxWinner
	 */
	public String getMaxWinner() {
		return maxWinner;
	}

	/**
	 * this function is used to return the loser's score of the best game
	 * @return value of maxScoreLoser
	 */
	public int getmaxScoreLoser() {
		return maxScoreLoser;
	}

	/**
	 * this function is used to return the game time of the best game
	 * @return value of maxGameTime
	 */
	public int getMaxGameTime() {
		return maxGameTime;
	}

	/**
	 * this function is used to return the play style, 1 or 2 or 3, of the best game
	 * @return value of maxPlayStyle
	 */
	public int getMaxPlayStyle() {
		return maxPlayStyle;
	}
}