package simpleio.display;

import java.awt.Font;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.TextureImpl;

import simpleio.common.Colour;
import simpleio.common.Point;
import static org.lwjgl.opengl.GL11.*;


public class Window {

	private TrueTypeFont font;
	private String title;
	private int width, height;
	
	public Window(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void display(){
		createDisplay();
		setGlState();
	}
	
	public void refresh(){
		Display.update();
		Display.sync(60);
		glClear(GL_COLOR_BUFFER_BIT);
	}
			
	public void destroy(){
		Display.destroy();
	}
	
	public boolean isCloseRequested(){
		return Display.isCloseRequested();
	}
	
	private void createDisplay(){
		try {
			DisplayMode mode = new DisplayMode(width, height);		
			Display.setDisplayMode(mode);
			Display.setTitle(title);
			Display.create();
			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {
			System.err.println("Invalid width or height for display mode.");
		}		
	}
	
	private void setGlState(){
		glOrtho(0, width, height, 0, 0, 10);
		
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

		glDisable(GL_DEPTH_TEST);
		glShadeModel(GL_SMOOTH);
		
		glClearColor(0, 0, 0, 0);
	}
	
	private void setColour(Colour colour){
		glColor4ub((byte) colour.getRedComponent(), (byte) colour.getGreenComponent(), (byte) colour.getBlueComponent(), (byte) colour.getAlphaComponent());
	}
	
	public void drawLine(Colour colour, Point p0, Point p1){
		setColour(colour);
		glBegin(GL_LINES);
		{
			glVertex2f(p0.getX(), p0.getY());
			glVertex2f(p1.getX(), p1.getY());
		}
		glEnd();		
	}
	
	
	public void drawRectangle(Colour colour, Point topLeft, Point bottomRight){
		setColour(colour);
		glBegin(GL_QUADS);
		{
			glVertex2f(topLeft.getX(), topLeft.getY());
			glVertex2f(topLeft.getX(), bottomRight.getY());
			glVertex2f(bottomRight.getX(), bottomRight.getY());
			glVertex2f(bottomRight.getX(), topLeft.getY());			
		}
		glEnd();
	}
	
	public void drawTriangle(Colour colour, Point p0, Point p1, Point p2){
		setColour(colour);
		glBegin(GL_TRIANGLES);
		{
			glVertex2f(p0.getX(), p0.getY());
			glVertex2f(p1.getX(), p1.getY());
			glVertex2f(p2.getX(), p2.getY());
		}
		glEnd();		
	}
	
	public void drawString(Colour colour, Point upperLeft, String text){
		if(font == null){
			loadFont();
		}
		
		
		int r = colour.getRedComponent();
		int g = colour.getGreenComponent();
		int b = colour.getBlueComponent();
		int a = colour.getAlphaComponent();
		
		Color utilColor = new Color(r,g,b,a);
		font.drawString(upperLeft.getX(), upperLeft.getY(), text, utilColor);
		TextureImpl.bindNone();
	}
	
	private void loadFont(){
		Font defaultFont = new Font("Courier New", Font.PLAIN, 12);
		font = new TrueTypeFont(defaultFont, false);
	}
	
}
