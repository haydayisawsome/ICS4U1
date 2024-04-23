/**
 * Author:  Isaac Man
 * Date:    Feb 20, 2024
 * Subject: Boolean Laws
 */

import java.util.Scanner;

public class BooleanLaws{
    public static void main(String[]args){
        //boolean operators
        //Equal ==
        //Less than <
        //Less than or equal <=
        //Greater than >
        //Greater than or equal >=
        //Not equal !=
        
        //Combining boolean expression operators
        //Or ||
        //And &&
        //Not !
        
        //Difference between = and ==
        int x = 10;
        int y = 20;
        System.out.println(x>y); 
        //This is a boolean expression, returns false
        System.out.println(x=y);
        //This is an assignent expression
        //Prints 20 as x is assigned a value of 20
        System.out.println(x==y);
        //This prints true as x which is 20, is equal to y
        
        boolean d = (5>10);
        System.out.println(d);
        //returns false as b is assigned false as 5 is not > 10
        
        //investigate boolean laws
        System.out.println("Enter 3 boolean variables");
        Scanner sc = new Scanner(System.in);
        boolean a = sc.nextBoolean();
        boolean b = sc.nextBoolean();
        boolean c = sc.nextBoolean();
        //investigate if a||(b&&c) == (a||b)&&(a||c)
        System.out.println(a||(b&&c) == ((a||b)&&(a||c)));
        //investigate if a&&(b||c) == (a&&b)||(a&&c)
    }
}
