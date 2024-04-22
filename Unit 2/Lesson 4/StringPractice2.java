import java.util.Scanner;
public class StringPractice2{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the first string: ");
        String s1 = sc.nextLine();
        System.out.print("Enter the second string: ");
        String s2 = sc.nextLine();
        int result = Integer.parseInt(s1) + Integer.parseInt(s2);
        System.out.print("Product: "+result);
    }
}