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
    public Color getPlayerColor(){
        return playerColor;
    }
    public int getRandomColor(){
        return (int)(Math.random()*254) + 1;
    }
    public Color getColor(){
        return playerColor;
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
        if(playerSize == 30){
            g.setColor(playerColor);
            System.out.println(Tile.getTileRow(currentTile));
            System.out.println(Tile.getTileCol(currentTile));
            g.fillOval(tileList[Tile.getTileRow(currentTile)][Tile.getTileCol(currentTile)].getXpos() + (3-playerNum)*5,tileList[Tile.getTileRow(currentTile)][Tile.getTileCol(currentTile)].getYpos(),playerSize,playerSize);
            System.out.println(playerColor);
        }
        else if(playerSize == 50){
            g.setColor(playerColor);
            g.fillOval(600,100,playerSize,playerSize);
        }
    }
}
