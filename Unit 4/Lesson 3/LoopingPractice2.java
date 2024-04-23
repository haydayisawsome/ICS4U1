import java.util.Scanner;
public class LoopingPractice2{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        
        System.out.print("\nMultiples of "+num+" are\n");
        for (int i = num; i<100;i++){
            if (i%num==0 && num != i){
                System.out.print(i+", ");
            }
        }
        System.out.println("");
    }
}