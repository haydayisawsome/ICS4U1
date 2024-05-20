import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.*;

public class Main extends JFrame implements WindowListener, MouseListener{
    final static int frameHeight = 800;
    final static int frameWidth = 800;

    String event = "Title Screen";
    BufferedImage board;


    //main method used to create panel and an instance of this class to create a panel of the game
    public static void main(String[]args){
        Main main = new Main();
        main.setFrame();
    }

    //this method must be an instance method as an error will occur when the code is placed in the static main method
    public void setFrame(){
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // For some reason, the dimensions of the frame do not match the variables for setBounds
        // I have experiemented with the offset numbers to match the dimensions of the JFrame and the variables
        setBounds(100,100,frameHeight,frameWidth);
    }

    //all game code goes in main method
    public Main(){
        super("Snakes and Ladders"); //calls the default constructor of the parent class (JFrame) to create a new JFrame
        addMouseListener(this);
        addWindowListener(this);
        setLayout(null);

        // JLabel source: https://docs.oracle.com/javase%2F8%2Fdocs%2Fapi%2F%2F/javax/swing/JLabel.html
        JLabel title = new JLabel("SNAKES AND LADDERS");
        title.setFont(new Font("Arial", Font.BOLD, 60));
        title.setBounds(100,100,100,100);
        // Color class source: https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html
        // Setting JLabel color source: https://forums.codeguru.com/showthread.php?492301-SWING-JLabel-set-background-color 
        title.setForeground(Color.GREEN.darker());

        JButton playGame = new JButton("Hello");
        playGame.setSize(new Dimension(200, 100));
        // horiz alignment for button: https://stackoverflow.com/questions/12589494/align-text-in-jlabel-to-the-right
        playGame.setHorizontalAlignment(SwingConstants.CENTER);
        
        // creating a seperate panel with all of the title screen elements
        JPanel titlePanel = new JPanel(new BorderLayout(0,0));
        titlePanel.setBackground(Color.YELLOW);
        titlePanel.add(title,BorderLayout.NORTH);
        titlePanel.add(playGame,BorderLayout.CENTER);
        titlePanel.setBounds(0,0,getX(),getY());
        add(titlePanel);
    }

    //paint method for all graphics
    public void paint(Graphics G){
        //detect which event is ongoing and paints screen depending on event
        
        //this line of code sets the graphics to match the pixels of the JFrame, and not the JPanel
        super.paint(G);
        Graphics g = getContentPane().getGraphics();

        if(event.equals("Title Screen")){
            setBackground(Color.YELLOW);
            g.setColor(Color.GREEN);
        }
        if(event.equals("Game")){
            ImageIcon image = new ImageIcon("C:\\Users\\isaac\\Downloads\\ICS4U1\\ICS4U1\\GUI\\Airplane.png");
            image.paintIcon(this,g,0,0);
        }
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
