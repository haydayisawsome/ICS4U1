/*
 * Author:  Isaac Man
 * Date:    May 3, 2024
 * Subject: Two dimensional array algorithms
 */

public class TwoDAlgorithms{
    public static void main(String[]args){
        int[][]a = {{2,4,6},{8,10,12},{1,2,3}};
        System.out.printf("Average = %.2f",average(a));
        System.out.println();
    }

    //three print methods for int/double/string 2d arrays
    public static void print(int[][]a){
        for (int i = 0; i < a.length;i++){
            for (int j = 0; j<a[i].length;j++){
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void print(String[][]a){
        for (int i = 0; i < a.length;i++){
            for (int j = 0; j<a[i].length;j++){
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void print(double[][]a){
        for (int i = 0; i < a.length;i++){
            for (int j = 0; j<a[i].length;j++){
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //average of elements of a 2d array
    public static double average(int[][]a){
        int sum = 0;
        for (int i = 0;i<a.length;i++){
            for (int j = 0;j<a[i].length;j++){
                sum += a[i][j];
            }
        }
        double average = (double)sum/(a.length * a[0].length);
        return average;
    }
}