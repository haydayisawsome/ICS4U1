package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class MovingCar extends Frame implements ActionListener{
    int x;
    int y;
    int w;
    Button b1; //button for back
    Button b2; //button for forward
    Button b3; //button for stop
    String msg = "";

    public void sleep(){
        try{
            Thread.sleep(15);
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
    public MovingCar(){
        //car position
        x = 2;
        y = 100;
        setLayout(new FlowLayout(FlowLayout.CENTER));
        b1 = new Button("back");
        add(b1);
        b2 = new Button("forward");
        add(b2);
        b3 = new Button("stop");
        add(b3);
        //connection buttons to ActionListener
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        //the functionality of the car
        String s = e.getActionCommand();
        if (s.equals("forward")){
            msg = "forward";
            repaint();
        }
        if (s.equals("back")){
            msg = "back";
            repaint();
        }
        if (s.equals("stop")){
            msg = "stop";
            repaint();
        }
    }
    public static void main(String[]args){
        MovingCar m = new MovingCar();
        m.setSize(500,300);
        m.setVisible(true);
        m.setLayout(new FlowLayout());
        //the frame of the window
    }

    public void paint(Graphics g){
        setBackground(Color.cyan);
        w = getWidth(); //returns the width of the frame;

        //car's body
        g.setColor(Color.blue);
        g.fillRect(x,y,100,40);
        g.setColor(Color.red);
        g.fillRect(x,y+40,150,40);

        //car's tires
        g.setColor(Color.black);
        g.fillOval(x+20,y+70,20,20);
        g.fillOval(x+90,y+70,20,20);
        
        //road
        g.drawLine(0,190,500,190);

        sleep();
        //you need to delay the repaint

        if(msg.equals("forward")){
            if(x<400){
                x = x+1;
                repaint();
            }
        }
        if(msg.equals("back")){
            if(x>0){
                x = x-1;
                repaint();
            }
        }
        if(msg.equals("stop")){

        }
    }
}