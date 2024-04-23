/**
 * Author:  Isaac Man
 * Date:    March 4, 2024
 * Subject: For Loops
 */
import java.util.Scanner;
public class ForLoop{
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        
        //when a number of loops are known, using for loop is recommended
        for (int i=0;i <= 10;i++){
            System.out.println(i);
        }
        //reads int i = 0, then reads i<10, THEN THE CODE INSIDE THE LOOP,
        //then i++.
        
        //example of a for loop with one variable:
        //Enter the marks of a student on 4 subjects, then calculate/print avrg
        int mark = 0;
        double avrg = 0;
        int sum = 0;
        int count;
        for (count=1;count<=4;count++){
            System.out.print("Enter the mark of subject #"+count+": ");
            mark = sc.nextInt();
            sum += mark;
        }
        avrg = (double)sum / (count-1);
        System.out.println("Average mark: "+avrg);
        
        //for loop with 2 variables, use nested loop
        //Write some line of code that asks a user to enter the names of 3
        //students and their marks on 4 tests, then the program calculates
        //each student's average and prints them out
        int marks =0;
        int student = 0;
        int total;
        double average=0;
        int subject=0;
        for (student = 1;student<=3;student++){
            total = 0;
            System.out.println("Student #"+student);
            for (subject = 1; subject <=4; subject++){
                System.out.print("Enter the mark of subject #"+subject+": ");
                marks = sc.nextInt();
                total += marks;
            }
            average=(double)total / (count-1);
            System.out.println("Average mark of student #"+student+": "+average);
        }
    }
}