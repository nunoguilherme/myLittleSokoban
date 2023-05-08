package pt.iscte.dcti.poo.sokoban.starter;
import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;

public class Bateria extends AbstractObjects implements InteractiveObjects{  
	int lifes = 1;
	Bateria(Point2D Position) {
		 super("Bateria",Position,1);
		 setGoOnTop(true);
	}
	@Override
	public void interact(AbstractObjects a, Direction d) {
		if( a instanceof Empilhadora) {
		if( this.lifes == 1) {
			SokobanGame.getInstance().level.getPlayer().setEnergy(100);
			lifes--;
			ImageMatrixGUI.getInstance().removeImage(this);
			System.out.println("A SUA ENERGIA FOI RENOVADA!");
		}
		}
	}
	
}
		




