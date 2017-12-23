package com.company;
import java.awt.Graphics;
import java.awt.Color;
/**
 * Created by KellyTang on 2017-03-23.
 * Description: Circle class is a child class inheriting from FillableShape class
 */
public class Circle extends FillableShape{

    //parametized contructor method
    public Circle(int x1, int x2, int y1, int y2, Color color, boolean filled){
        super(x1, x2, y1, y2, color, filled);
    }

    // public draw method that takes in param Graphics g
    //sets the color of the object, and draws an empty or filled oval
    public void draw(Graphics g) {
        g.setColor(getColor());
        if (getFilled()==true) {
            g.fillOval(getX1(), getY1(), getWidth(), getHeight());
        } else {
            g.drawOval(getX1(), getY1(), getWidth(), getHeight());
        }
    }
}
