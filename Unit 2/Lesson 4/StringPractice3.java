import java.util.Scanner;

public class StringPractice3{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nOriginal String: ");
        String og = sc.nextLine();
        System.out.print("Specified sequence of chars: ");
        String spec = sc.nextLine();
        System.out.print(og.contains(spec));
    }
}