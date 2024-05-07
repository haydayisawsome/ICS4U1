public class TwoDAlgorithms2 {
    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        //calling average of row method
        print(a);
        System.out.println("Average = " + averageOfRow(a,1));
        //calling average of col method
        System.out.println("Average = " + averageOfCol(a,1));
        //calling sumOfDiagonal method
        System.out.println("Sum of diagonal" + sumOfDiagonal(a));
        //calling search2 method
        int[]p = search2(a,5);
        for (int i = 0;i<p.length;i++){
            System.out.print(p[i]);
        }
    }
    public static double averageOfRow(int[][]a,int rowIndex){
        int sum = 0;
        double average;
        for (int i = 0;i<a[0].length;i++){
            sum = sum + a[rowIndex][i];
        }
        average = sum * 1.0 / a[0].length;
        // you can either cast it to double or multiply by 1.0 to convert into to double
        return average;
    }
    public static void print(int[][]a){
        for (int i = 0;i<a.length;i++){
            for (int j = 0;j<a[i].length;j++){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
    public static double averageOfCol(int[][]a, int colIndex){
        int sum = 0;
        double average;
        for (int i = 0; i<a.length;i++){
            sum = sum + a[i][colIndex];
        }
        average = sum * 1.0 / a.length;
        return average;
    }

    //sum of Diagonal method for a square 2D array
    public static int sumOfDiagonal(int[][]a){
        int sum = 0;
        for (int i = 0;i<a.length;i++){
            for (int j = 0;j<a.length;j++){
                if (i == j){
                    sum += a[i][j];
                }
            }
        }
        return sum;
    }

    //search method
    public static String search(int[][]a, int item){
        String found = "not found";
        for (int i = 0;i<a.length;i++){
            for (int j = 0;j<a[i].length;j++){
                if (a[i][j] == item){
                    found = "Found at [" + i + "][" + j + "]";
                }
            }
        }
        return found;
    }

    //search2 method returns the position of an item
    public static int[] search2(int[][]a,int item){
        int[]position = {-1,-1};
        for (int i = 0;i<a.length;i++){
            for (int j = 0;j<a[i].length;j++){
                if(a[i][j] == item){
                    position[0] = i;
                    position[1] = j;
                }
            }
        }
        return position;
    }
}
