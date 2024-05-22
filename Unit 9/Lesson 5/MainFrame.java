/*
 * Author:  Isaac Man
 * Date:    May 22, 2024
 * Subject: 
 */

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame{
    MyPanel panel;
    public MainFrame(){
        panel = new MyPanel();
        this.add(panel);
        setSize(400,400);
        setVisible(true);
        setLocationRelativeTo(this);
    }
}