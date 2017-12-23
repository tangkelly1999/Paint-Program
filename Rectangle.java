package com.company;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Created by KellyTang on 2017-03-23.
 * Description: inherits from the FillableShape class
 */
public class Rectangle extends FillableShape{

    //constructor method to give values to int xy coordinates, color, and filled
    public Rectangle(int x1, int x2, int y1, int y2, Color color, boolean filled){
        super(x1, x2, y1, y2, color, filled);
    }

    //draw method takes param Graphics g
    //set color for rectangle object, and draw a filled or unfilled rectangle
    public void draw( Graphics g){
        g.setColor(getColor());
        if(getFilled()==true){
            g.fillRect(getX1(), getY1(),  getWidth(), getHeight());
        }
        else {
            g.drawRect(getX1(), getY1(), getWidth(), getHeight());
        }
    }
}
