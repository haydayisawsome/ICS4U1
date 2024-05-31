import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
    JPanel endPanel = new JPanel(new BorderLayout(0,0));
    JPanel resultsPanel = new JPanel(new BorderLayout(0,0));
    JButton eventButton = new JButton("Event Button");
    JButton rollDie = new JButton("Roll Die");
    JButton movePlayer = new JButton("Ladder/Snake");


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
    Player winnerIcon;
    Player currentPlayerIcon;

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
        setBounds(50,50,frameHeight,frameWidth);
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
        endPanel.setVisible(false);

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
        rollDie.addActionListener(this);
        rollDie.setSize(new Dimension(200,40));

        movePlayer.setVisible(false);
        movePlayer.addActionListener(this);
        movePlayer.setSize(new Dimension(200,40));

        dieResultLabel.setSize(new Dimension(200,40));

        JPanel diePanel = new JPanel();
        diePanel.setBackground(Color.YELLOW);
        diePanel.add(rollDie,BorderLayout.CENTER);
        diePanel.add(dieResultLabel,BorderLayout.EAST);
        diePanel.add(movePlayer,BorderLayout.WEST);
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
        
        if(paintEvent.equals("Paint Every Player") && winner == null){
            for(Player player : playerList) {
                try{
                    player.paint(g);
                }
                catch(Exception e){
                    //winning case 1: player > tile 100
                    //when the player cannot be painted due to being on a tile not on the board (greater than 100)
                    if (currentPlayer.getPlayerIndex() == 0){
                        currentPlayer = playerList.get(playerList.size()-1);
                    }
                    else{
                        currentPlayer = playerList.get(currentPlayer.getPlayerIndex()-1);
                    }
                    win();
                }
            }
        }
        else if (paintEvent.equals("Paint Winner Player")){
            winnerIcon.paint(g,814/2-playerSize/2,814/2-playerSize/2);
        }
        if(paintEvent.equals("Draw Background")){
            g.setColor(Color.YELLOW);
            g.fillRect(0,0,frameHeight,frameWidth);

        }
        if(currentPlayerIcon != null && winner == null){
            currentPlayerIcon.paint(g,600,60);
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
            currentPlayer = playerList.get(0);
            //paints every player's tile on the starting tile 
            paintEvent = "Paint Every Player";
            repaint();
            currentPlayerIcon = new Player(1,50);
            currentPlayerIcon.setColor(playerList.get(0).getColor());
        }

        if(s.equals("Roll Die")){
            //GAME CODE
            //this runs a game round every loop until there is a winner
            if(winner == null){
                try{
                    nextPlayer = playerList.get(currentPlayer.getPlayerIndex() + 1);
                }
                catch(Exception E){
                    //if there is no next player in the playerList array, it moves to the next round and the first player goes again
                    nextPlayer = playerList.get(0);
                    gameRound++;
                }
                roundLabel.setText("Round: " + gameRound);

                if(currentPlayer.getPlayerIndex()+1 == playerList.size()){
                    currentPlayerIcon.setColor(playerList.get(0).getColor());
                }
                else{
                    currentPlayerIcon.setColor(playerList.get(currentPlayer.getPlayerIndex() +1).getColor());
                }
                paintEvent = "Paint Current Player";
                repaint();

                //the player roles the die
                rollDie();

                //this moves the player to the new tile after the die was rolled
                currentPlayer.setCurrentTile(currentPlayer.getCurrentTile() + dieResult);
                paintEvent = "Paint Every Player";
                repaint();

                //this paints the player again (paints to a new tile if the player was previously on a snake/ladder tile)
                Player newPlayer = new Player(40,0);
                newPlayer.setCurrentTile(tileList[Tile.getTileRow(currentPlayer.getCurrentTile())][Tile.getTileCol(currentPlayer.getCurrentTile())].detectSnake());
                if(newPlayer.getCurrentTile() != currentPlayer.getCurrentTile()){
                    rollDie.setVisible(false);
                    movePlayer.setText("Climb Ladder");
                    movePlayer.setVisible(true);
                }
                newPlayer.setCurrentTile(tileList[Tile.getTileRow(currentPlayer.getCurrentTile())][Tile.getTileCol(currentPlayer.getCurrentTile())].detectLadder());
                if(newPlayer.getCurrentTile() != currentPlayer.getCurrentTile()){
                    rollDie.setVisible(false);
                    movePlayer.setText("Slide Down Snake");
                    movePlayer.setVisible(true);
                }
                movePlayer.setVisible(false);
                rollDie.setVisible(true);
                paintEvent = "Paint Every Player";
                repaint();

                //winning case 2: player on tile 100
                if(currentPlayer.getCurrentTile() == 100){
                    win();
                }
                currentPlayer = nextPlayer;
            }
        }
        if(s.equals("Show results")){
            winnerIcon = new Player(winner.getPlayerIndex(),100);
            winnerIcon.setColor(winner.getColor());
            paintEvent = "Paint Winner Player";
            repaint();

            endPanel.setVisible(false);
            resultsPanel.setVisible(true);
        }
    }

    //winning screen
    public void win(){
        try{
            winner = playerList.get(currentPlayer.getPlayerIndex());
        }
        catch(Exception e){
            winner = playerList.get(0);
        }
        
        JLabel endTitle = new JLabel("The game has ended...");
        endTitle.setBackground(Color.YELLOW);
        repaint();
        endTitle.setFont(new Font("Arial", Font.BOLD, 50));
        endTitle.setHorizontalAlignment(SwingConstants.CENTER);
        endTitle.setForeground(Color.GREEN.darker());

        JButton endButton = new JButton("Show results");
        endButton.setPreferredSize(new Dimension(300,100));
        endButton.addActionListener(this);
        endPanel.setBackground(Color.YELLOW);
        repaint();
        endPanel.add(endTitle,BorderLayout.NORTH);
        endPanel.add(endButton,BorderLayout.SOUTH);
        endPanel.setBounds(0,0,frameWidth,frameHeight-35);
        endPanel.setVisible(true);
        gamePanel.setVisible(false);
        add(endPanel);

        JLabel resultsTitle = new JLabel("WE HAVE A WINNER!!!");
        repaint();
        resultsTitle.setHorizontalAlignment(SwingConstants.CENTER);
        resultsTitle.setFont(new Font("Arial", Font.BOLD, 50));
        resultsTitle.setForeground(Color.GREEN.darker());
        resultsPanel.setBackground(Color.yellow);
        resultsPanel.add(resultsTitle,BorderLayout.NORTH);
        resultsPanel.setVisible(false);
        resultsPanel.setBounds(0,0,frameWidth,frameHeight-35);
        add(resultsPanel);
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
