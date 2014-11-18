package snake.game.controller;

import snake.game.state.Board;
import snake.game.state.Fruit;
import snake.game.state.Snake;

public class CollisionController {

	/**
	 * Checks if the snake is colliding with the fruit.
	 * 
	 * @param snake
	 * @param fruit
	 * @return true if the snake is colliding with the fruit, false otherwise
	 */
	public boolean isCollidingWithFruit(Snake snake, Fruit fruit){

		return false;
	}
	

	/**
	 * Checks if the space that the snake is about to move to is valid.
	 * 
	 * @param board
	 * @param snake
	 * @return true if the snake is allowed to move there, false otherwise (game over).
	 */
	public boolean isMoveValid(Board board, Snake snake) {
	
		return true;
	}
	
}
