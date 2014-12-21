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
		for (int i = 0; i < board.getNumberOfColumns(); i++) {
			window.drawLine(Colour.WHITE, topLeft.addXY(i * cellSize, 0),
					topLeft.addXY(i * cellSize, board.getNumberOfColumns() * cellSize));
		}
		for (int i = 0; i < board.getNumberOfRows(); i++) {
			window.drawLine(Colour.WHITE, topLeft.addXY(0, i * cellSize),
					topLeft.addXY(board.getNumberOfRows() * cellSize, i * cellSize));

		}

	}

	public void drawSquare(Colour colour, Position p) {
		window.drawRectangle(colour, topLeft.addXY(p.getX() * cellSize, p.getY() * cellSize),
				topLeft.addXY((p.getX() + 1) * cellSize, (p.getY() + 1) * cellSize));

	}

	public void drawTriangle(Colour colour, Direction direction, Position p) {
		switch (direction) {
		case up:
			window.drawTriangle(colour, topLeft.addXY(p.getX() * cellSize + cellSize / 2, p.getY() * cellSize),
					topLeft.addXY(p.getX() * cellSize, (p.getY() + 1) * cellSize),
					topLeft.addXY((p.getX() + 1) * cellSize, (p.getY() + 1) * cellSize));
			break;
		case down:
			window.drawTriangle(colour, topLeft.addXY(p.getX() * cellSize, p.getY() * cellSize),
					topLeft.addXY((p.getX() + 1) * cellSize, p.getY() * cellSize),
					topLeft.addXY(p.getX() * cellSize + cellSize / 2, (p.getY() + 1) * cellSize));
			break;
		case left:
			window.drawTriangle(colour, topLeft.addXY(p.getX() * cellSize, p.getY() * cellSize + cellSize / 2),
					topLeft.addXY((p.getX() + 1) * cellSize, p.getY() * cellSize),
					topLeft.addXY((p.getX() + 1) * cellSize, (p.getY() + 1) * cellSize));
			break;
		case right:
			window.drawTriangle(colour, topLeft.addXY(p.getX() * cellSize, p.getY() * cellSize),
					topLeft.addXY(p.getX() * cellSize, (p.getY() + 1) * cellSize),
					topLeft.addXY((p.getX() + 1) * cellSize, p.getY() * cellSize + cellSize / 2));
			break;
		default:
			break;

		}

	}
}
