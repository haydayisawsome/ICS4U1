/**
 * Author:  Isaac Man
 * Date:    February, 22, 2024
 * Subject: Write a program that asks the users to enter their marks on
 *          a test and also out of how many marks
 *          Then, the program cauclates the user mark in percent and
 *          100 >= mark >= 80: A
 *          80 > mark >= 70: B
 *          70 > mark >= 60: C
 *          60 > mark >= 50: D
 *          50 > mark: F
 */

import java.util.Scanner;

public class ifStatements{
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your mark:");
        double mark = sc.nextInt();
        System.out.println("Enter how many marks it is out of:");
        double outOf = sc.nextDouble();
        double percent = (mark/outOf)*100;
        
        if (percent <= 100 && percent >= 80){
            System.out.println("Your mark is A");
        }
        else if (percent < 80 && percent >= 70){
            System.out.println("Your mark is B");
        }
        else if (percent < 70 && percent >= 60){
            System.out.println("Your mark is C");
        }
        else if (percent < 60 && percent >= 50){
            System.out.println("Your mark is D");
        }
        else {
            System.out.println("Your mark is F");
        }
    }
}