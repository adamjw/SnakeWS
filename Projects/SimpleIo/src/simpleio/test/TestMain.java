package simpleio.test;

import simpleio.common.Colour;
import simpleio.common.Point;
import simpleio.display.Window;

public class TestMain {

	public static void main(String[] args){
		Window window = new Window("Test", 640,480);
		window.display();
		
		int y = 0;
		
		while(!window.isCloseRequested()){
			window.refresh();

			y+=1;
			
			window.drawTriangle(Colour.GREEN, new Point(0, 0), new Point(320, y%480), new Point(640,0));
			
			
			window.drawLine(Colour.WHITE, new Point(0,0), new Point(640,480));
			window.drawLine(Colour.WHITE, new Point(0,480), new Point(640,0));
			
			window.drawString(Colour.WHITE, new Point(0, 0), "THIS IS A TEST PROGRAM");		
			
		}
		
		window.destroy();
	}
}
