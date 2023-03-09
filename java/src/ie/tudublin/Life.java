package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet
{

	LifeBoard board;
	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(RGB);
		background(0);
		board = new LifeBoard(50, width, height, this);
		board.randomise();
	}

	public void draw()
	{	
		background(0);
		board.render();
		board.applyRules();
		
	}

	public void keyPressed() {
		if (key == ' ') {
		  board.pauseResume();
		}
	  }
	  
}


