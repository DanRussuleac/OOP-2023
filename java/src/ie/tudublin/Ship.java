package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Ship {
    private PVector pos;
    private PApplet p;

    public Ship(float x, float y, float size, int c, PApplet p) {
        pos = new PVector(x, y);
        this.size = size;
        this.c = c;
        this.p = p;
    }

    public PVector getPos() {
        return pos;
    }

    public void setPos(PVector pos) {
        this.pos = pos;
    }

    public float getRot() {
        return rot;
    }

    public void setRot(float rot) {
        this.rot = rot;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    private float rot;
    private int c;
    private float size;

    public void render() {
        p.pushMatrix(); // Save the current transformation matrix
        p.translate(pos.x, pos.y); // Move to the ship's position
        p.rotate(rot); // Rotate by the ship's rotation angle
        p.fill(c); // Set the fill color for the ship

        // Draw the ship as a triangle
        p.beginShape();
        p.vertex(-size / 2, size / 2);
        p.vertex(size / 2, size / 2);
        p.vertex(0, -size / 2);
        p.endShape(PApplet.CLOSE);
        p.popMatrix(); // Restore the transformation matrix
    }
}
