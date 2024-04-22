import java.util.Scanner;

public class StringPractice5{
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String stc = sc.nextLine();
        System.out.print("Enter the first digit: ");
        int f = sc.nextInt();
        System.out.print("Enter the second digit: ");
        int s = sc.nextInt();
        System.out.println(stc.substring(f,s+1));
    }
}