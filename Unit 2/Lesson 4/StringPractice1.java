import java.util.Scanner;
public class StringPractice1{
    public static void main(String [] args){
        System.out.print("Enter a word: ");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println("It has "+word.length()+" characters");
    }
}