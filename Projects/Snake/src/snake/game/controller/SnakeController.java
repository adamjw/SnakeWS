package snake.game.controller;

import org.lwjgl.input.Keyboard;

import simpleio.common.Direction;
import simpleio.keyboard.BufferedKeyboard;
import snake.game.state.Snake;

public class SnakeController {

	public void updateMovingDirection(BufferedKeyboard keyboard, Snake snake) {
		/**
		 * TODO #8
		 * 
		 * The purpose of this method is to update which direction the snake is moving.
		 * 
		 * The BufferedKeyboard object contains a list of all keys that were pressed since the last time the snake moved, in order from oldest to newest.
		 * The utility method below, getDirectionForKey, can be used to turn a key press into a Direction.
		 * 		-note that if the key press did not correspond to one of the arrow keys, null will be returned.
		 * 		-null is kind of like a non-object; it is an uninitialized object. 
		 * 		-as such, it will cause errors if you try to access its data or use any of its functionality.
		 * 
		 * Then, using the recorded key presses, figure out which one to use to update the Snake's direction.
		 */
		
	}
	
	public void move(Snake snake){
		/**
		 * TODO #9
		 * 
		 * The purpose of this method is to move the snake.
		 * Using the snake's facing direction, update its segments such that it has moved one space forward in the appropriate direction.
		 * 
		 */
	}
	
	private Direction getDirectionForKey(int keyEvent){
		switch(keyEvent){
		case Keyboard.KEY_LEFT	: return Direction.left;
		case Keyboard.KEY_RIGHT	: return Direction.right;
		case Keyboard.KEY_UP	: return Direction.up;
		case Keyboard.KEY_DOWN	: return Direction.down;
		default					: return null;
		}		
	}
}
