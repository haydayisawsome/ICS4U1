import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

import java.util.*;

public class Main extends JFrame implements WindowListener, MouseListener, ActionListener{
    final static int frameHeight = 814;
    final static int frameWidth = 814;

    String event = "Title Screen";

    // creating seperate panels for different events
    JPanel titlePanel = new JPanel(new BorderLayout(0,0));
    JPanel optionsPanel = new JPanel(new BorderLayout(0,0));
    JPanel gamePanel = new JPanel(new BorderLayout(0,0));
    JLabel boardLabel2 = new JLabel();
    JLabel roundLabel;
    JLabel dieResultLabel = new JLabel("Die Result: ");

    //Creating a slider to see how many players are playing
    //Source (including the JSlider methods used in this game): https://www.geeksforgeeks.org/java-swing-jslider/
    JSlider slider = new JSlider(1,10,4);

    //GAME VARIABLES
    int NumOfPlayers = 4;
    ArrayList<Player> playerList = new ArrayList<>();
    //a large 2d array with all tiles
    Tile[][] tileList = new Tile[10][10];
    final int tile100xPos = 145;
    final int tile100yPos = 184;
    final int tileSpacing = 56;
    final int playerSize = 30;
    int playerTurn = 1;
    Player winner = null;
    int gameRound = 1;
    int dieResult;
    Player currentPlayer;
    Player nextPlayer;
    String paintEvent = "Paint Every Player";

    //main method used to create panel and an instance of this class to create a panel of the game
    public static void main(String[]args){
        Main main = new Main();
        main.setFrame();
    }

    //get tileList method for other classes
    public Tile[][] tileList(){
        return tileList;
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
        title.setVisible(true);
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
        boardLabel.setPreferredSize(new Dimension(600,600));

        titlePanel.setBackground(Color.YELLOW);
        titlePanel.add(title,BorderLayout.PAGE_START);
        titlePanel.add(playGame,BorderLayout.PAGE_END);
        titlePanel.add(boardLabel,BorderLayout.CENTER);
        titlePanel.setBounds(0,0,frameWidth,frameHeight-35);
        titlePanel.setVisible(true);
        add(titlePanel);
        validate();

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
        ImageIcon boardImgIcon2 = new ImageIcon("_Snakes_And_Ladders_\\resources\\Board.png"); 
        boardLabel2.setIcon(boardImgIcon2);
        boardLabel2.setHorizontalAlignment(SwingConstants.CENTER);

        //Setting up tiles position
        for (int i = 0;i<tileList.length;i++){
            for(int j = 0;j<tileList[i].length;j++){
                //this if statement detects rows that have ascending tile numbe(rs
                if(i % 2 == 1){
                    tileList[i][j] = new Tile((10-i - 1)*10+(j+1),tile100xPos+tileSpacing*(j),tile100yPos+tileSpacing*(i));
                }
                
                //this if statement detects rows that have descending tile numbers
                else{
                    tileList[i][j] = new Tile((10-i-1)*10+(10-j),tile100xPos+tileSpacing*(j),tile100yPos+tileSpacing*(i));
                }
            }
        }

        //setting up game title 
        roundLabel = new JLabel("Round: " + gameRound);
        roundLabel.setSize(600,100);
        roundLabel.setHorizontalAlignment(SwingConstants.LEADING);
        roundLabel.setFont(new Font("Arial", Font.BOLD, 50));

        JLabel playerLabel = new JLabel("Player: ");
        playerLabel.setSize(600,100);
        playerLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        playerLabel.setFont(new Font("Arial", Font.BOLD, 50));
        
        JLabel gameInfoLabel = new JLabel();
        gameInfoLabel.setForeground(Color.BLUE);
        gameInfoLabel.setPreferredSize(new Dimension(700,100));
        gameInfoLabel.add(roundLabel);
        gameInfoLabel.add(playerLabel);
        gameInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //setting up die panel
        JButton rollDie = new JButton("Roll Die");
        rollDie.addActionListener(this);
        rollDie.setSize(new Dimension(200,40));
        rollDie.setBackground(Color.BLUE);

        dieResultLabel.setSize(new Dimension(200,40));

        JPanel diePanel = new JPanel();
        diePanel.add(rollDie,BorderLayout.WEST);
        diePanel.add(dieResultLabel,BorderLayout.EAST);
        //sets the height of the jpanel (width does not matter due to BorderLayout)
        diePanel.setSize(new Dimension(800,60));

        gamePanel.add(diePanel,BorderLayout.PAGE_END);
        gamePanel.setBackground(Color.YELLOW);
        gamePanel.add(boardLabel2,BorderLayout.CENTER);
        gamePanel.setBounds(0,0,frameWidth,frameHeight-35);
        gamePanel.add(gameInfoLabel,BorderLayout.PAGE_START);
        add(gamePanel);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        if(paintEvent.equals("Paint Every Player")){
            for(Player player : playerList) {
                player.paint(g);
            }
        }
        else if (paintEvent.equals("Paint Current Player")){
            currentPlayer.paint(g);
        }
    }

    //all code after the start button is here
    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand(); //source: GUI unit, MovingCar.java class
        if (s.equals("Title Screen")){
            titlePanel.setVisible(true);
        }
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
            for (int i = 1;i <= NumOfPlayers;i++){
                playerList.add(new Player(i, playerSize));
            }
            //paints every player's tile on the starting tile 
            paintEvent = "Paint Every Player";
            repaint();
        }

        if(s.equals("Roll Die")){
            //GAME CODE
            //this runs a game round every loop until there is a winner
            if(winner == null){
                try{
                    currentPlayer = nextPlayer;
                    nextPlayer = playerList.get(currentPlayer.getPlayerIndex() + 1);
                }
                catch(Exception E){
                    nextPlayer = playerList.get(0);
                    gameRound++;
                }
                roundLabel.setText("Round: " + gameRound);
                currentPlayer.setSize(50);
                paintEvent = "Paint Current Player";
                repaint();
                currentPlayer.setSize(30);
                //the player roles the die
                rollDie();

                //this moves the player to the new tile after the die was rolled
                currentPlayer.setCurrentTile(currentPlayer.getCurrentTile() + dieResult);
                paintEvent = "Paint Every Player";
                repaint();

                //this paints the player again (paints to a new tile if the player was previously on a snake/ladder tile)
                currentPlayer.setCurrentTile(tileList[Tile.getTileRow(currentPlayer.getCurrentTile())][Tile.getTileCol(currentPlayer.getCurrentTile())].detectSnakeOrLadder());
                paintEvent = "Paint Every Player";
                repaint();

                //this checks to see if the player has reached the end of the board
                if(currentPlayer.getCurrentTile() >= 94){
                    winner = currentPlayer;
                }
            }
            else{
                //Now that the winner is detected, moves on to the winner screen
                //endScreen();
            }
        }
    }

    //roll die method
    public void rollDie(){
        dieResult = (int)(Math.random()*6) + 1;
        dieResultLabel.setText("Die Result: " + dieResult);
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
