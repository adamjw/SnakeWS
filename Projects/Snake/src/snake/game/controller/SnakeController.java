package snake.game.controller;

import org.lwjgl.input.Keyboard;

import simpleio.common.Direction;
import simpleio.keyboard.BufferedKeyboard;
import snake.game.state.Snake;

public class SnakeController {

	public void updateMovingDirection(BufferedKeyboard keyboard, Snake snake) {

	}
	
	public void move(Snake snake){		

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
