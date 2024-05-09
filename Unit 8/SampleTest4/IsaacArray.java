public class IsaacArray {
    public static int[][] initGrid(int size){
        int[][] list = new int[size][size];
        for(int i = 0;i<list.length;i++){
            for(int j = 0;j<list[i].length;j++){
                list[i][j] = (int)(Math.random() * size) + 1;
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
    public static int[][] swapRow(int [][] list, int rowIndexA, int rowIndexB){
        int[] temp = list[rowIndexA];
        list[rowIndexA] = list[rowIndexB];
        list[rowIndexB] = temp;
        return list;
    }
    public static void print(int[][] list){
        for (int i = 0;i<list.length;i++){
            for (int j = 0;j<list[i].length;j++){
                System.out.print(list[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
class IsaaccTester {
    public static void main(String[] args) {
        System.out.println("Size: 3\nInitial Grid");
        int[][]list = IsaacArray.initGrid(3);
        IsaacArray.print(list);
        System.out.print("Product of elements in row 2: ");
        System.out.println(IsaacArray.rowProduct(list,2));
        System.out.println("After swapping row 0 to row 1");
        IsaacArray.swapRow(list,0,1);
        IsaacArray.print(list);
    }
}