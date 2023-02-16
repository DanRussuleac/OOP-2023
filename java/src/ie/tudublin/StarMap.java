// Code for a star map visualization
package ie.tudublin;

// Import the ArrayList class from the Java Standard Library
import java.util.ArrayList;

// Import the PApplet class from the Processing Core Library
import processing.core.PApplet;

// Import the Table class from the Processing Data Library
import processing.data.Table;

// Import the TableRow class from the Processing Data Library
import processing.data.TableRow;

public class StarMap extends PApplet {

    // Create an ArrayList to store the star objects
    ArrayList<Star> stars = new ArrayList<Star>();
    
    // Declare a public float variable 'border'
    public float border;

    // Method to draw a grid on the map
    void drawGrid()
    {
        // Set the stroke color to pink
        stroke(255, 0, 255);
        
        // Set the text alignment to center and center
        textAlign(CENTER, CENTER);
        
        // Set the text size to 20
        textSize(20);
        
        // Loop through values from -5 to 5
        for(int i = -5; i <=5; i ++)
        {
            // Map the values to the width and height of the map
            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width - border, x);
            
            // Set the fill color to white
            fill(255);
            
            // Display the values at the top and left of the map
            text(i, x, border * 0.5f);
            text(i, border * 0.5f, x);
        }
    }

    // Method to print all the stars in the ArrayList 'stars' to the console
    void printStars()
    {
        // Loop through the ArrayList 'stars'
        for(Star s:stars)
        {
            // Print each star object to the console
            System.out.println(s);
        }
    }

    // Method to load the star data from the CSV file and add each star object to the ArrayList 'stars'
    void loadStars()
    {
        // Load the data from the CSV file "HabHYG15ly.csv"
        Table table = loadTable("HabHYG15ly.csv", "header");
        
        // Loop through the rows of the table
        for(TableRow r:table.rows())
        {
            // Create a Star object from each row
            Star s = new Star(r);
            
            // Add the star object to the ArrayList 'stars'
            stars.add(s);
        }
    }

    // Method to set the size of the map to 800x800 pixels
    public void settings() {
        size(800, 800);
    }

    // Declare two Star objects 'first' and 'second' and initialize them with a null value
    Star first = null;
    Star second = null;

    // Method to implement the mouse click event, where the user can select two stars and see the distance between them
    public void mouseClicked()
    {
        // Loop through the ArrayList 'stars'
        for(Star s:stars)
        {
            // Map the x and y values of each star to the width and height of the map
            float x = map(s.getxG(), -5, 5, border, width - border);
            float y = map(s.getyG(), -5, 5, border, height - border);

            // Check if the mouse click is within 20 pixels of the current star
            if (dist(mouseX, mouseY, x, y) < 20)
            {
                // If 'first' is null, set 'first' to the current star
                if (first == null)
                {
                    first = s;
                    break;
                }
                // If 'second' is null, set 'second' to the current star
                else if (second == null)
                {
                    second = s;
                    break;
                } 
                // If both 'first' and 'second' have values, set 'first' to the current star and reset 'second' to null
                else
                {
                    first = s;
                    second = null;
                    break;
                }
            }
        }
    }

    // Method to set up the environment for the map visualization
    public void setup() {
        // Set the color mode to RGB
        colorMode(RGB);
        
        // Load the star data
        loadStars();
        
        // Print the stars to the console
        printStars();

        // Set the value of the 'border' variable
        border = width * 0.1f;
    }

    // Method to draw the stars on the map
    public void drawStars()
    {
        // Loop through the ArrayList 'stars'
        for(Star s:stars)
        {
            // Render each star on the map
            s.render(this);
        }
    }

    // Method to draw the map
    public void draw() 
    {
        // Set the background color to black
        background(0);
        
        // Draw the grid on the map
        drawGrid();
        
        // Draw the stars on the map
        drawStars();

        // If 'first' has a value
        if (first != null)
        {
            // Map the x and y values of 'first' to the width and height of the map
            float x = map(first.getxG(), -5, 5, border, width - border);
            float y = map(first.getyG(), -5, 5, border, height - border);

            // If 'second' has a value
            if (second != null)
            {
                // Map the x and y values of 'second' to the width and height of the map
                float x2 = map(second.getxG(), -5, 5, border, width - border);
                float y2 = map(second.getyG(), -5, 5, border, height - border);

                // Set the stroke color to yellow
                stroke(255, 255, 0);
                
                // Draw a line between 'first' and 'second'
                line(x, y, x2, y2);

                // Calculate the distance between 'first' and 'second'
                float dist = dist(first.getxG(), first.getyG(), first.getzG(), second.getxG(), second.getyG(), second.getzG());

                // Set the fill color to white
                fill(255);
                
                // Set the text alignment to center and center
                textAlign(CENTER, CENTER);
                
                // Display the distance between 'first' and 'second' at the bottom of the map
                text("Distance between: " + first.getDisplayName() + " and " + second.getDisplayName() + " is " + dist + " parsecs", width / 2, height - (border * 0.5f));
            }
            // If 'second' is null
            else
            {
                // Set the stroke color to yellow
                stroke(255, 255, 0);
                
                // Draw a line between 'first' and the mouse position
                line(x, y, mouseX, mouseY);
            }
        }
    }
}

