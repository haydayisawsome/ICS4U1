import java.util.Scanner;

public class IfStatement{
    public static void main(String[]args){
        //using if statements instead of switch statements
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a mark: ");
        int mark = sc.nextInt();
        if (mark == 0){
            System.out.println(mark + " is F");
        }
        else if (mark == 1){
            System.out.println(mark + " is D");
        }
        else if (mark == 2){
            System.out.println(mark + " is C");
        }
        else if (mark == 3){
            System.out.println(mark + " is B");
        }
        else if (mark == 4){
            System.out.println(mark + " is A");
        }
        else {
            System.out.println("Not a valid mark\nPlease enter a mark from 0 to 4");
        }
    }
}