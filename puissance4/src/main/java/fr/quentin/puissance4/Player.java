package fr.quentin.puissance4;


public class Player {
	private String name;
	private String color;
	private boolean isAi;
	private int nbPlay = 0;
	
	public Player(String name, String color, boolean isAi){
		this.name = name;
		setColor(color);
		this.isAi = isAi;

	}
		
	public void setName(String name) {
		this.name = name;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setIsAi(boolean isAi) {
		this.isAi = isAi;
	}
	
	public void setNbPlay(int nbPlay) {
		this.nbPlay = nbPlay;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public boolean IsAi() {
		return this.isAi;
	}
	
	public int getNbPlay() {
		return this.nbPlay;
	}
}
