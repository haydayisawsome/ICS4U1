/*
 * Author:  Isaac Man
 * Date:    May 2, 2023
 * Subject: Testing two dimensional objects in 2d arrays
 */

public class TwoDObjectTester {
    public static void main(String[]args){
        TwoDObjects[][] obj = new TwoDObjects[10][10];
        for (int i = 0; i < obj.length;i++){
            for (int j = 0; j <obj[i].length;j++){
                obj[i][j] = new TwoDObjects(i,j);
                System.out.print(obj[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < obj[0].length;i++){
            for (int j = 0; j < obj.length ; j++){
                obj[i][j] = new TwoDObjects(i,j);
                System.out.print(obj[j][i] + "\t");
            }
            System.out.println();
        }
    }
    
}
class TwoDObjects{
    //instance variables
    private int x;
    private int y;
    
    //overloaded constructor
    public TwoDObjects(int x,int y){
        this.x = x;
        this.y = y;
    }

    //toString method
    public String toString(){
        return "(" + x + "," + y + ")";
    }
}