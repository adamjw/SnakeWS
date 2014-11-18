package snake.game.state;


public class Board {
	
	private int numRows;
	private int numColumns;
	
	public Board(int numColumns, int numRows) {
		this.numColumns = numColumns;
		this.numRows = numRows;
	}

	public int getNumberOfRows(){
		return numRows;
	}
	
	public int getNumberOfColumns(){
		return numColumns;
	}
}
