package pt.iscte.dcti.poo.sokoban.starter;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WriteScore{
    ArrayList<Score> scores = new ArrayList<Score>(); 
	WriteScore(){	
	}
	
	void readScore() {
		scores.add(new Score(SokobanGame.getInstance().playerName,SokobanGame.getInstance().level.getPlayer().getMoves()));
		try {
			Scanner fileScanner = new Scanner(new File("score/Score"+ SokobanGame.getInstance().level.getChar() +".txt"));
			while(fileScanner.hasNextLine()) {
				
				scores.add(new Score(fileScanner.next(),fileScanner.nextInt()));
			}
				
				fileScanner.close();
		}
		catch (FileNotFoundException | NoSuchElementException e) {
	//	System.err.println("Erro na abertura do ficheiro");
		}
		printScore();
	}
	
	
	void printScore() {
		scores.sort(new ComparadorScores());
		try {		
			FileWriter writer = new FileWriter(new File("score/Score"+ SokobanGame.getInstance().level.getChar() +".txt"),false);
			for(Score i : scores)
			writer.append(i.toString());
			writer.close();
			
	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
