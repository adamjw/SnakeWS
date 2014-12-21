package snake.game.state;

import simpleio.common.Colour;
import simpleio.common.Position;

public class Fruit {

	private Colour colour;
	private Position position;
	
	public Fruit(){
		this.colour = Colour.RED;
		this.position = new Position(0, 0);
	}
	
	public Colour getColour(){
		return colour;
	}
	
	public void setColour(Colour colour){
		this.colour = colour;
	}
	
	public Position getPosition(){
		return position;
	}
	
	public void setPosition(Position position){
		this.position = position;
	}
	
}
