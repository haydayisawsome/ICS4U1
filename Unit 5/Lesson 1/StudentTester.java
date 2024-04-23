/**
 * Author:  Isaac Man
 * Date:    March 8, 2024
 * Subject: Arrays as Instance Variables
 */
import java.util.*;
public class StudentTester{
    public static void main (String[]args){
        int[]test={60, 70, 80, 90};
        Student s = new Student("Student1",test);
        System.out.println(s);
    }
}

class Student{
    String name;
    int[]marks;
    //defult constructor
    public Student(){
        name = "unknown";
        marks = new int[0];
    }
    //overloaded constructor
    public Student(String n,int[]m){
        name = n;
        marks = m;
    }
    //toString method
    public String toString(){
        return "Name: "+name+"\nMarks: "+Arrays.toString(marks);
    }
}