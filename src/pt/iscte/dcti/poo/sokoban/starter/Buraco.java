package pt.iscte.dcti.poo.sokoban.starter;
import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;
public class Buraco extends AbstractObjects implements InteractiveObjects{   
	Buraco(Point2D Position) {
		 super("Buraco",Position,0);
		 setGoOnTop(true);
	 }
	@Override
	public void interact(AbstractObjects a, Direction d) {
			
		   if(a instanceof SmallStone || a instanceof Caixote) {
			   a.setGoOnTop(true);
			   SokobanGame.getInstance().removeObject(a); 
			    }
		   if(a instanceof BigStone) {
			   a.blockMoves(true); 
		  }
		   if( a instanceof Empilhadora) {
			System.out.println("GAME OVER, CAIU AO BURACO!!");
			System.exit(0);
		} 
		   ImageMatrixGUI.getInstance().update();
		}
	boolean onBuraco(Point2D position) {
		return super.getPosition().equals(position);
	}
	}
	