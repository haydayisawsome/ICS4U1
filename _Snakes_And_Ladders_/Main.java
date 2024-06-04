import java.awt.*; //for layouts, fonts and other attributes of swing objects
import java.awt.event.*; //for event listeners
import javax.swing.*; //for all swing objects
import java.util.*; //for array list

public class Main extends JFrame implements WindowListener, ActionListener{
    //height and width of frame will not need to be changed during game
    final static int frameHeight = 814;
    final static int frameWidth = 814;

    //Keeping track of the current screen
    String event = "Title Screen";

    // creating seperate panels/labels/buttons for different events that need to be accessed globally
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

    //GAME VARIABLES]
    //default num of players = 4
    int NumOfPlayers = 4;
    //2d arraylist with players
    ArrayList<Player> playerList = new ArrayList<>();
    //a large 2d array with all tiles
    Tile[][] tileList = new Tile[10][10];
    //setting the positons for each of the tiles on the screen
    final int tile100xPos = 145;
    final int tile100yPos = 184;
    final int tileSpacing = 56;
    final int playerSize = 30;
    int playerTurn = 1;
    Player winner = null;
    int gameRound = 1;
    int dieResult;
    //keeping track of the current/next players in every turn
    Player currentPlayer;
    Player nextPlayer;
    //there will be multiple paint events to see which players to paint
    String paintEvent = "Paint Every Player";
    //this will be drawn to see which player is the winner player
    Player winnerIcon;
    //this will be drawn to see which player is the current player
    Player currentPlayerIcon;
    //this will keep track of the winner

    //main method used to create panel and an instance of this class to create a panel of the game
    public static void main(String[]args){
        //main method creates an instance of the class Main
        Main main = new Main();
        main.setFrame();
    }

    //this method must be an instance method as an error will occur when the code is placed in the static main method
    public void setFrame(){
        setVisible(true);
        
        // For some reason, the dimensions of the frame do not match the variables for setBounds
        // I have experiemented with the offset numbers to match the dimensions of the JFrame and the variables
        setBounds(50,50,frameHeight,frameWidth);
    }

    //all screen's frontend code goes in this method
    public Main(){
        super("Snakes and Ladders"); //calls the default constructor of the parent class (JFrame) to create a new JFrame
        addWindowListener(this);
        setLayout(null); //all dimensions are based on setBounds

        //ensuring that the other panels in the game are not shown
        optionsPanel.setVisible(false);
        gamePanel.setVisible(false);
        endPanel.setVisible(false);

        //TITLE SCREEN: All code below is to create the components of the title screen
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
        ImageIcon boardImgIcon = new ImageIcon("_Snakes_And_Ladders_\\IsaacMan_Board.png"); 

        //setting the image of the board to the llabel
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

        //OPTIONS SCREEN: All code below is to create the components of the options screen
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

        //GAME PANEL: All code below is to create the components of the game screen
        ImageIcon boardImgIcon2 = new ImageIcon("_Snakes_And_Ladders_\\IsaacMan_Board.png"); 
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

        //setting up the JLabel to show the round number
        roundLabel = new JLabel("Round: " + gameRound);
        roundLabel.setSize(600,100);
        roundLabel.setHorizontalAlignment(SwingConstants.LEADING);
        roundLabel.setFont(new Font("Arial", Font.BOLD, 50));

        //setting up the JLabel to show the whos turn it is
        JLabel playerLabel = new JLabel("Player: ");
        playerLabel.setSize(600,100);
        playerLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        playerLabel.setFont(new Font("Arial", Font.BOLD, 50));
        
        //this label includes all info labels at the top of the game panel
        JLabel gameInfoLabel = new JLabel();
        gameInfoLabel.setForeground(Color.BLUE);
        gameInfoLabel.setPreferredSize(new Dimension(700,100));
        gameInfoLabel.add(roundLabel);
        gameInfoLabel.add(playerLabel);
        gameInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);


