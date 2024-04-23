import java.util.Scanner;

public class TargetWhileLoop{
    public static void main(String[]args){
        //continues looping until it reaches to a target defines
        //defined by the while conditional statement
        
        //write some line of code that allows a user to enter his 
        //banking account balance, then the user can withdraw money
        //from their account provided that the balance is always 
        //more than $100
        
        Scanner obj = new Scanner(System.in);
        double balance;
        double withdraw = 0;
        System.out.println("Enter your balance: ");
        balance = obj.nextDouble();
        while (balance>100){
            System.out.print("Withdraw: ");
            withdraw = obj.nextDouble();
            if (balance-withdraw >100){
                balance -= withdraw;
            }
            else {
                System.out.println("Withdraw denied");
                break;
            }
            
        } //100 is the target
        System.out.printf("Final balance: $%0.2f",balance);
    }
}