package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;

public class PortalAzul extends AbstractObjects implements InteractiveObjects{
       PortalAzul(Point2D Position) {
		super("Portal_Azul", Position, 1);
		setGoOnTop(true);
	}

	@Override
	public void interact(AbstractObjects a, Direction d) {
		for(AbstractObjects i: SokobanGame.getInstance().getList()) {
			if(i instanceof PortalVerde) {
				
					
					a.setPosition(i.getPosition());
			
	
	}
}
	}
}
