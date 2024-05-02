public class MajorOrders{
    public static void main(String[]args){
        char[][] ch = {{'a','b','c'},{'d','e','f'},{'g','h','i'}};

        //printing in row major
        for (int i = 0;i<ch.length;i++){
            for (int j = 0;j<ch[i].length;j++){
                System.out.print(ch[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        //printing in column major order
        for (int i = 0;i<ch[0].length;i++){
            for (int j = 0;j<ch.length;j++){
                System.out.print(ch[j][i] + "\t");
            }
            System.out.println();
        }
    }
}