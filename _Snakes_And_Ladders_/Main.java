import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements WindowListener, MouseListener, ActionListener{
    final static int frameHeight = 814;
    final static int frameWidth = 814;

    String event = "Title Screen";
    int NumOfPlayers = 4;

    // creating seperate panels for different events
    JPanel titlePanel = new JPanel(new BorderLayout(0,0));
    JPanel optionsPanel = new JPanel(new BorderLayout(0,0));
    JPanel gamePanel = new JPanel(new BorderLayout(0,0));

    //Creating a slider to see how many players are playing
    //Source (including the JSlider methods used in this game): https://www.geeksforgeeks.org/java-swing-jslider/
    JSlider slider = new JSlider(1,10,4);

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

    //all screen's frontend code goes in this method
    public Main(){
        super("Snakes and Ladders"); //calls the default constructor of the parent class (JFrame) to create a new JFrame
        addMouseListener(this);
        addWindowListener(this);
        setLayout(null); //all dimensions are based on setBounds

        //ensuring that the other panels in the game are not shown
        optionsPanel.setVisible(false);
        gamePanel.setVisible(false);

        //TITLE SCREEN
        // JLabel source: https://docs.oracle.com/javase%2F8%2Fdocs%2Fapi%2F%2F/javax/swing/JLabel.html
        JLabel title = new JLabel("SNAKES AND LADDERS");
        title.setFont(new Font("Arial", Font.BOLD, 60));
        title.setBounds(100,100,100,100);
        // Color class source: https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html
        // Setting JLabel color source: https://forums.codeguru.com/showthread.php?492301-SWING-JLabel-set-background-color 
        title.setForeground(Color.GREEN.darker());
        // horiz alignment source: https://stackoverflow.com/questions/12589494/align-text-in-jlabel-to-the-right
        title.setHorizontalAlignment(SwingConstants.CENTER);

        //JButton source: GUI unit, class MovingCar.java
        JButton playGame = new JButton("SELECT OPTIONS");
        playGame.setFont(new Font("Arial", Font.BOLD, 30));
        playGame.addActionListener(this);
        //setPreferred size is used when there is already a layout manager
        //this dimension will be considered but might not always work (only works for height and not width due to layout manager)
        //Source: https://stackoverflow.com/questions/1783793/java-difference-between-the-setpreferredsize-and-setsize-methods-in-compone
        playGame.setPreferredSize(new Dimension(800,75));
        playGame.setHorizontalAlignment(SwingConstants.CENTER);

        //getting image from files source: https://stackoverflow.com/questions/16631636/what-is-the-correct-path-to-display-an-imageicon-png-file-for-windows-7
        ImageIcon boardImgIcon = new ImageIcon("_Snakes_And_Ladders_\\resources\\Board.png"); 

        //setting the image to the label
        JLabel boardLabel = new JLabel();
        boardLabel.setIcon(boardImgIcon);
        boardLabel.setHorizontalAlignment(SwingConstants.CENTER);

        titlePanel.setVisible(true);
        titlePanel.setBackground(Color.YELLOW);
        titlePanel.add(title,BorderLayout.PAGE_START);
        titlePanel.add(playGame,BorderLayout.PAGE_END);
        titlePanel.add(boardLabel,BorderLayout.CENTER);
        titlePanel.setBounds(0,0,frameWidth,frameHeight-35);
        add(titlePanel);

        //OPTIONS SCREEN
        JLabel optionsTitle = new JLabel("Choose number of players:");
        optionsTitle.setFont(new Font("Arial", Font.BOLD, 60));
        optionsTitle.setBounds(100,100,100,100);
        optionsTitle.setForeground(Color.GREEN.darker());
        optionsTitle.setHorizontalAlignment(SwingConstants.CENTER);

        slider.setPreferredSize(new Dimension(frameWidth-100,100));
        slider.setSnapToTicks(true);
        slider.setPaintLabels(true);
        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(1);
        slider.setBackground(Color.YELLOW);

        //creating another panel with just the slider so it can be resized with changable dimensions
        JPanel sliderPanel = new JPanel();
        sliderPanel.add(slider);
        sliderPanel.setBackground(Color.YELLOW);

        JButton playerNumOptionsButton = new JButton("START");
        playerNumOptionsButton.setFont(new Font("Arial", Font.BOLD, 30));
        playerNumOptionsButton.addActionListener(this);
        playerNumOptionsButton.setPreferredSize(new Dimension(800,75));
        playerNumOptionsButton.setHorizontalAlignment(SwingConstants.CENTER);

        optionsPanel.setBackground(Color.YELLOW);
        optionsPanel.add(optionsTitle,BorderLayout.PAGE_START);
        optionsPanel.add(sliderPanel,BorderLayout.CENTER);
        optionsPanel.add(playerNumOptionsButton,BorderLayout.PAGE_END);
        optionsPanel.setBounds(0,0,frameWidth,frameHeight-35);
        add(optionsPanel);

        //GAME PANEL
        JLabel boardLabel2 = new JLabel();
        boardLabel2.setIcon(boardImgIcon);
        boardLabel2.setHorizontalAlignment(SwingConstants.CENTER);

        gamePanel.setBackground(Color.YELLOW);
        gamePanel.add(boardLabel2);
        gamePanel.setBounds(0,0,frameWidth,frameHeight-35);
        add(gamePanel);
    }

    //paint method for all graphics
    public void paint(Graphics G){
        //detect which event is ongoing and paints screen depending on event
        
        //this line of code sets the graphics to match the pixels of the JFrame, and not the JPanel
        super.paint(G);
        Graphics g = getContentPane().getGraphics();

        if(event.equals("Game")){

        }
    }

    //all code after the start button is here
    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand(); //source: GUI unit, MovingCar.java class
        if (s.equals("SELECT OPTIONS")){
            //changing visible panel to options screen
            titlePanel.setVisible(false);
            optionsPanel.setVisible(true);

            //detecting the different buttons pressed in options screen

        }
        if(s.equals("START")){
            NumOfPlayers = slider.getValue();
            optionsPanel.setVisible(false);
            gamePanel.setVisible(true);
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
