package GUI;
/**
 * Author:  Isaac Man
 * Date:    April 24, 2024
 * Subject: Moving a ball on the screen using arrow keys
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UsingKeyboards extends JPanel implements ActionListener, KeyListener{
    //initial position of the ball
    int x = 0;
    int y = 0;
    
    //initial velocity of the ball
    int velX = 0;
    int velY = 0;

    //diameter of the ball
    int d = 50;
    Timer time = new Timer(5,this);
    //5 means 5 miliseconds between every time
    public static void main(String[]args){
        UsingKeyboards uk = new UsingKeyboards();
        JFrame f = new JFrame("Moving Ball");
        f.getContentPane().setBackground(Color.yellow);
        f.setSize(500,400);
        f.add(uk);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void paint(Graphics g){
        super.paint(g);
        //super allows you to access classes from the higher heirachy
        g.setColor(Color.blue);
        g.fillOval(x,y,d,d);
    }
    public UsingKeyboards(){
        time.start();
        addKeyListener(this);
        setFocusable(true);
    }
    public void actionPerformed(ActionEvent e){
        x = velX + x;
        y = velY + y;
        repaint();
    }
    public void keyPressed(KeyEvent e){
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT){
            velX = -1;
            velY = 0;
        }
        if (c == KeyEvent.VK_RIGHT){
            velX = 1;
            velY = 0;
        }
        if (c == KeyEvent.VK_UP){
            velX = 0;
            velY = 1;
        }
        if (c == KeyEvent.VK_DOWN){
            velX = 0;
            velY = -1;
        }
    }
    public void keyReleased(KeyEvent e){

    }
    public void keyTyped(KeyEvent e){

    }
}