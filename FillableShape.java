package com.company;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Created by KellyTang on 2017-03-23.
 * Desciption: FillableShape class that inherits from Shape class.
 * Line, rectangle, oval classes inherit from this class
 *
 */
public abstract class FillableShape extends Shape{

    private boolean filled;

    //contructor method to initialize values for xy cooridinates, the color, and if it's filled
    public FillableShape( int x1, int x2, int y1, int y2, Color color, boolean filled) {

        super(x1, x2, y1, y2, color);
        setFilled(filled);

    }

    //accessor method getFilled() that returns a boolean value
    public boolean getFilled(){
        return filled;
    }

    //mutator method that sets the shape as filled or unfilled
    //param filled (boolean)
    public void setFilled(boolean filled){
        this.filled = filled;
    }

    // calculates and returns width
    public int getWidth() {
        return Math.abs(getX2() - getX1());
    }

    // calculates and returns height
    public int getHeight() {
        return Math.abs(getY2() - getY1());
    }

    // returns upper left x co ordinate
    public int getUpperLeftX() {
        return Math.min(getX1(), getX2());
    }

    // returns upperleft y co ordinate
    public int getUpperLeftY() {
        return Math.min(getY1(), getY2());
    }


}
