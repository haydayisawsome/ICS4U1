package GUI;
/*
 * Author:  Isaac Man
 * Date:    April 23, 2024
 * Subject: Writing with mouse
 */

import java.awt.*;
import java.awt.event.*;

public class WritingWithMouse extends Frame implements MouseMotionListener{
    public WritingWithMouse(){
        addMouseMotionListener(this);
        setSize(300,300);
        setLayout(null);
        setVisible(true);
    }
    public void mouseMoved(MouseEvent e){

    }
    public void mouseDragged(MouseEvent e){
        Graphics g = getGraphics();
        g.setColor(Color.blue);
        g.fillOval(e.getX(),e.getY(),20,20);
    }
    public static void main(String[]args){
        new WritingWithMouse();
    }
}