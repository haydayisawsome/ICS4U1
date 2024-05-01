package _Shooter_Game_;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends Frame implements ActionListener, WindowListener, MouseListener, KeyListener{
    static String event = "";
    static int frameWidth = 1000;
    static int frameHeight = 700;
    static int borderThickness = 5;

    static final int topFrameStartPos = 29;
    static final int leftFrameStartPos = 6;

    Button start;

    PointerInfo a = MouseInfo.getPointerInfo();
    Point b;
    int x;
    int y;

    int playerPosX = 100 + leftFrameStartPos; //starting position
    int playerPosY = frameHeight / 2 + topFrameStartPos; //starting position
    int playerDiameter = 100;
    int playerSpeed = 5;
    int playerVelX = 0;
    int playerVelY = 0;

    Timer timer;

    public static void main (String[]args){
        Main m = new Main();
        m.setSize(frameWidth + borderThickness*3 + leftFrameStartPos,frameHeight + borderThickness*3 + topFrameStartPos);
        m.setVisible(true); 
        m.addWindowListener(m);
    }
    public Main(){
        setLayout(null);
        timer = new Timer(20, this); // 5 milliseconds delay
        //title screen
        int startButtonWidth = 200;
        int startButtonHeight = 80;
        event = "title screen";
        start = new Button("START");
        start.setBounds(frameWidth/2-startButtonWidth/2,500-startButtonHeight/2,startButtonWidth,startButtonHeight);
        add(start);
        start.addActionListener(this);
        addKeyListener(this);
        requestFocus();
        setFocusable(true);
        timer.start(); // Start the timer
        timer.addActionListener(this);
        timer.setRepeats(true);
        //game
        //die screen
    }

    public void paint (Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        
        if (event.equals("title screen")){
            g.setColor(Color.BLACK);
            g.fillRect(leftFrameStartPos,topFrameStartPos,frameWidth + borderThickness*2,frameHeight + borderThickness*2);
            g.setColor(Color.GRAY);
            g.fillRect(leftFrameStartPos+borderThickness,topFrameStartPos+borderThickness,frameWidth,frameHeight);

            Font currentFont = g.getFont();
            Font title = currentFont.deriveFont(currentFont.getSize() * 8F);
            g.setFont(title);
            g.setColor(Color.BLUE);
            g.drawString("Shooter Game", frameWidth/2 - 300, 300);

            g.setColor(Color.BLACK);
            g.fillOval(frameWidth/2 - 400,350,100,100);
            g.setColor(Color.GRAY);
            g.fillOval(frameWidth/2 - 400+12,350+12,76,76);
            g2.setStroke(new BasicStroke(7));
            g.setColor(Color.BLACK);
            g2.drawLine(frameWidth/2-400+90,350,400,500);
        }
        else if (event.equals("game")){
            g.setColor(Color.CYAN);
            g.fillRect(leftFrameStartPos,topFrameStartPos,frameWidth + borderThickness*2,frameHeight + borderThickness*2);
            
            g.setColor(Color.BLACK);
            g.fillOval(playerPosX - playerDiameter/2, playerPosY - playerDiameter/2, playerDiameter, playerDiameter);
            g.setColor(Color.CYAN);
            g.fillOval(playerPosX - playerDiameter/2 + 10, playerPosY - playerDiameter/2 +10, playerDiameter-20, playerDiameter-20);
        }
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == timer) {
            // Update paint only if the event is from the timer and the game has started
            if (event.equals("game")) {
                // Update player position based on velocity
                playerPosX += playerVelX;
                playerPosY += playerVelY;
    
                // Check boundaries
                if (playerPosX <= 0) {
                    playerPosX = 0;
                } 
                else if (playerPosX >= leftFrameStartPos + frameWidth - playerDiameter) {
                    playerPosX = leftFrameStartPos + frameWidth - playerDiameter;
                }
                else if (playerPosY <= 0) {
                    playerPosY = 0;
                } 
                else if (playerPosY >= topFrameStartPos + frameHeight - playerDiameter) {
                    playerPosY = topFrameStartPos + frameHeight - playerDiameter;
                }
                repaint();
            }
        }
        else {
            // Handle other action events
            String s = e.getActionCommand();
            if (s.equals("START")) {
                event = "game";
                start.setVisible(false);
            }
        }
    }

    public void mouseClicked(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseMoved(MouseEvent e){
        //get mouse location
        b = a.getLocation();
        x = (int) b.getX();
        y = (int) b.getY();
    }
    public void mouseDragged(MouseEvent e){}

    public void keyPressed(KeyEvent e){
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_D){
            playerVelX = playerSpeed;
        }
        else if (c == KeyEvent.VK_A){
            playerVelX = -playerSpeed;
        }
        else if (c == KeyEvent.VK_W){
            playerVelY = -playerSpeed;
        }
        else if (c == KeyEvent.VK_S){
            playerVelY = playerSpeed;
        }
    }
    public void keyReleased(KeyEvent e){
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_D || c == KeyEvent.VK_A){
            playerVelX = 0;
        }
        if (c == KeyEvent.VK_W || c == KeyEvent.VK_S){
            playerVelY = 0;
        }
    }
    public void keyTyped(KeyEvent e){}
    
    public void windowClosing(WindowEvent e) {
        // Exit the application when the window is closed
        System.exit(0);
    }
    public void windowOpened(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
}
