package game;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Questions {
	private String c;
	private String d;
	private ArrayList<String> questions = new ArrayList<>();
	Questions(String category, String difficulty){
		c = category;
		d = difficulty;
	}
	Questions(){
		
	}
	
	public void Load() {
		try {
			File f1 = new File("Questions.txt");
			Scanner fRead = new Scanner(f1);
			while (fRead.hasNextLine()) {
				String[] line = fRead.nextLine().split(",");
				if (line[0].equals(c) && line[1].equals(d)) {
					questions.add(line[2] + "," + line[3]);
				}
			}
			fRead.close();
		}
		catch (Exception e) {
		}
	}
	
	public String getQuestion() {
		return randomNum();
	}
	
	private String randomNum() {
		Random rand = new Random();
		int index;
		index = rand.nextInt(questions.size());
		return questions.get(index);
	}
}