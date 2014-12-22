package snake.game.controller;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import simpleio.common.Direction;
import simpleio.common.Position;
import simpleio.keyboard.BufferedKeyboard;
import snake.game.state.Snake;

public class SnakeController {

	public void updateMovingDirection(BufferedKeyboard keyboard, Snake snake) {
		if (keyboard.getKeyEvents().size() != 0) {

			Integer lastKeyEvent = keyboard.getKeyEvents().get(keyboard.getKeyEvents().size() - 1);

			if (isValidDirection(lastKeyEvent, snake)) {
				snake.setMovingDirection(getDirectionForKey(lastKeyEvent));
			}
		}

	}

	private boolean isValidDirection(int keyEvent, Snake snake) {
		return snake.getMovingDirection() != getDirectionForKey(keyEvent);
	}

	public void move(Snake snake) {
		Position headPosition = snake.getHeadPosition();

		List<Position> newSegments = new ArrayList<Position>();
		newSegments.add(headPosition.translate(snake.getMovingDirection(), 1));

		for (int i = 1; i < snake.getSegments().size(); i++) {
			newSegments.add(snake.getSegment(i));
			
		snake.setSegments(newSegments);
		}

	}

	private Direction getDirectionForKey(int keyEvent) {
		switch (keyEvent) {
		case Keyboard.KEY_LEFT:
			return Direction.left;
		case Keyboard.KEY_RIGHT:
			return Direction.right;
		case Keyboard.KEY_UP:
			return Direction.up;
		case Keyboard.KEY_DOWN:
			return Direction.down;
		default:
			return null;
		}
	}
}
