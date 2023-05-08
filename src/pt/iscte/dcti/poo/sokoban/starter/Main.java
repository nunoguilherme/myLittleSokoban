package pt.iscte.dcti.poo.sokoban.starter;

import java.awt.event.KeyEvent;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
public class Main {

	
	public static void main(String[] args) {
		ImageMatrixGUI.setSize(SokobanGame.WIDTH, SokobanGame.HEIGHT);
		SokobanGame s = SokobanGame.getInstance(); //SOKOBANGAME = SOKOBANGAME.GETINSTANCE()
		ImageMatrixGUI.getInstance().setName("SOKOBAN GAME");
		ImageMatrixGUI.getInstance().registerObserver(s);
		ImageMatrixGUI.getInstance().go();
	}
}