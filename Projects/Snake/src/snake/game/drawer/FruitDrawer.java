package snake.game.drawer;

import simpleio.common.Colour;
import snake.game.state.Fruit;

public class FruitDrawer {

	private BoardDrawer boardDrawer;

	public FruitDrawer(BoardDrawer boardDrawer) {
		this.boardDrawer = boardDrawer;
	}

	public void drawFruit(Fruit fruit) {
		boardDrawer.drawSquare(Colour.RED, fruit.getPosition());

	}

}
