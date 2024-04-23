import java.util.Scanner;
public class LoopingPractice5{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Retirement Account: ");
        double account = sc.nextDouble();
        System.out.println("\nWithdrawals");
        double transaction = 0;
        int year = 0;
        while (account >= 0 && transaction != -1){
            year++;
            System.out.print("Year "+year+": ");
            transaction = sc.nextDouble();
            if (transaction != -1){
                account-=transaction;
            }
        }
        System.out.println("You have $"+account+" left.");
    }
}