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
    //extends JPanel enables you to use all methods of the class JPanel
    //ActionListener must be overrided as they are abstract methods

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
        //without the line above, it will not repaint the background
        //g.setColor(Color.blue);
        //g.fillOval(x,y,d,d);

        ImageIcon image = new ImageIcon("Airplane.png");
        image.paintIcon(this,g,x,y);
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
        if(x==0){
            velX = 0;
            x = 0;
        }
        if (x > 450){
            velX = 0;
            x = 450;
        }
        if (y == 0){
            velY = 0;
            y = 0;
        }
        if (y > 350){
            velY = 0;
            y = 350;
        }
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
            velY = -1;
        }
        if (c == KeyEvent.VK_DOWN){
            velX = 0;
            velY = 1;
        }
    }
    public void keyReleased(KeyEvent e){

    }
    public void keyTyped(KeyEvent e){

    }
}