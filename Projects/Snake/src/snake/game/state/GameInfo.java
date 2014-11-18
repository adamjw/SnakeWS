package snake.game.state;

public class GameInfo {

	public static enum GameState {
		NOT_STARTED,
		DEAD,
		PLAYING,
		RESTARTING,
	}
	
	private GameState state;
	
	private String title;
	private String message;
	
	private int framesPerMove;
	private int currentFrame;
	
	private int score;
	private int highScore;
	
	public GameInfo(String title, int gameSpeed){
		this.framesPerMove = gameSpeed;
		this.title = title;
		this.message = "";
		this.state = GameState.NOT_STARTED;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getMessage(){
		switch(state){
		case NOT_STARTED	: return "Press Space to start";
		case DEAD			: return "Press Space to restart.";
		default				: return message;
		}
	}
	
	public GameState getState(){
		return state;
	}
	
	public void setState(GameState state){
		this.state = state;
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public int getScore(){
		return score;
	}
	
	public int getHighScore(){
		return highScore;
	}
	
	public int getFrame(){
		return currentFrame;
	}
	
	public void setFrame(int frame){
		currentFrame = frame;
	}
	
	public int getFramesPerMove(){
		return framesPerMove;
	}
	
	public void setScore(int score){
		this.score = score;
		
		if(score > highScore){
			highScore = score;
			message = "High score!";
		}
	}
	
}
