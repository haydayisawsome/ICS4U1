/**
 * 
Write flowchart and a program to prepare the monthly charge account statement 
for a customer of CS CARD International, a credit card company.  
The program should take as input the previous balance on the account and 
the total amount of additional charges during the month.  
The program should then compute the interest for the month, the total new 
balance (the previous balance plus additional charges plus interest), 
and the minimum payment due.  Assume the interest is 0 if the previous balance 
was 0 but if the previous balance was greater than 0 the interest is 2% of the 
total owed (previous balance plus additional charges).  

Assume the minimum payment is as follows: 

     new balance	   for a new balance less than $50
     $50.00	   for a new balance between $50 and $300(incl)
	20% of new balance for a new balance over $300

So if the new balance is $38.00, then the person must pay the whole $38.00; 
if the balance is $128 then the person must pay $50; 
if the balance is $350 the minimum payment is $70 (20% of 350).  
The program should print the charge account statement in the format below.  
Print the results as shown in the sample output.
     Sample output

 */

import java.util.Scanner;
public class ChargeAccount{
    public static void main(String[]args){
        System.out.println("Enter previous balance: ");
        Scanner sc = new Scanner(System.in);
        double prevBalance = sc.nextDouble();
        System.out.println("Enter additional charges: ");
        double charges = sc.nextDouble();
        double balance = prevBalance + charges;
        double interest = 0;
        if (prevBalance > 0){
            interest = balance*0.02;
        }
        balance = interest+balance;
        double pay = 0;
        if (balance < 50){
            pay = balance;
        }
        else if (balance >= 50 && balance <= 350){
            pay = 50;
        }
        else if (balance > 350){
            pay = balance*0.2;
        }
        
        System.out.println("CS CARD International Statement");
        System.out.println("\t=============================\n");
        System.out.printf("\tPrevious Balance: \t$%.2f\n",prevBalance);
        System.out.printf("\tAdditional Charges: \t$%.2f\n",charges);
        System.out.printf("\tInterest: \t\t$%.2f\n\n",interest);
        System.out.printf("\tNew Balance: \t\t$%.2f\n\n",balance);
        System.out.printf("\tMinimum Payment: \t$%.2f",pay);
    }
}