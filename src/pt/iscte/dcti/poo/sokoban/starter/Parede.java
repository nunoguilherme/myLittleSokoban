package pt.iscte.dcti.poo.sokoban.starter;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;
public class Parede extends AbstractObjects implements InteractiveObjects{
	Parede(Point2D Position) {
		 super("Parede",Position,1);
		 setGoOnTop(false);
	 }
	@Override
	public void interact(AbstractObjects a, Direction d) {
		// TODO Auto-generated method stub
		
	}
	}