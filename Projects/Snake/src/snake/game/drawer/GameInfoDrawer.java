package snake.game.drawer;



import simpleio.common.Colour;
import simpleio.common.Point;
import simpleio.display.Window;
import snake.game.state.GameInfo;

public class GameInfoDrawer {

	private GameInfo info;
	private Window window;
	private Point upperLeft;
	
	public GameInfoDrawer(GameInfo info, Window window, Point upperLeft){
		this.info = info;
		this.window = window;
		this.upperLeft = upperLeft;
	}
	
	public void drawTitle(){
		window.drawString(Colour.WHITE, upperLeft, info.getTitle());
	}
	
	public void drawMessage(){
		window.drawString(Colour.WHITE, upperLeft.addY(12), info.getMessage());
	}
	
	public void drawScore(){
		Point textPosition = upperLeft.addX(175);
		Point scorePosition = upperLeft.addXY(175, 12);
		
		window.drawString(Colour.WHITE, textPosition, "Score");		
		window.drawString(Colour.WHITE, scorePosition, String.valueOf(info.getScore()));
	}
	
	public void drawHighScore(){
		Point textPosition = upperLeft.addX(275);
		Point scorePosition = upperLeft.addXY(275, 12);
		
		window.drawString(Colour.WHITE, textPosition, "High Score");		
		window.drawString(Colour.WHITE, scorePosition, String.valueOf(info.getHighScore()));		
	}
}
