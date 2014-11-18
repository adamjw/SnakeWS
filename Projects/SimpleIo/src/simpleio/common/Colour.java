package simpleio.common;

import java.util.Random;

public class Colour {

	public static final Colour BLACK 	= new Colour(255,   0,   0,   0);
	public static final Colour WHITE 	= new Colour(255, 255, 255, 255);
	public static final Colour RED		= new Colour(255, 255,   0,   0);
	public static final Colour GREEN 	= new Colour(255,   0, 255,   0);
	public static final Colour BLUE  	= new Colour(255,   0,   0, 255);
	
	
	private int alphaComponent;
	private int redComponent;
	private int greenComponent;
	private int blueComponent;
	

	public Colour(int alphaComponent, int redComponent, int greenComponent, int blueComponent){
		if(alphaComponent > 255 || alphaComponent < 0){
			throw new Error("Alpha Component has an invalid value.");
		}
		
		if(redComponent > 255 || redComponent < 0){
			throw new Error("Red Component has an invalid value.");
		}


		if(greenComponent > 255 || greenComponent < 0){
			throw new Error("Green Component has an invalid value.");
		}

		
		if(blueComponent > 255 || blueComponent < 0){
			throw new Error("Blue Component has an invalid value.");
		}
		
		this.alphaComponent = alphaComponent;
		this.redComponent 	= redComponent;
		this.blueComponent 	= blueComponent;
		this.greenComponent = greenComponent;
	}
	
	public static Colour getRandomColour(int minA, int minR, int minG, int minB){
		Random rng = new Random();
		int a = rng.nextInt(255 - minA) + minA;
		int r = rng.nextInt(255 - minR) + minR;
		int g = rng.nextInt(255 - minG) + minG;
		int b = rng.nextInt(255 - minB) + minB;
		
		return new Colour(a,r,g,b);
	}
	
	public int getAlphaComponent(){
		return alphaComponent;
	}
	
	public int getRedComponent(){
		return redComponent;
	}
	
	public int getGreenComponent(){
		return greenComponent;
	}
	
	public int getBlueComponent(){
		return blueComponent;
	}
	
	
}
