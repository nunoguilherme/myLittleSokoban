package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;

public class PortalVerde extends AbstractObjects implements InteractiveObjects{
       PortalVerde(Point2D Position) {
		super("Portal_Verde", Position, 1);
		setGoOnTop(true);
	}

	@Override
	public void interact(AbstractObjects a, Direction d) {
		for(AbstractObjects i: SokobanGame.getInstance().getList()) {
			if(i instanceof PortalAzul) {
				
				
				a.setPosition(i.getPosition());
				
				
			}
		}	
		
	}
}