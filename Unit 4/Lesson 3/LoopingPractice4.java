/**
Write a flowchart for a program that allows the user to 
enter integer values until 0 is entered, then
calculates and displays the product of the integers. 
If any of the integers is not positive, amessage should be 
displayed and the value not counted in the product as shown.

Enter positive integers (0 to quit)
#1: 12
#2: -2
-2 not counted
#2: 4
#3: 0
The product of the 2 positives is 48.
 */

import java.util.Scanner;
public class LoopingPractice4{
    public static void main (String[]args){
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter positive integers (0 to quit)");
        int num = 1;
        int product = 0;
        int count = 0;
        while (num !=0){
            if (num !=0){
                System.out.print("#1: ");
                num = sc.nextInt();
            }
            else if (num<0){
                
            }
        }
    }
}