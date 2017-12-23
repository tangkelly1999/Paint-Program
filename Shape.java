package com.company;
import java.awt.Color;
import java.awt.Graphics;
/* Date: Dec 5 2016
author ; Kelly Tang
Description: General class with variables x1, x2, y1, y2, and color
Contains accessor and mutator methods, and abstract method draw(Graphics g)

 */
public abstract class Shape {

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color color;


    // parameterized constructor
    public Shape(int x1, int x2, int y1, int y2, Color initialColor) {
        // constructor method that takes in 5 parameters
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        color = initialColor;

    }


    //accessor methods to return x1, x2, y1, y2, or filled value
    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public Color getColor() { return color;}


    //mutator methods to check if x1 is valid, and set it tp variable
    public void setX1(int newX1) {
        if (newX1 < 0) {
            System.err.println("Less than 0");
            x1 = 0;
        } else {
            x1 = newX1;
        }
    }
    //mutator method to check if y1 value is valid, then set it
    public void setY1(int newY1) {
        if (newY1 < 0) {
            System.err.println("Less than 0");
            y1 = 0;
        } else {
            y1 = newY1;
        }
    }

    //mutator method to check if x2 value is good, then set it to variable
    public void setX2(int newX2) {
        if (newX2 < 0) {
            System.err.println("Less than 0");
            x2 = 0;
        } else {
            x2 = newX2;
        }
    }

    //mutator method to check if y2 value is >0, then assign it to variable
    public void setY2(int newY2) {
        if (newY2 < 0) {
            System.err.println("Less than 0");
            y2 = 0;
        } else {
            y2 = newY2;
        }
    }

    //mutator method to set the color
    //param is newColor (Color data type)
    public void setColor(Color newColor) {
        color = newColor;
    }


    //abstract method going to be overriden by methods in child class
    public abstract void draw(Graphics g);

}