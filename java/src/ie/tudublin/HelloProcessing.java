package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		//colorMode(HSB);
		background(255,0,0);

	
		
	}

	
	
	public void draw()
	{	
		stroke(255); //color of line
		fill(255,255,96); //fill gaps between lines
		stroke(255,255,96);
		circle(250,250,400); //first two param(center of circle), third param is diameter
		fill(173,216,230);
		stroke(173,216,230);
		triangle(400, 450, 250, 20, 80, 450);
		fill(255);
		stroke(255);
		ellipse(243, 250, 150,90);
		stroke(0,0,0);
		fill(0,0,0);
		circle(243, 250, 60);


	}
}
