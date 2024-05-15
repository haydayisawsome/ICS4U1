import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements WindowListener, MouseListener{
    //coordinates of the top left point to offset the frame so that the top left point is 0
    final static int leftFramePos = 108;
    final static int topFramePos = 131;
    final static int rightFramePos = 891;
    final static int bottomFramePos = 891;

    final static int frameHeight = 800;
    final static int frameWidth = 800;

    //main method used to create panel and an instance of this class to create a panel of the game
    public static void main(String[]args){
        Main m = new Main(); // Creates an instance of the game to play
        m.addWindowListener(m);
        m.setVisible(true);

        //for some reason, java positions do not match the pixels
        //using the experiemented offset values to set actual boundaries of the panel
        m.setBounds(100,100,frameHeight + (frameHeight - (rightFramePos - leftFramePos)),frameWidth + (frameWidth - (bottomFramePos - topFramePos)));
    }

    //all game code goes in main method
    public Main(){
        // Creating and setting the dimensions of the panel
        JPanel panel = new JPanel();
        add(panel);
    }

    //paint method for all graphics
    public void paint(Graphics g){

    }

    //Abstract methods
    public void mousePressed(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mouseExited(MouseEvent e){}


    public void windowClosing(WindowEvent e){
        // Exit the application when the window is closed
        System.exit(0);
        //reference: https://www.geeksforgeeks.org/system-exit-in-java/
    }
    public void windowOpened(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
}
