package fr.quentin.puissance4;

import java.util.Random;
import java.util.Scanner;

public class Game {
	private Board board;
	private Player player1;
	private Player player2;
	private Player currentPlayer;
	private Player winner;
	
	public Game(){
		
	}
	
	public void start(String p1Name, String p1Color, boolean p1isAi, String p2Name, String p2Color, boolean p2isAi) {
		this.board = new Board(6, 7);
		this.player1 = new Player(p1Name, p1Color, p1isAi);
		this.player2 = new Player(p2Name, p2Color, p2isAi);
		
		System.out.println("player1 = " + player1);
		System.out.println("player2 = " + player2);
		System.out.println("currentPlayer = " + currentPlayer);
		
		Random rand = new Random();
		currentPlayer = rand.nextBoolean() ? player1 : player2;
	}
	
	public void playMove(Player player, int col) throws InvalidMoveException {
	    this.winner = board.placeToken(col, player);
	    currentPlayer.setNbPlay(currentPlayer.getNbPlay()+1);
	    switchPlayer();
	}	
		
	public void switchPlayer() {
		if(currentPlayer == player1) {
			currentPlayer = player2;
		}else {
			currentPlayer = player1;
		}
	}
	
	public boolean isOver() {
		if(this.winner != null) {
			return true;
		}
		return false;
	}
	
	public void reset() {
		board.reset();
	    Random rand = new Random();
	    currentPlayer = rand.nextBoolean() ? player1 : player2;
	}
	
	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	/*
	public static void main(String[] args) {
		//pick your game mode, either human vs human or human vs ai
		// if ai select difficulty mode
		Game game = new Game();
		game.start(6, 7, "Alice", "red", false, "Bob", "yellow", false);
		while(!game.isOver()) {
		    game.playMove(game.getCurrentPlayer());
		    game.switchPlayer();
		}
		System.out.println("The winner is : "+game.winner.getName());
		System.out.println("With "+game.winner.getNbPlay()+" plays");
	}
	*/

}
