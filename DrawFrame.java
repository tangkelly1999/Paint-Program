package com.company;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * Created by KellyTang on 2017-03-23.
 * Description: DrawFrame class that contains the event handling for the program. Here is where I created the drawPanel
 * object, button, checkboxes, and comboBox objects,the event handling for those objects, and placing them on the layout.
 * There are 2 inner classes for event handling: the ButtonEventListener and the CheckBoxEventListener.
 */
public class DrawFrame extends JFrame {

    private DrawPanel myPanel;
    private JPanel toolPanel;

    private JCheckBox filled;

    private JComboBox<String> colourChooser;
    private String[] colourNames = { "Black", "Blue", "Green", "Yellow", "Red" };
    private JComboBox<String> shapeChooser;
    private String[] shapeName = {"Line", "Rectangle", "Oval"};

    private JButton undo;
    private JButton redo;
    private JButton clear;

    public DrawFrame() {

        super( "PAINT PROGRAM" );

        JLabel statusLabel = new JLabel();

        //create myPanel object, where the drawing will occur on
        myPanel = new DrawPanel(statusLabel);

        //create toolPanel object, where my buttons, checkbox, etc, will be added on
        toolPanel = new JPanel();

        //create and add 3 buttons, and ButtonEventListener object for each: undo, redo, and clear
        undo = new JButton("Undo");
        redo = new JButton("Redo");
        clear = new JButton("Clear");

        ActionListener eventListener = new ButtonEventListener();
        undo.addActionListener(eventListener);
        redo.addActionListener(eventListener);
        clear.addActionListener(eventListener);
        toolPanel.add(undo);
        toolPanel.add(redo);
        toolPanel.add(clear);


        //create and add checkbox
        filled = new JCheckBox("Filled");
        toolPanel.add(filled);

        // Create a CheckBoxEventListener object
        ItemListener lockBoxListener = new CheckBoxEventListener();
        // And associate it with the JCheckBox
        filled.addItemListener( lockBoxListener );
        toolPanel.add(filled);


        // Create a JComboBox, showing 3 values: rectangle, circle, line
        shapeChooser = new JComboBox<String>( shapeName);
        shapeChooser.setMaximumRowCount( 3 );

        // Create an ItemListener object that implements the itemStateChanged() method.
        ItemListener comboBoxListener2 = new ItemListener() {
            @Override
            //call the changeShape method from the DrawPanel class depending on which selection user chose
            public void itemStateChanged( ItemEvent e ) {
                myPanel.changeShape(shapeChooser.getSelectedIndex());
            }
        };

        // And associate it with the JComboBox
        shapeChooser.addItemListener( comboBoxListener2 );
        toolPanel.add( shapeChooser );


        // Create a JComboBox, showing 5 values: black, green, blue, red, yellow
        colourChooser = new JComboBox<String>( colourNames );
        colourChooser.setMaximumRowCount( 5 );

        // Create an ItemListener object that implements the itemStateChanged() method.
        ItemListener comboBoxListener = new ItemListener() {
            @Override
            public void itemStateChanged( ItemEvent e ) {
               // call the changeColor method from DrawPanel to change the color to the one the user selected
                myPanel.changeColor(colourChooser.getSelectedIndex());

            }
        };
        // And associate it with the JComboBox
        colourChooser.addItemListener( comboBoxListener );
        toolPanel.add( colourChooser);

        //add toolPanel, myPanel, and statusLabel to the a designated area on the screen
        add(toolPanel, BorderLayout.NORTH);
        add( myPanel, BorderLayout.CENTER );
        add(statusLabel, BorderLayout.SOUTH);

    }

    // Inner class for handling events on lockBox (JCheckBox)
    class CheckBoxEventListener implements ItemListener {
        // We override the itemStateChanged() method as required by the ActionListener Interface
        @Override
        public void itemStateChanged( ItemEvent e ) {
            // When the user clicks the lockBox we enable or disable the userNameField
            if ( filled.isSelected() ) {
                myPanel.filled(true);
            }
            else {
                myPanel.filled(false);
            }
        }

    }

    //Inner class for handling events for the buttons
    class ButtonEventListener implements ActionListener {

        @Override
        public void actionPerformed( ActionEvent e ) {
            if ( e.getSource() == undo ) {
                //call undo() method from DrawPanel class
                myPanel.undo();
            }
            else if (e.getSource() == redo){
                //call redo() method from DrawPanel class
                myPanel.redo();
            }
            else if (e.getSource() == clear){
                //call clear() method from DrawPanel class
                myPanel.clear();

            }
        }
    }



}





