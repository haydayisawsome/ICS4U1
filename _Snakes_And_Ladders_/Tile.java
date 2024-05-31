public class Tile {
    private int Xpos;
    private int Ypos;
    private int tileNum;
    private int newTile;

    public Tile(int tileNum,int Xpos,int Ypos){
        this.tileNum = tileNum;
        this.Xpos = Xpos;
        this.Ypos = Ypos;
    }
    public void setXpos(int newXpos){
        Xpos = newXpos;
    }
    public void setYpos(int newYpos){
        Ypos = newYpos;
    }
    public int getXpos(){
        return Xpos;
    }
    public int getYpos(){
        return Ypos;
    }
    public int getTileNum(){
        return tileNum;
    }
    public int detectSnake(){
        //Snake tiles
        if(tileNum == 28){
            newTile = 10;
        }
        else if(tileNum == 37){
            newTile = 3;
        }
        else if(tileNum == 48){
            newTile = 16;
        }
        else if(tileNum == 75){
            newTile = 32;
        }
        else if(tileNum == 94){
            newTile = 71;
        }
        else if(tileNum == 96){
            newTile = 42;
        }

        else {
            newTile = tileNum;
        }
        return newTile;
    }
    public int detectLadder(){
        //Ladder tiles
        if(tileNum == 4){
            newTile = 56;
        }
        else if(tileNum == 12){
            newTile = 50;
        }
        else if(tileNum == 14){
            newTile = 55;
        }
        else if(tileNum == 22){
            newTile = 58;
        }
        else if(tileNum == 41){
            newTile = 79;
        }
        else if(tileNum == 54){
            newTile = 88;
        }

        else {
            newTile = tileNum;
        }
        return newTile;
    }
    public static int getTileRow(int tile){
        if(tile >= 91){
            return 0;
        }
        else if(tile >= 81){
            return 1;
        }
        else if(tile >= 71){
            return 2;
        }
        else if(tile >= 61){
            return 3;
        }
        else if(tile >= 51){
            return 4;
        }
        else if(tile >= 41){
            return 5;
        }
        else if(tile >= 31){
            return 6;
        }
        else if(tile >= 21){
            return 7;
        }
        else if(tile >= 11){
            return 8;
        }
        else{
            return 9;
        }
    }
    public static int getTileCol(int tile){
        if(getTileRow(tile) % 2 == 1){
            return tile - (10-getTileRow(tile) - 1)*10 - 1;
        }
        else{
            return 9 - (tile - (10-getTileRow(tile)-1)*10) + 1;
        }
    }
}