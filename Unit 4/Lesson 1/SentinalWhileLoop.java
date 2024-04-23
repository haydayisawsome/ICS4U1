/**
 * Author:  Isaac Man
 * Date:    March 1, 2024
 * Subject: While Loop
 */
import java.util.Scanner;
public class SentinalWhileLoop{
    public static void main(String[]args){
        //while loop is a general good choice where the user does not 
        //know the exact number of loops
        
        //simple example
        //find sum of natural numbers from 1 to 10
        int x = 0;
        int sum = 0;
        while (x<=10){
            sum += x;
            x++;
        }
        System.out.println("Sum = "+sum);
        
        //main types of while loop
        //1. sentinal control while loop
        //      continues looping until a special value called a sentinal
        //      entered by the user meets the requirements to not loop
        //example: write a program where the user enters some students
        //         marks on a test until the user enters -1, then the
        //         program stops and calculates the average of the marks
        
        Scanner sc = new Scanner(System.in);
        int suum = 0;
        int mark = 0;
        int count = 0;
        double average;
        while (mark != -1){
            System.out.print("Mark#"+(count+1)+": ");
            mark = sc.nextInt();
            
            if (mark!=-1){
                suum+=mark;
            }
            count++;
        }
        average = ((double)suum)/(count-1);
        System.out.printf("Mark Average: %.2f",average);
    }
}