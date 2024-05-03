/*
 * Author:  Isaac Man
 * Date:    May 3, 2024
 * Subject: Two dimensional array algorithms
 */

public class TwoDAlgorithms{
    public static void main(String[]args){
        int[][]a = {{2,4,6},{8,10,12},{1,2,3}};

        //calling the average method
        System.out.printf("Average = %.2f",average(a));
        System.out.println();

        //printing array a
        print(a);
        System.out.println();

        //calling maximum method
        System.out.println("Max = " + maximum(a));

        //calling minimum method
        System.out.println("Min = " + minimum(a));

        //calling printOneRow method
        printOneRow(a, 2);
        System.out.println("\n");

        //calling swap method
        System.out.println("Swapping with row one and two");
        swapRows(a,1,2);
        print(a);

        System.out.println("Swapping with column one and two");
        swapColumns(a, 1, 2);
        print(a);
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

    //maximum and minimum methods
    public static int maximum(int[][]a){
        int max = a[0][0];
        for (int i = 0;i<a.length;i++){
            for (int j = 0;j<a[i].length;j++){
                if (a[i][j] > max){
                    max = a[i][j];
                }
            }
        }
        return max;
    }

    public static int minimum(int[][]a){
        int min = a[0][0];
        for (int i = 0;i<a.length;i++){
            for (int j = 0;j<a[i].length;j++){
                if (a[i][j] < min){
                    min = a[i][j];
                }
            }
        }
        return min;
    }

    //printing one row method
    public static void printOneRow(int[][]a, int row){
        for (int i= 0;i<a.length;i++){
            System.out.print(a[row][i] + "\t");
        }
    }

    //swap method
    public static int[][] swapRows (int[][]a, int rowAIndex, int rowBIndex){
        int[] temp = a[rowAIndex];
        a[rowAIndex] = a[rowBIndex];
        a[rowBIndex] = temp;
        return a;
    }

    public static int[][] swapColumns(int[][]a,int colAIndex, int colBIndex){
        for (int i = 0;i<a.length;i++){
            int temp = a[i][colAIndex];
            a[i][colAIndex] = a[i][colBIndex];
            a[i][colBIndex] = temp;
        }
        return a;
    }
}