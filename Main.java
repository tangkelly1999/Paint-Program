package com.company;

import javax.swing.JFrame;

/*
date: may 14 2017
autho: kelly tang
description: main function, creates DrawFrame object and set the window size
 */
public class Main {

    public static void main(String[] args) {

        DrawFrame application = new DrawFrame();

        application.setSize( 680, 520 );
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        application.setVisible( true );
    }
}
