package snake.game.drawer;

import simpleio.common.Colour;
import snake.game.state.Snake;

public class SnakeDrawer {

	private BoardDrawer boardDrawer;

	public SnakeDrawer(BoardDrawer boardDrawer) {
		this.boardDrawer = boardDrawer;
	}

	public void drawSnake(Snake snake) {
		boardDrawer.drawTriangle(Colour.GREEN, snake.getMovingDirection(), snake.getHeadPosition());
		for (int i = 1; i < snake.getSegments().size(); i++)
			boardDrawer.drawSquare(Colour.GREEN, snake.getSegment(i));

	}
}
