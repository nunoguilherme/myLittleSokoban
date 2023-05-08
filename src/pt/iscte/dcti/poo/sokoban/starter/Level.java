package pt.iscte.dcti.poo.sokoban.starter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pt.iul.ista.poo.utils.Point2D;

public class Level {
 	List<Level> listNiveis= new ArrayList<Level>();
 	private Empilhadora player;
 	private boolean haveMartelo;
 	private int Nalvos = 0;
 	private int numbLevel = 0;
	Level(){
	}

	List<AbstractObjects> getAlvo(){
		List<AbstractObjects> alvos= new ArrayList<AbstractObjects>();
		for(AbstractObjects i: SokobanGame.getInstance().getList()) {
			if(i instanceof Alvo) {
				alvos.add(i);
			}
		}
		return alvos;	
	}
	
	public int getNumbLevel() {
		return numbLevel;
	}

	public void setNumbLevel(int numbLevel) {
		this.numbLevel = numbLevel;
	}

	public List<AbstractObjects> listaNiveis(){
		List<AbstractObjects>  lista = new ArrayList<AbstractObjects>();
		try {
			Scanner fileScanner = new Scanner(getLevel());
		int lineNum = 0;
		String line;
		while(fileScanner.hasNextLine()) {
			 line = fileScanner.nextLine();
		for(int i=0; i< SokobanGame.WIDTH; i++) {
				if( line.charAt(i) == 'b' ) {
				lista.add(new Bateria(new Point2D(i,lineNum)));	
		}
				if( line.charAt(i) == 'X' ) {
					lista.add(new Alvo(new Point2D(i,lineNum)));	
					Nalvos++;
			}
				if( line.charAt(i) == 'O' ) {
					lista.add(new Buraco(new Point2D(i,lineNum)));	
			}
				if( line.charAt(i) == 'C' ) {
					lista.add(new Caixote(new Point2D(i,lineNum)));	
			}
				if( line.charAt(i) == ' ' || line.charAt(i) == 'E' || line.charAt(i) == 'C' 
						||line.charAt(i) == '*' || line.charAt(i) == '?' || line.charAt(i) == 'm' || line.charAt(i)=='b' || line.charAt(i)=='%'){
					lista.add(new Chao(new Point2D(i,lineNum)));	
			}
				if( line.charAt(i) == 'E' ) {	
				player = new Empilhadora(new Point2D(i,lineNum));
					
			}
				if( line.charAt(i) == '#' ) {
					lista.add(new Parede(new Point2D(i,lineNum)));	
				}
				if( line.charAt(i) == '?' ) {
					lista.add(new SmallStone(new Point2D(i,lineNum)));	
				}
				if( line.charAt(i) == '*' ) {
					lista.add(new BigStone(new Point2D(i,lineNum)));	
				}
				if( line.charAt(i) == 't' ) {
					lista.add(new PortalAzul(new Point2D(i,lineNum)));	
				}
				if( line.charAt(i) == 'T' ) {
					lista.add(new PortalVerde(new Point2D(i,lineNum)));	
				}
				if( line.charAt(i) == 'g' ) {
					lista.add(new Gelo(new Point2D(i,lineNum)));	
				}
				if( line.charAt(i) == 'm' ) {
					lista.add(new Martelo(new Point2D(i,lineNum)));	
				}
				if( line.charAt(i) == '%' ) {
					lista.add(new Parede_Partida(new Point2D(i,lineNum)));	
				}
			}
		lineNum++;
		} 
			fileScanner.close();
			}
			catch (FileNotFoundException e) {
			System.err.println("Erro na abertura do ficheiro");
			}
		return lista;
	
}

	public void setPlayer(Empilhadora player) {
		this.player = player;
	}
	public Empilhadora getPlayer() {
		return this.player;
	}
    
	public  int  getChar() {
		return  this.numbLevel;
	}
    public  File getLevel() {
    	File a = new File("levels/level" + getChar() + ".txt");
		return a;
	}
    public boolean getHaveMartelo() {
	return haveMartelo;
    }

  public void setHaveMartelo(boolean haveMartelo) {
	this.haveMartelo = haveMartelo;
  }

  public int getNalvos() {
	return Nalvos;
  }


  


}

