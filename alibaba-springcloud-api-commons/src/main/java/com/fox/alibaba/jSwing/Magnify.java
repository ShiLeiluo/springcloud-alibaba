package com.fox.alibaba.jSwing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;

import javax.swing.JFrame;

/**
* @author F1337248 ShiLeiluo
* @date 2024-01-18 08:56
* @version 1.0
*/
public class Magnify extends JFrame{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// object
    static Magnify m;

    // image
    Image i;

    // default constructor
    @SuppressWarnings("deprecation")
	Magnify()
    {
        // create a frame
        super("magnify");

        // set size of frame
        setSize(200, 220);
        show();

        // function to magnify the image
        work();
    }

    // main function
    public static void main(String args[])
    {

        // object of class
        m = new Magnify();
    }

    public void work()
    {
        try {
            // create a robot
            Robot r = new Robot();

            // while the frame is visible
            while (isVisible()) {
                // get the position of mouse
                Point p = MouseInfo.getPointerInfo().getLocation();

                // create a screen capture around the mouse pointer
                i = r.createScreenCapture(new Rectangle((int)p.getX() - 30,
                                                        (int)p.getY() - 30, 150, 150));

                // repaint the container
                repaint();
            }
            // exit the program
            System.exit(0);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // paint function
    public void paint(Graphics g)
    {

        // draw the image
        g.drawImage(i, 0, 0, 300, 300, this);
    }
}
