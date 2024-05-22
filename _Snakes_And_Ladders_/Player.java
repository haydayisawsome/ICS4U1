import java.awt.Color;

public class Player {
    private Color playerColor;
    private int playerNum;
    private int currentTile;

    public Player(int playerNum){
        this.playerNum = playerNum;
        //class Color Source: https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html
        playerColor = new Color(getRandomColor(),getRandomColor(),getRandomColor());
        currentTile = 1;
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
}
