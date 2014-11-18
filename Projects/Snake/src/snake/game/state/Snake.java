package snake.game.state;

import java.util.ArrayList;
import java.util.List;

import simpleio.common.Direction;
import simpleio.common.Position;

public class Snake {

	private List<Position> segments;
	private Direction movingDirection;

	public Snake(Direction startingDirection, Position startingPosition, int startingLength){
		movingDirection = startingDirection;
		segments = new ArrayList<Position>();
		segments.add(startingPosition);

		int dx = 0;
		int dy = 0;

		switch(startingDirection){
		case up: 	dy = 1; 	break;
		case down: 	dy = -1; 	break;
		case left:	dx = 1; 	break;
		case right: dx = -1; 	break;
		}
		
		for(int i = 1; i < startingLength; i++){
			segments.add(new Position(startingPosition.getX() + dx * i, startingPosition.getY() + dy * i));
		}
	}

	public Position getHeadPosition(){
		return segments.get(0);
	}
	
	public Position getSegment(int index){
		return segments.get(index);
	}
	
	public List<Position> getSegments(){
		return segments;
	}

	public void addSegment(){

	}

	public Direction getMovingDirection(){
		return movingDirection;
	}

	public boolean setMovingDirection(Direction direction){
		return true;
	}

	
}
