/**
 * Author:  Isaac Man
 * Date:    May 17, 2024
 * Subject: Unit 4 test (ArrayList and 2D Arrays)
 */

import java.util.Scanner;
class IsaacArray{
    public static int[][] initGrid(int r, int c){
        int[][] list = new int[r][c];
        for(int i = 0;i<list.length;i++){
            for (int j = 0;j<list[i].length;j++){
                list[i][j] = (int)(Math.random()*10) + 1;
            }
        }
        return list;
    }
    public static boolean found(int[][] list,int item){
        boolean result = false;
        for(int i = 0;i<list.length;i++){
            for (int j = 0;j<list[i].length;j++){
                if(list[i][j] == item){
                    result = true;
                }
            }
        }
        return result;
    }
    public static int colProduct(int[][] list,int columnIndex){
        int result = 1;
        try{
            for(int i = 0;i<list.length;i++){
                result *= list[i][columnIndex];
            }
        }
        catch(Exception e){
            result = -1;
        }
        return result;
    }
    public static double rowAverage(int[][] list,int rowIndex){
        double result;
        double sum = 0;
        try{
            for(int i = 0;i<list[rowIndex].length;i++){
                sum+=list[rowIndex][i];
            }
            result = (sum/list[rowIndex].length);
        }
        catch(Exception e){
            result = -1;
        }
        return result;
    }
    public static int[][] swapCol(int[][] list,int colIndexA, int colIndexB){
        int temp;
        for(int i = 0;i<list.length;i++){
            temp = list[i][colIndexA];
            list[i][colIndexA] = list[i][colIndexB];
            list[i][colIndexB] = temp;
        }
        return list;
    }
    public static void print(int[][] list){
        for(int i = 0;i<list.length;i++){
            for (int j = 0;j<list[i].length;j++){
                System.out.print(list[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
public class ArrayTester extends IsaacArray{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns:(Use Scanner class)");
        System.out.print("r = ");
        int r = sc.nextInt();
        System.out.print("c = ");
        int s = sc.nextInt();
        System.out.println("Initial grid:");
        int[][] list = initGrid(r,s);
        print(list);
        System.out.println("8 is in array: " + found(list,8));
        System.out.println("3 is in array: " + found(list,3));
        System.out.println("Product of elements in column with index 2  is: " + colProduct(list,2));
        System.out.println("Average of elements in row with index 2 is: " + String.format("%.2f",rowAverage(list,2)));
        System.out.println("Grid after swapping columns with index 1 and index 2:");
        print(swapCol(list,1,2));
    }
}