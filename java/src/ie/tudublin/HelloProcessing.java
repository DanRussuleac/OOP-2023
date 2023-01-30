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
		background(0);

	
		
	}

	
	
	public void draw()
	{	
		stroke(255); //color of line
		line(10,10,100,100); //x1, y1, x2, y2
		circle(300,250,70); //first two param(center of circle), third param is diameter
		fill(60,190,0); //fill gaps between lines
		rect(10, 300, 10, 100); //tlx, tly, width and length
		stroke(200);
		fill(0,140,255);
		noStroke(); //no color for line
		noFill(); //no more color filling
		strokeWeight(DEFAULT_HEIGHT); //thickness of line
		triangle(40, 90, 300, 20, 80, 70);
		fill(255,0,255);


	}
}
