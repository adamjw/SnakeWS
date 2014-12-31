package snake.game.controller;

import java.util.List;

import simpleio.common.Colour;
import simpleio.common.Point;
import simpleio.common.Position;
import snake.game.state.Board;
import snake.game.state.Fruit;

public class FruitController {

	public void moveFruit(List<Position> occupiedSpaces, Board board, Fruit fruit) {
		/**
		 * TODO #10 The purpose of this method is to move the fruit to another
		 * position. This is used at the start of the game, and each time the
		 * fruit is eaten.
		 * 
		 * The fruit should not be moved to an occupied space. Use of the Random
		 * object may help.
		 */
		
		
		Position newPosition = new Position((int) (Math.random() * board.getNumberOfColumns()),
				(int) (Math.random() * board.getNumberOfRows()));
		
		while (occupiedSpaces.contains(newPosition)) {
			newPosition = new Position(
					(int) (Math.random() * board.getNumberOfColumns()), (int) (Math.random() * board.getNumberOfRows()));
		}
		fruit.setPosition(newPosition);
	}

	public void recolourFruit(Fruit fruit) {
		/**
		 * TODO #11 In this method, the fruit will be recoloured. Use the Colour
		 * object and the Random object (if it pleases you) to change the given
		 * fruit's colour.
		 */
		fruit.setColour(Colour.getRandomColour(50, 5, 0, 0));

	}

}
