package snake.game.drawer;

import simpleio.common.Colour;
import simpleio.common.Direction;
import simpleio.common.Point;
import simpleio.common.Position;
import simpleio.display.Window;
import snake.game.state.Board;

public class BoardDrawer {
	private Window window;
	private Point topLeft;
	private int cellSize;

	public BoardDrawer(Window window, Point topLeft, int cellSize) {
		this.window = window;
		this.topLeft = topLeft;
		this.cellSize = cellSize;
	}

	public void drawBoard(Board board) {
		for(int i=0; i<board.getNumberOfColumns(); i++) {
			window.drawLine(Colour.WHITE, new Point(i * cellSize + topLeft.getX(),topLeft.getY()), new Point(i * cellSize + topLeft.getX(),window.getHeight()));
			}
		for(int i=0; i<board.getNumberOfRows(); i++) {
			window.drawLine(Colour.WHITE,  new Point(topLeft.getX(),i * cellSize + topLeft.getY()), new Point(window.getWidth(), i * cellSize + topLeft.getY()));
		}
		
			
			

	}

	public void drawSquare(Colour colour, Position p) {

	}
	

	public void drawTriangle(Colour colour, Direction direction, Position p) {

	}
}
