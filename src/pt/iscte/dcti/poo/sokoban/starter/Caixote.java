package pt.iscte.dcti.poo.sokoban.starter;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;
public class Caixote extends AbstractObjects implements MovableObjects{
	Caixote(Point2D Position) {
		 super("Caixote",Position,2);
		 setGoOnTop(false); 
		 blockMoves(false);
	}
	     
	public void move(Direction a, AbstractObjects i2) {
		Point2D newPosition = super.getPosition().plus(a.asVector());
		for(AbstractObjects i : SokobanGame.getInstance().getList()) {
			if(i.getPosition().equals(newPosition)) {
				 if(i instanceof InteractiveObjects) {
					 ((InteractiveObjects) i).interact(this, a);
					 }
				 if( !(i instanceof Gelo))
				 super.setPosition(newPosition);
				 }
				 
					
	}
}
	}

