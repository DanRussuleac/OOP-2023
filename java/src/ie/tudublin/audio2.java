package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class audio2 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab; 
    float[] lerpedBuffer;

    public void settings()
    {
        size(640, 360);
    }

    public void setup()
    {
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix;
        lerpedBuffer = new float[width];
    }

    public void draw()
    {
        background(0);
        colorMode(HSB);
        float half = height / 2;
        stroke(255);
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            stroke(map(i, 0, ab.size(), 0, 255), 255, 255);
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
            float f = abs(lerpedBuffer[i] * half);
            line(i, half, i, half + ab.get(i) * half);
        }

        println(map1(5, 0, 10, 1000, 2000));
    }

    public float map1(float a, float b, float c, float d, float e)
    {
        float f = (a - b) / (c - b);
        return d + f * (e - d);
    }
}



