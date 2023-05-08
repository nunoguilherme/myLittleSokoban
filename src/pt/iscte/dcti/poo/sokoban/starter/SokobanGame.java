
/*
         PROBLEMAS A RESOLVER:
-FAZER AS CAIXAS DESLIZAR NO GELO
- ORDENAR SCORES






*/


package pt.iscte.dcti.poo.sokoban.starter;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.observer.Observed;
import pt.iul.ista.poo.observer.Observer;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;

public class SokobanGame implements Observer{
 	
	private static SokobanGame INSTANCE; 
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	List<AbstractObjects> ListaAbstractObjects;
	Level level = new Level();
	WriteScore Score = new WriteScore();
	String playerName;
	private int nLevel=0;

	public SokobanGame(){
		readPlayer();
		startGame();
	}
	
	public static SokobanGame getInstance(){
		if (INSTANCE == null)
            INSTANCE = new SokobanGame();
        return INSTANCE;
	}

	private void startGame(){
		ListaAbstractObjects = level.listaNiveis();
		ListaAbstractObjects.add(level.getPlayer());
		List<ImageTile>  ListaImageTile = new ArrayList<ImageTile>(ListaAbstractObjects);
		ImageMatrixGUI.getInstance().addImages(ListaImageTile);
		ImageMatrixGUI.getInstance().setStatusMessage("Level: "+ level.getChar() + " Moves: " + level.getPlayer().getMoves() + " Energy: " + level.getPlayer().getEnergy() );
	}
	
	private boolean isCompleted(){
		int a=0;
		for( AbstractObjects i: SokobanGame.getInstance().level.getAlvo()) {
			for(AbstractObjects j: SokobanGame.getInstance().getList()) {
				if( j instanceof Caixote) {
					if(i.getPosition().equals(j.getPosition())) 
						a++;
				}
			}
		}
				
		if(!(a==level.getNalvos())){
		return false; }
		return true; }
	
	private void nextLevel() {
		level = new Level();
		nLevel++;
		if(nLevel<=2) {
		SokobanGame.getInstance().level.setNumbLevel(nLevel);
		ImageMatrixGUI.getInstance().update();
		ListaAbstractObjects = level.listaNiveis();
		ListaAbstractObjects.add(level.getPlayer());
		List<ImageTile>  ListaImageTile = new ArrayList<ImageTile>(ListaAbstractObjects);
		ImageMatrixGUI.getInstance().addImages(ListaImageTile);
		}
		else {
			System.out.println("COMPLETOU O JOGO!");
			gameOver();
				
		}
	}
	
	private void readPlayer() {
    	System.out.println("QUAL É O SEU NOME?");
    	Scanner in = new Scanner(System.in);
    	playerName = in.next();
    	System.out.println("BOA SORTE: " + playerName);
    }

	@Override
	public void update(Observed arg0) {
		int lastKeyPressed = ((ImageMatrixGUI)arg0).keyPressed();
		if(Direction.isDirection(lastKeyPressed)) {
		level.getPlayer().move(Direction.directionFor(lastKeyPressed),lastKeyPressed);
		if(isCompleted() == true) {
			if(nLevel<=2) {
			Score.readScore();
			System.out.println("NIVEL " + level.getChar() + " COMPLETO COM O SCORE DE: " + level.getPlayer().getMoves() + " PONTOS!");
			System.out.println("|         SCORES         |");
			try {
				Scanner fileScanner = new Scanner(new File("score/Score"+ SokobanGame.getInstance().level.getChar() +".txt"));
				while(fileScanner.hasNextLine()) {
					String line = fileScanner.nextLine();
					System.out.println(line);
				}
					
					fileScanner.close();
			}
			catch (FileNotFoundException e) {
			System.err.println("Erro na abertura do ficheiro");
			} 
			System.out.println("|                        |");
			clearImages();
			level.getPlayer().setEnergy(100);
			level.getPlayer().setMoves(0);
			nextLevel();
			}
			}
		if(level.getPlayer().getEnergy() == 0) {
			System.out.println("GAME OVER, FICOU SEM ENERGIA!!");
			gameOver();
		}	
		ImageMatrixGUI.getInstance().update();
		}
    }
	
	public void removeObject(AbstractObjects a) {
		ImageMatrixGUI.getInstance().removeImage(a);
	}
	private void gameOver() {
		System.exit(0);
	}
	private void clearImages() {
		ImageMatrixGUI.getInstance().clearImages();
	}
	public List<AbstractObjects> getList(){
		return ListaAbstractObjects;
	}
}