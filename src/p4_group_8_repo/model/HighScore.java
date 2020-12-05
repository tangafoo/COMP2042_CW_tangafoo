package p4_group_8_repo.model;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import javafx.scene.image.Image;

public class HighScore extends Actor {
	
	static List<Integer> highScoreList;
	Image highScoreTitleImage;
	public static Boolean highScore = false;
	public static final String highScoreResourcePath = "file:src/main/resources/highscores/";
	public static final String highScoreFileResourcePath = "src/main/resources/highscores/";

	public void act(long now) {
		
	}
	
	public HighScore(String image) {
		highScoreTitleImage = new Image(highScoreResourcePath + image + ".png");
		setImage(highScoreTitleImage);
		setX(500);
		setY(20);	
	}

	public static List <Integer> HighScoreController(String levelNumber, int x) throws IOException {

		highScoreList = new ArrayList<>();
		File highscorefile = new File(highScoreFileResourcePath + "HighScoreFor" +  levelNumber + ".txt");

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
				System.out.println("Error in High Score Controller");
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
		for (int i = 0; i < highScoreList.size(); i++) {
			if (score >= highScoreList.get(i) ) {
				return true;
			}
		}
		return false;
	}


}
