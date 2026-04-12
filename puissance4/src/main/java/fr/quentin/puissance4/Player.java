package fr.quentin.puissance4;

import java.awt.Color;
import java.util.Map;

public class Player {
	private String name;
	private Color color;
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
	    Map<String, Color> colors = Map.of(
	            "red",   Color.RED,
	            "yellow",Color.YELLOW
	    );
		if(colors.get(color) != null) {
			this.color = colors.get(color.toLowerCase());
		}
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
		return this.color.toString();
	}
	
	public boolean IsAi() {
		return this.isAi;
	}
	
	public int getNbPlay() {
		return this.nbPlay;
	}
}