        //button for rolling die
        rollDie.addActionListener(this);
        rollDie.setSize(new Dimension(200,40));

        //button for moving player up ladder/down snake
        movePlayer.setVisible(false);
        movePlayer.addActionListener(this);
        movePlayer.setSize(new Dimension(200,40));

        //label for showing the result of the die
        dieResultLabel.setSize(new Dimension(200,40));

        //this panel includes all components relating to moving the player
        JPanel diePanel = new JPanel();
        diePanel.setBackground(Color.YELLOW);
        diePanel.add(rollDie,BorderLayout.CENTER);
        diePanel.add(dieResultLabel,BorderLayout.EAST);
        diePanel.add(movePlayer,BorderLayout.WEST);
        //sets the height of the jpanel (width does not matter due to BorderLayout)
        diePanel.setSize(new Dimension(800,60));

        //adding all components to the game panel
        gamePanel.add(diePanel,BorderLayout.PAGE_END);
        gamePanel.setBackground(Color.YELLOW);
        gamePanel.add(boardLabel2,BorderLayout.CENTER);
        gamePanel.setBounds(0,0,frameWidth,frameHeight-35);
        gamePanel.add(gameInfoLabel,BorderLayout.PAGE_START);
        add(gamePanel);
    }
    
    //For the paint method, there will be paint events to determine what must be painted
    @Override
    public void paint(Graphics g){
        super.paint(g);

        //occurs after every turn, paints every player again
        if(paintEvent.equals("Paint Every Player") && winner == null){
            for(Player player : playerList) {
                try{
                    player.paint(g);
                }
                catch(Exception e){
                    //winning case 1: player > tile 100
                    //when the player cannot be painted due to being on a tile not on the board (greater than 100)
                    if (nextPlayer.getPlayerIndex() == 0){
                        currentPlayer = playerList.get(playerList.size()-1);
                    }
                    else{
                        currentPlayer = playerList.get(nextPlayer.getPlayerIndex()-1);
                    }
                    win();
                }
            }
        }
        //for painting the winner player at the end panel
        else if (paintEvent.equals("Paint Winner Player")){
            winnerIcon.paint(g,814/2-playerSize/2,814/2-playerSize/2);
        }
        //for painting which player's turn it is 
        if(currentPlayerIcon != null && winner == null){
            currentPlayerIcon.paint(g,600,60);
        }
    }

    //all code after the start button is here
    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand(); //source: GUI unit, MovingCar.java class
        //all if statements detect which button is pressed
        //Each if statement switches the current panel to not visible, and the next panel to be visible
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
            //creates and adds a player object to the playerList arraylist
            for (int i = 1;i <= NumOfPlayers;i++){
                playerList.add(new Player(i, playerSize));
            }
            //sets the current player to the first player
            currentPlayer = playerList.get(0);
            //paints every player's tile on the starting tile 
            paintEvent = "Paint Every Player";
            repaint();
            //current player icon (player obj) is to paint the current player next to the playerLabel jLabel
            currentPlayerIcon = new Player(1,50);
            currentPlayerIcon.setColor(playerList.get(0).getColor());
        }

        if(s.equals("Roll Die")){
            //GAME CODE
            //this runs a game round every loop until there is a winner
            if(winner == null){
                //sets the current player to be the next player only if it isnt the first turn of the game
                if(gameRound != 1 || playerTurn != 1){
                    currentPlayer = nextPlayer;
                }
                int nextPlayerIndex = (currentPlayer.getPlayerIndex() + 1) % playerList.size();
                nextPlayer = playerList.get(nextPlayerIndex);

                roundLabel.setText("Round: " + gameRound);

                //the player roles the die
                rollDie();

                //this moves the player to the new tile after the die was rolled
                currentPlayer.setCurrentTile(currentPlayer.getCurrentTile() + dieResult);
                paintEvent = "Paint Every Player";
                repaint();

                if(currentPlayer.getCurrentTile() < 100){
                    //for the following if statements
                    //Condition: if a snake / ladder was detected on the current square
                    //Code: show the button to move the player up ladder/down snake
                    //      also hide the button to roll die so players cannot skip going down a snake
                    if(tileList[Tile.getTileRow(currentPlayer.getCurrentTile())][Tile.getTileCol(currentPlayer.getCurrentTile())].detectSnake() != currentPlayer.getCurrentTile()){
                        movePlayer.setText("Slide Down Snake");
                        movePlayer.setVisible(true);
                        rollDie.setVisible(false);
                    }
                    else if(tileList[Tile.getTileRow(currentPlayer.getCurrentTile())][Tile.getTileCol(currentPlayer.getCurrentTile())].detectLadder() != currentPlayer.getCurrentTile()){
                        movePlayer.setText("Climb Ladder");
                        movePlayer.setVisible(true);
                        rollDie.setVisible(false);
                    }
                    else{
                        //if no ladder/snake was detected, ensures the move player button is still not visible
                        movePlayer.setVisible(false);

                        //draws the player next to the playerLabel that will move after the dice was rolled
                        if(currentPlayer.getPlayerIndex()+1 == playerList.size()){
                            currentPlayerIcon.setColor(playerList.get(0).getColor());
                        }
                        else{
                            //goes back to the first element of the arrayList
                            currentPlayerIcon.setColor(playerList.get(currentPlayer.getPlayerIndex() +1).getColor());
                        }
                    }
                }
                paintEvent = "Paint Every Player";

                //winning case 2: player on tile 100
                if(currentPlayer.getCurrentTile() == 100){
                    win();
                }
                playerTurn++;

                //detecting if it is the next round
                if(playerTurn > playerList.size()){
                    playerTurn = 1;
                    gameRound++;
                }
            }
        }
        if(s.equals("Slide Down Snake")){
            //player is repainted at the bottom of the snake
            currentPlayer.setCurrentTile(currentPlayer.detectSnake());
            repaint();
            movePlayer.setVisible(false);
            rollDie.setVisible(true);
            //draws the player next to the playerLabel that will move after the dice was rolled
            if(currentPlayer.getPlayerIndex()+1 == playerList.size()){
                currentPlayerIcon.setColor(playerList.get(0).getColor());
            }
            else{
                //goes back to the first element of the arrayList
                currentPlayerIcon.setColor(playerList.get(currentPlayer.getPlayerIndex() +1).getColor());
            }
        }
        if(s.equals("Climb Ladder")){
            //player is repainted at the top of the ladder
            currentPlayer.setCurrentTile(currentPlayer.detectLadder());
            repaint();
            movePlayer.setVisible(false);
            rollDie.setVisible(true);
            //draws the player next to the playerLabel that will move after the dice was rolled
            if(currentPlayer.getPlayerIndex()+1 == playerList.size()){
                currentPlayerIcon.setColor(playerList.get(0).getColor());
            }
            else{
                //goes back to the first element of the arrayList
                currentPlayerIcon.setColor(playerList.get(currentPlayer.getPlayerIndex() +1).getColor());
            }
        }
        if(s.equals("Show results")){
            //paints the winner player in the middle of the screen
            winnerIcon = new Player(winner.getPlayerIndex(),100);
            winnerIcon.setColor(winner.getColor());
            paintEvent = "Paint Winner Player";
            repaint();

            endPanel.setVisible(false);
            resultsPanel.setVisible(true);
        }
    }

    //winning screen: 
    public void win(){
        //this method runs when there is a winner detected
        winner = playerList.get(currentPlayer.getPlayerIndex());
  
        //GAME END PANEL: All code below is to create the components of the end screen
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

        //RESULTS PANEL: All code below is to create the components of the results screen
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
        //gets a random value from 1 to 6 inclusive and sets the result to the JLabel
        dieResult = (int)(Math.random()*6) + 1;
        dieResultLabel.setText("Die Result: " + dieResult);
    }

    //Abstract methods
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
