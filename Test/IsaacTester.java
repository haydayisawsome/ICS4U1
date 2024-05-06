 class Isaac2DArray{
    public static int[][] initGrid(int size){
        int[][] list = new int[size][size];
        for (int i = 0;i<list.length;i++){
            for (int j = 0;j<list[i].length;j++){
                list[i][j] = (int)(Math.random()*size) + 1;
            }
        }
        return list;
    }
    public static int numEven (int[][] list){
        int sum = 0;
        for (int i = 0;i<list.length;i++){
            for (int j = 0;j<list[i].length;j++){
                if (list[i][j] % 2 == 0){
                    sum++;
                }
            }
        }
        return sum;
    }
    public static int rowProduct(int[][] list, int row){
        int product = 1;
        if (row > 0 && row < list[row].length){
            for (int i = 0;i<list[row].length;i++){
                product *= list[row][i];
            }
        }
        else {
            product = -1;
        }
        return product;
    }
    public static int colProduct(int[][] list, int col){
        int product = 1;
        if (col > 0 && col < list.length){
            for (int i = 0;i<list.length;i++){
                product *= list[i][col];
            }
        }
        else {
            product = -1;
        }
        return product;
    }
    public static int[][] swapRow(int [][] list, int rowIndexA, int rowIndexB){
        int[] temp = list[rowIndexA];
        list[rowIndexA] = list[rowIndexB];
        list[rowIndexB] = temp;
        return list;
    }
    public static void printArray(int[][] list){
        for (int i = 0;i<list.length;i++){
            for (int j = 0;j<list[i].length;j++){
                System.out.print(list[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
public class IsaacTester {
    public static void main(String[] args) {
        Isaac2DArray obj = new Isaac2DArray();
        System.out.println("Size\n3\nInitial Grid");
        int[][]list = Isaac2DArray.initGrid(3);
        Isaac2DArray.printArray(list);
        System.out.println("Product of elements in row 2(index 1)");
        System.out.println(Isaac2DArray.rowProduct(list,1));
        System.out.println("Product of elements in column 2(index 1)");
        System.out.println(Isaac2DArray.colProduct(list,1));
        System.out.println("After swapping row 0 to row 1");
        Isaac2DArray.swapRow(list,0,1);
        Isaac2DArray.printArray(list);
    }
}