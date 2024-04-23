/**
 * Author:  Isaac Man
 * Date:    Feb 23, 2024
 * Subject: Conditional statements in seperate methods
 */

public class ConditionalReview{
    public static void main(String[]args){
        singleIf(65);
        areEqual(39.3838,39.3838);
    }
    //if statement with one single decision
    //a method that accepts a student mark as an int
    public static void singleIf(int mark){
        if (mark >= 50){
            System.out.println("You passed the test");
        }
    }
    //if else case
    //write a method that accepts to decimal numbers and tests
    //if they are the same up to 3 decimal places
    public static void areEqual (double x, double y){
        x = Math.floor(x*1000);
        x = x/1000;
        y = Math.floor(y*1000);
        y = y/1000;
        if (x == y){
            System.out.println("The marks are equal up to third decimal place");
        }
    }
    
    //decision with more than two variables
    //write method that asks the user to enter their age and weight in kg to find out if they are eligible to donate blood 
    //to donate blood, the doner should be older than 18 and their weight should be more than or equal to 50kg
    //done by creating a nested if statement
    public static void donateBlood(int age, int weight){
        if (age>=18){
            if (weight >=18){
                System.out.println("You are eligible to donate blood");
            }
            else {
                System.out.println("Must be 50 kg");
            }
        }
        else {
            System.out.println("Must be 18 or older");
        }
    }
}