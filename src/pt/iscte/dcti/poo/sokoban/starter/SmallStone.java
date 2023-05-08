package pt.iscte.dcti.poo.sokoban.starter;
import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;
public class SmallStone extends AbstractObjects implements MovableObjects{
	SmallStone(Point2D Position) {
		 super("SmallStone",Position,2);
		 setGoOnTop(false);
	 }
	@Override
		public void move(Direction a, AbstractObjects i2) {
			Point2D newPosition = super.getPosition().plus(a.asVector());
			for(AbstractObjects i : SokobanGame.getInstance().getList()) {
				if(i.getPosition().equals(newPosition)) {
					 if(i instanceof InteractiveObjects) {
						 ((InteractiveObjects) i).interact(this, a);
					 }
					 
						 super.setPosition(newPosition); 
							
			}
	}
		}
	}