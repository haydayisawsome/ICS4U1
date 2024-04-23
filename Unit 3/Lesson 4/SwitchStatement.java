/**
 * Author:  Isaac Man
 * Date:    Feb 29, 2024
 * Subject: Switch Statement
 */

import java.util.Scanner;
public class SwitchStatement{
    public static void main(String[]args){
        //write a program that asks a user to enter a mark using a 
        //numbering system (0,1,2,3,4), then the program prints the
        //equivalent alphabetic system (A,B,C,D,F)
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a mark: ");
        int mark = sc.nextInt();
        switch(mark){
            case 0:
                System.out.println(mark + " is F");
                break;
            case 1:
                System.out.println(mark + " is D");
                break;
            case 2:
                System.out.println(mark + " is C");
                break;
            case 3:
                System.out.println(mark + " is B");
                break;
            case 4:
                System.out.println(mark + " is A");
                break;
            default:
                System.out.println("Not a valid mark\nMark must be 0 to 4");
        }
    }
}