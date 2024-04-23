/**
 * Write a flowchart and program called Salary that takes as input 
 * an employee’s name, employee’s salary and a rating of the employee’s 
 * performance and computes the raise for the employee. The performance 
 * rating is being entered as a String—the three possible ratings are 
 * "Excellent”, “Good”, and “Poor”. An employee who is rated excellent 
 * will receive a 6% raise, one who is rated good will receive a 4% raise, 
 * and one who is rated poor will receive a 1.5% raise. 
 */

import java.util.Scanner;

public class Salary{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee's name: ");
        String name = sc.nextLine();
        System.out.println("Enter employee's salary: ");
        double salary = sc.nextDouble();
        System.out.println("Enter employee's rating: ");
        Scanner sc1 = new Scanner(System.in);
        String rating = sc1.nextLine();
        double raise = 0;

        if (rating.equals("Excellent")){
            raise = salary*0.06;
        }
        else if (rating.equals("Good")){
            raise = salary*0.04;
        }
        else if (rating.equals("Poor")){
            raise = salary*0.015;
        }
        
        double raiseSalary = raise + salary;
        
        System.out.println("Salary increase statement\n");
        System.out.println("Name: \t\t"+name);
        System.out.printf("Salary: \t$%.2f\n",salary);
        System.out.println("Performance: \t"+rating);
        System.out.printf("Raise: \t\t$%.2f\n",raise);
        System.out.printf("Raised Salary: \t$%.0f\n",raiseSalary);
    }
}