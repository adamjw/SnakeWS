package snake.game.controller;

import simpleio.common.Position;
import snake.game.state.Board;
import snake.game.state.Fruit;
import snake.game.state.Snake;

public class CollisionController {

	public boolean isCollidingWithFruit(Snake snake, Fruit fruit){
		/**
		 * TODO #12
		 * This method is in a logic controller, and acts upon a Snake object and a Fruit object to see if they are colliding.
		 * From the method definition you can see the following:
		 * 	-this method is public, meaning any other object can use this method
		 * 	-this method returns a boolean value - that is, the output of this method is "true" or "false"
		 * 		-in this case, judging from the method's name, "true" would mean there is a collision, and "false" would mean otherwise
		 * 		-it is important to make methods with clear names
		 * 	-The method takes two parameters - a Snake object and a Fruit object
		 * 		-these objects are stateful. 
		 * 
		 * Use the Snake and Fruit objects' functions to look at their state and see if they are in a state of collision.
		 */
		
		return false;
	}
	
	public boolean isMoveValid(Board board, Snake snake) {
		/**
		 * TODO #13
		 * This method is used to check if the Snake's next move would be a valid one.
		 * "Invalid" means that the snake would die.
		 * Use the skills you learned from the previous task to complete this one.
		 */
		
		return true;
	}
	
}
