//Question 4 and 5
public class My2DAlgorithms {
    public static void main(String[]args){
        int[][] list = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] list2 = {{4,9,2},{3,5,7},{8,1,6}};
        int[][] list3 = {{1,2,3},{0,4,5},{0,0,6}};
        print(list);
        print(list2);
        print(list3);
        System.out.println(rowSum(list,1));
        System.out.println(colSum(list,1));
        print(rowSumArray(list));
        print(colSumArray(list));
        System.out.println(diagonalSumRight(list));
        System.out.println(diagonalSumLeft(list));
        System.out.println(isMagic(list)); //
        System.out.println(isMagic(list2)); //
        System.out.println(rowMax(list2,0));
        System.out.println(colMax(list2,0));
        System.out.println(isUpper(list2)); //
        System.out.println(isUpper(list3)); //
    }
    public static int rowSum(int[][] list, int row){
        int sum = 0;
        for (int i = 0; i<list[row].length;i++){
            sum += list[row][i];
        }
        return sum;
    }
    public static int colSum(int[][] list, int col){
        int sum = 0;
        for (int i = 0;i<list.length;i++){
            sum += list[i][col];
        }
        return sum;
    }
    public static int[] rowSumArray(int[][] list){
        int[] sums = new int[list.length];
        for (int i = 0;i<list.length;i++){
            sums[i] = rowSum(list,i);
        }
        return sums;
    }
    public static int[] colSumArray(int[][] list){
        int[] sums = new int[list[0].length];
        for (int i = 0;i<list[0].length;i++){
            sums[i] = colSum(list,i);
        }
        return sums;
    }
    public static int diagonalSumRight(int[][] list){
        int sum = 0;
        for (int i = 0;i<list.length;i++){
            for (int j = list[i].length - 1;j>=0;j--){
                if (i == list[i].length - j - 1){
                    sum += list[i][j];
                }
            }
        }
        return sum;
    }
    public static int diagonalSumLeft(int[][] list){
        int sum = 0;
        for (int i = 0;i<list.length;i++){
            for (int j = 0;j<list[i].length;j++){
                if (i == j){
                    sum += list[i][j];
                }
            }
        }
        return sum;
    }
    public static boolean isMagic(int[][] list){
        int sum = diagonalSumLeft(list);
        boolean result = true;

        if (sum != diagonalSumRight(list)){
            result = false;
        }
        
        int[] sumOfEachCols = colSumArray(list);
        for (int i = 0;i<sumOfEachCols.length;i++){
            if (sumOfEachCols[i] != sum){
                result = false;
            }
        }

        int[] sumOfEachRow = rowSumArray(list);
        for (int i = 0;i<sumOfEachRow.length;i++){
            if (sumOfEachRow[i] != sum){
                result = false;
            }
        }

        return result;
    }
    public static int rowMax(int[][]list, int row){
        int max = list[row][0];
        for (int i = 0;i<list[row].length;i++){
            if(list[row][i] > max){
                max = list[row][i];
            }
        }
        return max;
    }
    public static int colMax(int[][] list, int col){
        int max = list[0][col];
        for (int i = 0;i<list.length;i++){
            if (list[i][col] > max){
                max = list[i][col];
            }
        }
        return max;
    }
    public static boolean isUpper(int[][]list){
        boolean result = true;
        int diagonalIndex = 0;
        for (int i = 0;i<list.length;i++){
            diagonalIndex = i;
            for (int j = 0;j<list[i].length;j++){
                if(i < diagonalIndex || j<diagonalIndex){
                    if(list[i][j] != 0){
                        result = false;
                    }
                }
            }
        }
        return result;
    }
    public static void print(int[][] list){
        for (int i = 0;i<list.length;i++){
            for (int j = 0;j<list[i].length;j++){
                System.out.print(list[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void print(int[] list){
        for (int i = 0;i<list.length;i++){
            System.out.print(list[i] + "\t");
        }
        System.out.println();
    }
}
