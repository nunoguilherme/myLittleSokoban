package pt.iscte.dcti.poo.sokoban.starter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;

public class Alvo extends AbstractObjects implements InteractiveObjects{
	Alvo(Point2D Position) {
		 super("Alvo",Position,0);
		 setGoOnTop(true);
	 }
	@Override
	public void interact(AbstractObjects a, Direction a2) {
	}

}