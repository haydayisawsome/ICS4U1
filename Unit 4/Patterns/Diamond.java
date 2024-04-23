public class Diamond{
    public static void main(String[]args){
        for (int i = -4;i<=4;i++){
            for (int s = 1;s <= Math.abs(i);s++){
                System.out.print(" ");
            }
            for (int t = 1;t <= (1+(2*(4-Math.abs(i))));t++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}