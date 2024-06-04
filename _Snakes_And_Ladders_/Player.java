import java.awt.*;

public class Player extends Main {
    //instance variables for every player object
    private Color playerColor;
    private int playerNum;
    private int currentTile = 1;
    private int playerSize;

    // overloaded constructor
    public Player(int playerNum, int playerSize){
        this.playerNum = playerNum;
        //class Color Source: https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html
        //this line will generate a random colour for every player
        playerColor = new Color(getRandomColor(),getRandomColor(),getRandomColor());
        this.playerSize = playerSize;
    }

    //i made a seperate method to generate the random number for each rgb value for readability
    public int getRandomColor(){
        return (int)(Math.random()*254) + 1;
    }

    //setters and getters for class attributes
    public Color getColor(){
        return playerColor;
    }
    public void setColor(Color color){
        playerColor = color;
    }
    public int getCurrentTile(){
        return currentTile;
    }
    public void setCurrentTile(int currentTile){
        this.currentTile = currentTile;
    }
    public int getPlayerIndex(){
        return playerNum - 1;
    }
    public void setSize(int size){
        playerSize = size;
    }

    //two paint methods for different purposes
    //1. method to paint the player at its current tile 
    public void paint(Graphics g){
        g.setColor(playerColor);
        g.fillOval(tileList[Tile.getTileRow(currentTile)][Tile.getTileCol(currentTile)].getXpos() + (5-playerNum)*3,tileList[Tile.getTileRow(currentTile)][Tile.getTileCol(currentTile)].getYpos(),playerSize,playerSize);
    }
    //2. method to paint the player at a specified position
    public void paint(Graphics g,int Xpos, int Ypos){
        g.setColor(playerColor);
        g.fillOval(Xpos,Ypos,playerSize,playerSize);
    }

    //methods to return a new tile if the current tile is a snake/ladder (through player object)
    public int detectSnake(){
        int newTile;
        //Snake tiles
        if(currentTile == 28){
            newTile = 10;
        }
        else if(currentTile == 37){
            newTile = 3;
        }
        else if(currentTile == 48){
            newTile = 16;
        }
        else if(currentTile == 75){
            newTile = 32;
        }
        else if(currentTile == 94){
            newTile = 71;
        }
        else if(currentTile == 96){
            newTile = 42;
        }

        //returns the same tile if no snake was found
        else {
            newTile = currentTile;
        }
        return newTile;
    }
    public int detectLadder(){
        //Ladder tiles
        int newTile;
        if(currentTile == 4){
            newTile = 56;
        }
        else if(currentTile == 12){
            newTile = 50;
        }
        else if(currentTile == 14){
            newTile = 55;
        }
        else if(currentTile == 22){
            newTile = 58;
        }
        else if(currentTile == 41){
            newTile = 79;
        }
        else if(currentTile == 54){
            newTile = 88;
        }

        //returns the same tile if no ladder was found
        else {
            newTile = currentTile;
        }
        return newTile;
    }
}
