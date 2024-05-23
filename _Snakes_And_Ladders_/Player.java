import java.awt.*;

public class Player extends Main {
    private Color playerColor;
    private int playerNum;
    private int currentTile;
    private int playerSize;

    public Player(int playerNum, int playerSize){
        this.playerNum = playerNum;
        //class Color Source: https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html
        playerColor = new Color(getRandomColor(),getRandomColor(),getRandomColor());
        currentTile = 5;
    }
    public Color getPlayerColor(){
        return playerColor;
    }
    public int getRandomColor(){
        return (int)(Math.random()*254) + 1;
    }
    public int getCurrentTile(){
        return currentTile;
    }
    public void setCurrentTile(int currentTile){
        this.currentTile = currentTile;
    }
    public int getPlayerNum(){
        return playerNum;
    }
    public void paint(Graphics g){
        g.setColor(playerColor);
        System.out.println(Tile.getTileRow(currentTile));
        System.out.println(Tile.getTileCol(currentTile));
        g.fillOval(tileList[Tile.getTileRow(currentTile)][Tile.getTileCol(currentTile)].getXpos(),tileList[Tile.getTileRow(currentTile)][Tile.getTileCol(currentTile)].getYpos(),playerSize,playerSize);
        System.out.println(playerColor);
    }
}
