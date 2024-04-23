/**
 * Author:  Isaac Man
 * Date:    March 19, 2024
 * Subject: Reference Variable 2
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReferenceVariable2 implements ActionListener{
    JFrame frame; 
    //this is a reference variable
    JTextField t1, t2, t3;
    //JTextField is a class and t1, t2, t3 are objects of the class
    JButton b1, b2;
    public ReferenceVariable2(){
        frame = new JFrame("Calculator");
        //gives the name of the JFrame
        
        t1 = new JTextField();
        t1.setBounds(50,50,150,20);
        //(50,50) is the coordinate of the top left corner of the rect
        //150 is the width of the rect, 20 is the height
        t2 = new JTextField();
        t2.setBounds(50,100,150,20);
        t3 = new JTextField();
        t3.setBounds(50,150,150,20);
        
        //the string variable for the buttons will appear on it
        b1 = new JButton("+");
        b1.setBounds(50,200,50,50);
        b2 = new JButton("-");
        b2.setBounds(120,200,50,50);
        //this creates the objects to be able to call instance 
        //methods from them
        
        frame.setLayout(null);
        //now u can use the methods from the class
        //null says "im not going to use anything"
        frame.setSize(300,300);
        frame.setVisible(true);
        
        //adding things into the frame
        frame.add(t1);
        frame.add(t2);
        frame.add(t3);
        frame.add(b1);
        frame.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        //creates the nerve that senses when the button is pressed
    }
    public void actionPerformed(ActionEvent e){
        String s1 = t1.getText();
        String s2 = t2.getText();
        String s3 = t3.getText();
        String result = "null";
        //assigns new primitive variables with the entered text
        
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = 0;
        //converts the string into integers to do math
        
        if (e.getSource()==b1){
            //this detects if button 1 is pressed
            c = a+b;
            result = String.valueOf(result);
        }
        else if (e.getSource()==b2){
            //this detects if button 2 is pressed
            c = a-b;
            result = String.valueOf(result);
        }
        t3.setText(String.valueOf(c));
    }
    public static void main(String[]args){
        new ReferenceVariable2();
    }
}