package p4_group_8_repo.model;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import javafx.scene.image.Image;

public class HighScore extends Actor {
	
	static List<Integer> highScoreList;
	Image highScoreTitleImage;
	public static Boolean highScore = false;
	public static final String highScoreResourcePath = "file:../src/main/resources/highscores/";
	public static final String highScoreFileResourcePath = "src/p4_group_8_repo/resources/highscores/";

	public void act(long now) {
		
	}
	
	public HighScore(String image) {
		setX(500);
		setY(20);	
	}

	public static List <Integer> HighScoreList(int x) throws IOException {

		if (highScoreList == null) {
			highScoreList = new ArrayList<>(); 
		}
				
		File highscorefile = new File(highScoreFileResourcePath + "HighScores.txt");
				
			try {
				
				if (!highscorefile.exists()) {
					highscorefile.createNewFile();
				}
				
				highScoreList.add(x);

				Scanner reader = new Scanner(highscorefile);
				while (reader.hasNextLine()) {
					String data = reader.nextLine();
					highScoreList.add(Integer.parseInt(data));
				}
				highScoreList.sort(Collections.reverseOrder());
				highScoreList = highScoreList.stream().limit(5).collect(Collectors.toList());
				PrintWriter writer = new PrintWriter(highscorefile);
				highScoreList.forEach(highscore ->{
					writer.println(highscore.toString());
				});
				writer.close();

			} catch(IOException e){
				System.out.println(e);
			}

		return highScoreList;
	}


	public static String displayHighScore() {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (Integer highScore : highScoreList)
				{
			stringBuilder.append("\n");
			stringBuilder.append(highScore);
			stringBuilder.append("\n");
				}
				return stringBuilder.toString();
			}

	public static Boolean checkCurrentScoreHigher(int score) {
		
		if (highScoreList == null) {
			highScoreList = new ArrayList<>(); 
			highScoreList.add(score);
		}
		
		if (score > highScoreList.get(highScoreList.size() - 1) ) {
			return true;
		}
		return false;
	}


}
