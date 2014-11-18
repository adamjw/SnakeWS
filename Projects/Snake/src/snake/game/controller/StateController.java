package snake.game.controller;

import org.lwjgl.input.Keyboard;

import simpleio.keyboard.BufferedKeyboard;
import snake.game.state.GameInfo;
import snake.game.state.GameInfo.GameState;

public class StateController {

	public void changeState(BufferedKeyboard keyboard, GameInfo info) {
		GameState state = info.getState();
		
		if (keyboard.getKeyEvents().contains(Keyboard.KEY_SPACE)) {
			if (state.equals(GameState.DEAD)) {
				info.setState(GameState.RESTARTING);
			}

			if (state.equals(GameState.NOT_STARTED)) {
				info.setState(GameState.PLAYING);
			}
		}
	}
	
	public void setState(GameState state, GameInfo info){
		info.setState(state);
	}
	
}
