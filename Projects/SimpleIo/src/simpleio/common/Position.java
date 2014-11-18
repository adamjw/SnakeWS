package simpleio.common;

public class Position {
	private final int x, y;
	
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Position addY(int y){
		return new Position(x, this.y + y);
	}
	
	public Position addX(int x){
		return new Position(this.x + x, y);
	}
	
	public Position addXY(int x, int y){
		return new Position(this.x + x, this.y + y);
	}
	
	/**
	 * Direction from this point to the other point.
	 * @param other
	 * @return
	 */
	public Direction getRelativeDirection(Position other){
		Direction facingDirection;
		
		int dx = this.getX() - other.getX();
		int dy = this.getY() - other.getY();
		
		if(dx > 0){
			facingDirection = Direction.left;
		}else if(dx < 0){
			facingDirection = Direction.right;
		}else if(dy < 0){
			facingDirection = Direction.down;
		}else{
			facingDirection = Direction.up;
		}
		
		return facingDirection;
	}
	
	public Position translate(Direction d, int amount){
		if(d.equals(Direction.up)){
			return addY(-amount);
		}else if(d.equals(Direction.down)){
			return addY(amount);
		}else if(d.equals(Direction.right)){
			return addX(amount);
		}else{
			return addX(-amount);
		}
	}
	
	public static Position getInterpolatedPosition(Position p0, Position p1, float alpha){
		int ax = (int) Math.floor((1-alpha) * p0.getX() + alpha * p1.getX());
		int ay = (int) Math.floor((1-alpha) * p0.getY() + alpha * p1.getY());
		
		return new Position(ax, ay);
	}
	
	
	public boolean equals(Object other){
		if(other == null){
			return false;
		}
		
		if(!other.getClass().equals(this.getClass())){
			return false;
		}
		
		Position otherPosition = (Position) other;
		
		return otherPosition.getX() == this.getX() && otherPosition.getY() == this.getY();
	}	
}
