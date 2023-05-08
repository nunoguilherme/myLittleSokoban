package pt.iscte.dcti.poo.sokoban.starter;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;

public class Empilhadora extends AbstractObjects{
	private int moves = 0;
	private int energy = 100;
	public Empilhadora(Point2D Position){
		 super("Empilhadora_U",Position,3);
		 setGoOnTop(true);
	 }

    public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}
	
	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public void move(Direction a, int lastkeyPressed) {
		switch(lastkeyPressed) {
		case KeyEvent.VK_UP: this.setName("Empilhadora_U"); break;
		case KeyEvent.VK_RIGHT: this.setName("Empilhadora_R"); break;
		case KeyEvent.VK_LEFT: this.setName("Empilhadora_L"); break;
		case KeyEvent.VK_DOWN: this.setName("Empilhadora_D"); break;
		}
		
		Point2D newPosition = super.getPosition().plus(a.asVector()); 
		for(AbstractObjects i : SokobanGame.getInstance().getList()) {
			if( i.getPosition().equals(newPosition)) {
				 if( i instanceof MovableObjects) {
					 Point2D futurePosition = i.getPosition().plus(a.asVector());
	        		   if(i.checkIfcanGO(futurePosition) && i.blockMoves == false) 		
	        			((MovableObjects) i).move(a,this);
				 }
			}
		}
		if(checkIfcanGO(newPosition)==false) {
			return;
		}
			super.setPosition(newPosition);
			setEnergy(getEnergy()-1);                                            
		 	setMoves(getMoves()+1); 
		 	 	
		for(AbstractObjects i : SokobanGame.getInstance().getList()) {
			if(i.getPosition().equals(newPosition)) {
				 if(i instanceof InteractiveObjects) {
        		   ((InteractiveObjects) i).interact(this,a);

        	   }
			}
		}   
			ImageMatrixGUI.getInstance().update();
			ImageMatrixGUI.getInstance().setStatusMessage("Level:" + SokobanGame.getInstance().level.getNumbLevel()  + " Moves: " + getMoves() + " Energy: " + getEnergy() );

}
}