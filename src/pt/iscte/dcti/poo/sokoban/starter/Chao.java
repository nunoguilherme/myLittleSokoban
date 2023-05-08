package pt.iscte.dcti.poo.sokoban.starter;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;
public class Chao extends AbstractObjects{
    Chao(Point2D position) {
	 super("Chao",position,0);
	 setGoOnTop(true);
 	}
}