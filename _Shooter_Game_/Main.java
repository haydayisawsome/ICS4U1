package _Shooter_Game_;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.geom.*;
import java.util.ArrayList;

public class Main extends Frame implements ActionListener, WindowListener, MouseListener, KeyListener{
    static String event = "";
    static int frameWidth = 1000;
    static int frameHeight = 700;
    static int borderThickness = 5;

    static final int topFrameStartPos = 29; 
    static final int leftFrameStartPos = 6;

    PointerInfo a = MouseInfo.getPointerInfo();
    Point b;
    int x;
    int y;

    Timer timer;
    AffineTransform transform = new AffineTransform();
    Button start;
    int fps = 18;
    Rectangle gun;
    Boolean mouseExited = false;
    Font title;
    Font defaultFont;

    int playerDiameter = 100;
    int playerSpeed = 5;
    int playerVelX = 0;
    int playerVelY = 0;
    int playerPosX = 100 + leftFrameStartPos - playerDiameter/2; //starting position
    int playerPosY = frameHeight + playerDiameter/2; //starting position

    int gunWidth = 20; // Adjust as needed
    int gunHeight = 60; // Adjust as needed
    Boolean gunShoot = false; //to see when gun is fired on mouse pressed
    double gunAngle = 0;

    int ammoDiameter = 10;
    int ammoSpeed = 50;
    ArrayList<Ammo> ammoList = new ArrayList<>();

    public static void main (String[]args){
        Main m = new Main();
        m.setSize(frameWidth + borderThickness*3 + leftFrameStartPos,frameHeight + borderThickness*3 + topFrameStartPos);
        m.setVisible(true); 
        m.addWindowListener(m);
    }
    public Main(){
        setLayout(null);
        timer = new Timer(1000/fps, this); // 10 milliseconds delay
        //title screen
        int startButtonWidth = 200;
        int startButtonHeight = 80;
        event = "title screen";
        start = new Button("START");
        start.setBounds(frameWidth/2-startButtonWidth/2,500-startButtonHeight/2,startButtonWidth,startButtonHeight);
        add(start);
        start.addActionListener(this);
        addKeyListener(this);
        addMouseListener(this);
        requestFocus();
        setFocusable(true);

        //game
        timer.start(); // Start the timer
        timer.addActionListener(this);
        timer.setRepeats(true);
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

            defaultFont = g.getFont();
            title = defaultFont.deriveFont(defaultFont.getSize() * 8F);
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
        else if (event.equals("game") && mouseExited == false){
            
            //drawing game background
            g.setColor(Color.CYAN);
            g.fillRect(leftFrameStartPos,topFrameStartPos,frameWidth + borderThickness*2,frameHeight + borderThickness*2);

            // Iterating through the entire ammo list to draw each ammo object
            g.setColor(Color.YELLOW);
            for (Ammo i : ammoList){
                g.fillOval(i.getPosX(),i.getPosY(),i.getSize(),i.getSize());
            }

            //drawing player
            g.setColor(Color.BLACK);
            g.fillOval(playerPosX - playerDiameter/2, playerPosY - playerDiameter/2, playerDiameter, playerDiameter);
            g.setColor(Color.CYAN);
            g.fillOval(playerPosX - playerDiameter/2 + 10, playerPosY - playerDiameter/2 +10, playerDiameter-20, playerDiameter-20);

            // Calculating gun position/direction
            gunAngle = Math.toRadians(findGunAngle());
            gun = new Rectangle((int) (playerPosX - gunWidth / 2), (int) (playerPosY - playerDiameter / 2), gunWidth, gunHeight);
            AffineTransform rotation = AffineTransform.getRotateInstance(gunAngle, playerPosX, playerPosY);
            Shape rotatedGunRect = rotation.createTransformedShape(gun);

            // Drawing the rotated gun rectangle
            g.setColor(Color.RED);
            g2.fill(rotatedGunRect);
            if(gunShoot == true){
                fireAmmo();
            }
        }
        else if (event.equals("game") && mouseExited == true){
            g.setColor(Color.GRAY);
            g.fillRect(leftFrameStartPos,topFrameStartPos,frameWidth + borderThickness*2,frameHeight + borderThickness*2);
            g.setFont(title);
            g.setColor(Color.BLACK);
            g.drawString("GAME PAUSED", frameWidth/2 - 350, 300);
            g.setFont(defaultFont);
            g.drawString("Your mouse is outside of the window", frameWidth/2 - 100, 400);
        }

        updateAmmo(); //this has to be at the bottom for the paint to work on the frame
    }

    // Method to handle firing the ammo
    public void fireAmmo() {
        int ammoPosX = playerPosX;
        int ammoPosY = playerPosY;
        int ammoSize = ammoDiameter;
        int ammoSpeed = this.ammoSpeed;

        Ammo newAmmo = new Ammo(ammoPosX - ammoSize/2, ammoPosY - ammoSize/2, findGunAngle(), ammoSize, ammoSpeed);
        ammoList.add(newAmmo);
    }
    public void updateAmmo() {
        // Create a copy of the ammoList to avoid ConcurrentModificationException
        // There will be an error if you try to change the main array list when it is being changed
        ArrayList<Ammo> copy = new ArrayList<>(ammoList);
    
        // Iterate over the copied list and update ammo positions
        for (Ammo ammo : copy) {
            int newPosX = (int) (ammo.getPosX() + Math.cos(Math.toRadians(ammo.getAngle())) * ammo.getSpeed());
            int newPosY = (int) (ammo.getPosY() + Math.sin(Math.toRadians(ammo.getAngle())) * ammo.getSpeed());
            ammo.setPosX(newPosX);
            ammo.setPosY(newPosY);
    
            // Add collision detection
    
            // Deleting ammo if it passes the frame border
            if (ammoList.size() > 20) {
                ammoList.remove(ammo);
            }
        }
    }
    
    public double findGunAngle(){ 
        double mouseXPos = 0;
        double mouseYPos = 0;
        if(getMousePosition() != null){
            mouseXPos = getMousePosition().getX();
            mouseYPos = getMousePosition().getY();
        }
        double changeOfX = mouseXPos - playerPosX;
        double changeOfY = mouseYPos - playerPosY;
        double angle = Math.atan(changeOfY/changeOfX);
    
        // Convert angle to degrees
        angle = Math.toDegrees(angle);
        angle += 90;
        
        if(changeOfX < 0){
            angle+= 180;
        }
        return angle;
    }

    public void checkTopBoundary(){
        if (playerPosY <= 81) {
            playerPosY = 81;
        } 
    }
    public void checkBottomBoundary(){
        if (playerPosY >= 686) {
            playerPosY = 686;
        }
    }
    public void checkLeftBoundary(){
        if (playerPosX <= 58) {
            playerPosX = 58;
        } 
    }
    public void checkRightBoundary(){
        if (playerPosX >= 963) {
            playerPosX = 963;
        }
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == timer) {
            // Update paint only if the event is from the timer and the game has started
            if (event.equals("game") && mouseExited == false) {
                // Update player position based on velocity
                playerPosX += playerVelX;
                playerPosY += playerVelY;
    
                // Check boundaries
                checkTopBoundary();
                checkBottomBoundary();
                checkLeftBoundary();
                checkRightBoundary();

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
    public void mousePressed(MouseEvent e){
        gunShoot = true;
    }
    public void mouseReleased(MouseEvent e){
        gunShoot = false;
    }
    public void mouseExited(MouseEvent e){
        mouseExited = true;
        repaint();
    }
    public void mouseEntered(MouseEvent e){
        mouseExited = false;
        repaint();
    }
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
