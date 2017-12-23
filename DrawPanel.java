package com.company;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
/*
Date: May 5 2017
Author: Kelly Tang
Description: DrawPanel class that inherits from JPanel. This is where mouse event handling occurs, and also where
shapes objects are created and placed into a dynamic data structure, the LinkedList. There's an inner class
for mouse event handling, and  undo(), redo(), clear(), changeShape(), changeColor(), and filled() methods to
change change the properties of the shape, or the LinkedList.

 */
public class DrawPanel extends JPanel {

    private JLabel statusBar;

    private Shape shape = null;
    private Shape shape1=null;
    private Shape shape2 = null;

    LinkedList<Shape>myList = new LinkedList<>();
    LinkedList <Shape> tempList = new LinkedList<>();

    private int whichShape = 0;

    private Color color;
    private boolean filled;

   /* constructor method, with parameter JLabel statusLabel,
      mouse and mouse motion events created here
    */
    public DrawPanel( JLabel statusLabel) {

        statusBar = statusLabel;
        setBackground( Color.WHITE );

        // Create and register listener for mouse and mouse motion events
        MouseEventListener drawPanelListener = new MouseEventListener();
        addMouseListener( drawPanelListener );
        addMouseMotionListener( drawPanelListener );
    }


    //Inner class to handle mouse events
    class MouseEventListener extends MouseAdapter {
        // Mouse press indicates a new line has been started
        @Override

        //when mouse is pressed, a shape is created
        //the shape that is created is determined by which shape the user chose in the comboBox ( choice is stored in variable whichShape)
        public void mousePressed( MouseEvent event ) {

            if (whichShape ==1) {
                shape = new Rectangle(event.getX(), event.getX(), event.getY(),event.getY(), color, filled);

            }
            else if (whichShape ==0) {
                shape = new Line(event.getX(), event.getX(), event.getY(),event.getY(), color);

            }

            else {
                shape = new Circle(event.getX(), event.getX(), event.getY(),event.getY(), color, filled);

            }
            repaint();
        }

        @Override
        //when mouse is released, update co ordinates and add the finished shape to the myList LinkedList
        public void mouseReleased( MouseEvent event ) {
            // Update ending coordinates
            shape.setX2( event.getX() );
            shape.setY2( event.getY() );
            shape.setColor( color );

            myList.addFirst(shape);

            // Get ready for the next line to be drawn
            shape = null;
            repaint();
        }
        // As mouse is dragged, update ending coordinates of currentLine and statusBar
        @Override
        public void mouseDragged( MouseEvent event ) {
            shape.setX2( event.getX() );
            shape.setY2( event.getY() );
            statusBar.setText( String.format( "Mouse at (%d, %d)",
                    event.getX(), event.getY() ) );
            repaint();
        }

        // As mouse is moved, just update the statusBar
        @Override
        public void mouseMoved( MouseEvent event ) {
            statusBar.setText( String.format( "Mouse at (%d, %d)",
                    event.getX(), event.getY() ) );
        }
    }

    //public method that is called from drawFrame class, it removes the first object in the LinkedList myList
    //a reference to the data is stored in shape2 variable, in case it's needed after for the redo() method
    public void undo(){
        shape2 = myList.removeFirst();
        repaint();
    }

    //public redo() method that adds back the shape that was just removed
    //uses the shape2 variable to get the data
    public void redo(){
        if (shape2!=null)
        myList.addFirst(shape2);
        repaint();

    }
    //public clear() method that removes all the shapes in myList
    public void clear(){
        myList.clear();
        shape2 = null;
        repaint();
    }

    // This method is called automatically by the JVM when the window needs to be (re)drawn.
    @Override
    public void paintComponent( Graphics g ) {

        super.paintComponent( g );

        int numShapes = myList.size();

        //copy each object in mylist into a temporary LinkedList
        for (int i = 0; i<numShapes; i++){
            tempList.addFirst(myList.removeFirst());

        }
        //as each shape is returned to myList from the tempList, call the draw(g) for that shape
        for (int i = 0; i<numShapes; i++){
            shape1 = tempList.removeFirst();
            myList.addFirst(shape1);
            shape1.draw(g);

        }

        // If a line is in progress, draw it on top of all others
        if ( shape != null )
            shape.draw( g );

    }

    //public method with int chooseShape parameter to change the whichShape variable, which will change the shape drawn
    public void changeShape(int chooseShape){

        whichShape = chooseShape;
    }


    //public method with param int whichColor which will set the color variable to 1 of the 5 colours depending on the
    //index chosen from the combobox , returns the color
    public Color changeColor( int whichColor){
        if (whichColor ==0){
            color = Color.BLACK;
        }

        else if (whichColor ==1){
            color = Color.BLUE;

        }

        else if (whichColor ==2){
            color = Color.GREEN;

        }
        else if (whichColor ==3){
            color = Color.YELLOW;

        }
        else if (whichColor ==4){
            color = Color.RED;

        }
        return color;
    }

    //public method filled with param boolean isFilled
    //returns true or false (if shape should be filled or not)
    public boolean filled(boolean isFilled){

        if (isFilled)
            filled = true;
        else
            filled = false;
        return filled;
    }


} 