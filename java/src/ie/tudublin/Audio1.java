package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{
    Minim minim;
    AudioInput ai;
    AudioBuffer ab;

    public void settings()
    {
        size(1024, 500);
    }

    int frameSize = 1024;

    public void setup() {
        colorMode(HSB);
        background(0);

        minim = new Minim(this);

        ai = minim.getLineIn(Minim.MONO, frameSize, 44100, 16);
        ab = ai.mix;
        
        smooth();
        
    }

    public void draw()
    {   
        background(0);
        noStroke();

        float half = height / 2;
        float cgap = 255 / (float)ab.size();
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            fill(cgap * i, 255, 255);
            float x = i;
            float y = half + ab.get(i) * half * 5;
            float diameter = 10;
            ellipse(x, y, diameter, diameter); 
        }

        float average = calculateAverage();
        System.out.println("Average: " + average);
    }

    private float calculateAverage() {
        float sum = 0;
        for (int i = 0; i < ab.size(); i++) {
            sum += ab.get(i);
        }
        return sum / ab.size();
    }
}

