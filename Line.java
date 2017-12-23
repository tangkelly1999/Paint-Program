package com.company;
import java.awt.Color;
import java.awt.Graphics;
/* Date: dec 5 2016
author : kelly tang
description: subclass, line class that inherits from fillableshapes class.

 */


public class Line extends Shape{

    //constructor method to initialize int xy coordinates, color
    public Line(int x1, int x2, int y1, int y2, Color color){

        super(x1, x2, y1, y2, color );

    }

    //draw method that sets the color and draws the line with given coordinates ( param is the Graphic g)
    public void draw( Graphics g){
        g.setColor(getColor());
        g.drawLine(getX1(),getX2(), getY1(), getY2());
    }



}

