package pt.iscte.dcti.poo.sokoban.starter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;

public abstract class AbstractObjects implements ImageTile {
	private String nomeImagem;
	private Point2D Position;	
	private boolean goOnTop;  
	private int layer;
	public boolean blockMoves;
	
	public AbstractObjects(Point2D Position){
		this.Position=Position;
}

	public AbstractObjects(String nomeImagem, Point2D position, int layer) {
		super();
		this.nomeImagem = nomeImagem;
		Position = position;
		this.layer = layer;
	}
	
	public String getName() {
		return nomeImagem;
	}
	public void setName(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}
	public Point2D getPosition() {
		return Position;
	}
	public void setPosition(Point2D position) {
		Position = position;
	}
	public int getLayer() {
		return layer;
	}
	public void setLayer(int layer) {
		this.layer = layer;
	}
	public void setGoOnTop(boolean goOnTop) {
		this.goOnTop = goOnTop;
	}

	public boolean isGoOnTop() {
		return goOnTop;
	}  
	public void blockMoves(boolean blockMoves) {
		this.blockMoves = blockMoves;
	}
	public boolean getblockMoves() {
		return blockMoves;
	}
	
	public boolean checkIfcanGO(Point2D ponto) {
	    	for(AbstractObjects i: SokobanGame.getInstance().getList()) {
	    		if(i.getPosition().equals(ponto))
	    			if(i.goOnTop==false)
	    				return false;
	    	}
	    	return true;
	    } 
}
