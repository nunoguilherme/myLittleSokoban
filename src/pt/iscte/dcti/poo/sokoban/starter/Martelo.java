package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;

public class Martelo extends AbstractObjects implements InteractiveObjects{
	int lifes = 1;
	public Martelo(Point2D position) {
		super("Martelo", position, 1);
		setGoOnTop(true);
		
	}

	@Override
	public void interact(AbstractObjects a, Direction d) {
		if( a instanceof Empilhadora) {
		for(AbstractObjects i : SokobanGame.getInstance().getList()) {
			if( i instanceof Parede_Partida) {
				i.setGoOnTop(true);
			}
		} 
		if( this.lifes == 1) {
		SokobanGame.getInstance().level.setHaveMartelo(true);
		ImageMatrixGUI.getInstance().removeImage(this);
		System.out.println("APANHOU O MARTELO!");
		lifes--;
		}
	}
	}
}
