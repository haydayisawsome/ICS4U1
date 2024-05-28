import java.awt.*;

public class Player extends Main {
    private Color playerColor;
    private int playerNum;
    private int currentTile = 1;
    private int playerSize;

    public Player(int playerNum, int playerSize){
        this.playerNum = playerNum;
        //class Color Source: https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html
        playerColor = new Color(getRandomColor(),getRandomColor(),getRandomColor());
        this.playerSize = playerSize;
    }

    public int getRandomColor(){
        return (int)(Math.random()*254) + 1;
    }
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
    public void paint(Graphics g){
        g.setColor(playerColor);
        g.fillOval(tileList[Tile.getTileRow(currentTile)][Tile.getTileCol(currentTile)].getXpos() + (3-playerNum)*5,tileList[Tile.getTileRow(currentTile)][Tile.getTileCol(currentTile)].getYpos(),playerSize,playerSize);
    }
    public void paint(Graphics g,int Xpos, int Ypos){
        g.setColor(playerColor);
        g.fillOval(Xpos,Ypos,playerSize,playerSize);
    }
}
