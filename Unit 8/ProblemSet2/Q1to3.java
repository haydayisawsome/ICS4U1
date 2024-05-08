public class Q1to3 {
    public static void main(String[] args) {
        int[][] values = new int[4][5];
        int[][] matrix = new int[5][5];

        // Question 1:
        for(int i = 0;i < values.length;i++){
            for (int j = 0;j<values[0].length;j++){
                values[i][j] = j+1;
            }
        }
        print(values);

        // Question 2:
        for (int i = 0; i < values.length;i++){
            for (int j = 0;j<values[0].length;j++){
                values[i][j] = i+j;
            }
        }
        print(values);

        // Question 3: 
        for (int i = 0;i<matrix.length;i++){
            for (int j = 0;j<matrix[0].length;j++){
                if (i == j){
                    matrix[i][j] = i+1;
                }
            }
        }
        print(matrix);
    }
    
    public static void print(int[][]list){
        for (int i = 0;i<list.length;i++){
            for (int j = 0;j<list[i].length;j++){
                System.out.print(list[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
