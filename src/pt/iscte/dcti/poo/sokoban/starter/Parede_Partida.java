package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;

public class Parede_Partida extends AbstractObjects implements InteractiveObjects{

	public Parede_Partida(Point2D position) {
		super("Parede_Partida", position, 1);
		
	}

	@Override
	public void interact(AbstractObjects a, Direction d) {
		if(SokobanGame.getInstance().level.getHaveMartelo() == true && (a instanceof Empilhadora)) {
			ImageMatrixGUI.getInstance().removeImage(this);
		}
	}

}
