package snake.game.controller;

import snake.game.state.GameInfo;

public class GameInfoController {

	public void addScore(int scoreToAdd, GameInfo gameInfo){
		gameInfo.setScore(gameInfo.getScore() + scoreToAdd);
	}

	public void incrementFrame(GameInfo gameInfo){
		gameInfo.setFrame(gameInfo.getFrame() + 1);
	}
	
}
