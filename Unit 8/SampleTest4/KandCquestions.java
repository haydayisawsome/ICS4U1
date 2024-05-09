public class KandCquestions {
    public static void main(String[]args){
        int[][] multiTable = toMultiplicationTable(3);
        print(multiTable);
        createArraySum();
    }
    public static int[][] toMultiplicationTable(int number){
        int[][] table = new int[number][number];
        for(int i = 0;i<number;i++){
            for(int j = 0;j<number;j++){
                table[i][j] = i*j;
            }
        }
        return table;
    }
    public static void print(int[][] list){
        for(int i = 0;i<list.length;i++){
            for(int j = 0;j<list[i].length;j++){
                System.out.print(list[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void createArraySum(){
        int[ ][ ]a=new int [3][3];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                a[i][j]=i+j;
                System.out.print(a[i][j]+ "   ");
            }
            System.out.println();
        }
    }
}
