package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;

public class Gelo extends AbstractObjects implements InteractiveObjects{

	public Gelo(Point2D position) {
		super("Gelo", position, 1);
		setGoOnTop(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void interact(AbstractObjects a, Direction a2) {
	
		if ( a instanceof MovableObjects || a instanceof Empilhadora) {
			Point2D newPosition = getPosition().plus(a2.asVector());
			for(AbstractObjects i : SokobanGame.getInstance().getList()) {
				if( i.getPosition().equals(newPosition)){
					if( i instanceof Gelo) {
					Point2D newPosition2 = newPosition.plus(a2.asVector());
					if(a.checkIfcanGO(newPosition2)) 
						a.setPosition(newPosition2); 
					}
				else {
					if(a.checkIfcanGO(newPosition)) 
						a.setPosition(newPosition); 
					else 
						a.setPosition(getPosition());
					
				}
					}
			}
		}
		
}
}

	




