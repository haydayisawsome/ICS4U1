/**
 * Author:  Isaac Man
 * Date:    April 15, 2024
 * Subject: 
 */

import java.util.ArrayList;
public class Lesson3_ArrayListOfObjects{
    public static void main(String[]args){
        Student[]s = new Student[4];
        s[0] = new Student("Steven",17,21);
        s[1] = new Student("Mina",16,10);
        s[2] = new Student("Minoo",15,9);
        s[3] = new Student("Marya",17,11);
        ArrayList<Student>list = new ArrayList<Student>();
        for (int i=0;i<s.length;i++){
            list.add(s[i]);
        }
        
        //printing the list 
        for (int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
class Student{
    //instance variables
    String name;
    int age;
    int grade;
    
    //overloaded constructor
    public Student(String n, int a, int g){
        name = n;
        age = a;
        grade = g;
    }
    public String toString(){
        return "Name: "+name+", Age: "+age+", Grade: "+grade;
    }
}