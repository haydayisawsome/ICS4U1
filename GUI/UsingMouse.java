package GUI;

/**
 * Author:  Isaac Man
 * Date:    April 23, 2024
 * Subject: Using mouse listener
 */

import java.awt.*;
import java.awt.event.*;

public class UsingMouse extends Frame implements MouseListener{
    //extending Frame makes all methods in the frame class accessible
    //awt = Frame | swing = JFrame

    //All of the methods in Frame are instance methods
    //thus you do not need to make an object
    public UsingMouse(){
        addMouseListener(this); //this tells the Mouse Listener to use the methods below
        setSize(300,300);
        setVisible(true);
    }
    public static void main(String[]args){
        new UsingMouse();
        System.out.println("You are writing on the console"); 
        //this prints onto the defult console, not the frame
    }
    public void mouseEntered(MouseEvent e){
        Graphics g = getGraphics();
        g.drawString("Mouse Entered", 100, 100);
    }
    public void mouseClicked(MouseEvent e){
        Graphics g = getGraphics();
        g.setColor(Color.red);
        g.fillRect(e.getX(),e.getY(),80,40);
    }
    public void mouseExited(MouseEvent e){
        Graphics g = getGraphics();
        g.drawString("Mouse Exited", 100, 80);
    }
    public void mousePressed(MouseEvent e){

    }
    public void mouseReleased(MouseEvent e){

    }
    //you must overide all of them methods to tell them what to do
    //they dont know what to do with the classes until you create the overloaded methods
}