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

	//create variables
	int winner;
	int loser;
	String maxWinner;
	int maxLoser;
	int maxScoreWinner;
	int maxScoreLoser = 10;
	int maxGameTime = 10000;
	int maxPlayStyle;

	//
	int prevScore1;
	int prevScore2;
	int prevWinner;
	int prevLoserScore;
	int prevGameTime;
	int prevPlayStyle;

	//create file
	File file = new File("Deep_Learning_Pong_Highscores.txt");
	
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

	// sort highscores
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
				//
				//int currentWinner = Integer.parseInt(splitLin[0]);
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

	public String getMaxWinner() {
		return maxWinner;
	}

	public int getmaxScoreLoser() {
		return maxScoreLoser;
	}

	public int getMaxGameTime() {
		return maxGameTime;
	}

	public int getMaxPlayStyle() {
		return maxPlayStyle;
	}
}