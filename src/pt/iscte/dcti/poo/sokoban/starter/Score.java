package pt.iscte.dcti.poo.sokoban.starter;

public class Score{
     private String name;
     private int score;
     
	public Score(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return getName() + " " + getScore() + "\n";
	}
	public int getScore() {
		return score;
	}
}
