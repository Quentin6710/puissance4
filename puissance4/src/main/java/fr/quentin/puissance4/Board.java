package fr.quentin.puissance4;



public class Board {
	
	//attributs
	final int NB_ROWS;
	final int NB_COLS;
	private Player grid[][];
	
	// Constructeur
	public Board(int nbRows, int nbCols){
		this.NB_ROWS = nbRows;
		this.NB_COLS = nbCols;
		
		//init grid
		this.grid = new Player[NB_ROWS][NB_COLS];
		
		for(int i=0; i< this.NB_ROWS; i++) {
			for(int j=0; j< this.NB_COLS; j++) {
				grid[i][j] = null;
				
			}	
		}
	}
	
	
	//methodes
	public Player placeToken(int column, Player player) throws InvalidMoveException{
		if (column < 0 || column >= NB_COLS) {
		    throw new InvalidMoveException("This column doesn't exist");
		}
		
		//verify if column is full
		if (isColumnFull(column)) {
			throw new InvalidMoveException("The column is full");
		}
		int row = getRowToPlace(column);
	    if (row == -1) {
	        throw new InvalidMoveException("Impossible to place the token");
	    }
		
		//puts the token in the column, 
		this.grid[row][column] = player;
		return hasWon(player, row, column);
		
	}
		
	public int getRowToPlace(int column) {
		int i=this.NB_ROWS-1;
		//from bottom to top
		while(i>=0) {
			if(this.grid[i][column] == null) {
				return i;		
			}
			i--;
		}
		return -1;
	}
	
	public boolean isColumnFull(int column) {
		int i=this.NB_ROWS-1;
		while(i>=0) {
			if(this.grid[i][column] == null) {
				return false;		
			}
			i--;
		}
		return true;
	}
	
	
	public Player hasWon(Player player, int row, int col) {
		int count;
		// horizontal
		count = 1;
		int i = col+1;
		while( i < NB_COLS && grid[row][i] == player ) {
			count++;
			i++;
		}
		int j = col-1;
		while(j >= 0 && grid[row][j] == player) {
			count++;
			j--;
		}
		if(count >= 4) return player;
		
		count = 1;
		// vertical
		
		i = row +1;
		while( i < NB_ROWS && grid[i][col] == player) {
			count++;
			i++;
		}
		j = row-1;
		while( j >= 0 && grid[j][col] == player ) {
			count++;
			j--;
		}
		if(count >= 4) return player;

		
		
		count = 1;
		// diagonal up right
		i = row-1;
		j = col+1;
		while(i > 0 && j < NB_COLS - 1 && grid[i][j] == player) {
			count++;
			i--;
			j++;
		}
		
		i = row+1;
		j = col-1;
		while(i < NB_ROWS - 1 && j > 0  && grid[i][j] == player) {
			count++;
			i++;
			j--;
		}
		if(count >= 4) return player;
		
		count = 1;
		// diagonal down right
		i = row+1;
		j = col+1;
		while(i < NB_ROWS && j < NB_COLS && grid[i][j] == player) {
			count++;
			i++;
			j++;
		}
		
		i = row-1;
		j = col-1;
		while(i >= 0 && j >= 0 && grid[i][j] == player) {
			count++;
			i--;
			j--;
		}
		if(count >= 4) return player;
		
		
		return null;
	}
	
	public boolean isGridFull() {
		for(int i=0; i< this.NB_ROWS; i++) {
			for(int j=0; j< this.NB_COLS; j++) {
				if(grid[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void reset() {
		for(int i=0; i< this.NB_ROWS; i++) {
			for(int j=0; j< this.NB_COLS; j++) {
				grid[i][j] = null;
			}
		}
	}
	
	
}
