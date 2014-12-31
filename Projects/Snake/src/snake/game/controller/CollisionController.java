package snake.game.controller;

import java.util.List;

import simpleio.common.Position;
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
		return fruit.getPosition().equals(snake.getHeadPosition());
	}
	

	/**
	 * Checks if the space that the snake is about to move to is valid.
	 * 
	 * @param board
	 * @param snake
	 * @return true if the snake is allowed to move there, false otherwise (game over).
	 */
	public boolean isMoveValid(Board board, Snake snake) {
		
		int boardSize = board.getNumberOfColumns() - 1;
		
		Position headPos = snake.getHeadPosition();
		int headPosX = headPos.getX();
		int headPosY = headPos.getY();
		boolean withinX = 0 <= headPosX && headPosX <= boardSize;
		boolean withinY = 0 <= headPosY && headPosY <= boardSize;
		boolean withinBoard = withinX && withinY;
		
		List<Position> snakeSegments = snake.getSegments();
		List<Position> body = snakeSegments.subList(1, snakeSegments.size() - 1);
		boolean bodyContainsHead = body.contains(headPos);
	
		return withinBoard && !bodyContainsHead;
	}
	
}
