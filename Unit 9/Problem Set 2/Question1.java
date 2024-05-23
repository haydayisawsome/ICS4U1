/*
 * Author:  Isaac Man
 * Date:    05/21/2024
 * Subject: Question 1 of Inheritence problem set 2
 */

public class Question1{
    public static void main(String[] args) {
        Person bob = new Person("Bob", 1999);
        System.out.println(bob.toString());
        Student joe = new Student("Joe",2024,"Mechanical Engineering");
        System.out.println(joe.toString());
        Instructor jane = new Instructor("Jane",1980,1234.56);
        System.out.println(jane.toString());
    }
}
class Person{
    String name;
    int birthYear;

    public Person(String n, int b){
        name = n;
        birthYear = b;
    }
    
    public String toString(){
        return "Name: " + name + ", Birth Year: " + birthYear;
    }
}
class Student extends Person{
    String major;

    public Student(String n, int b, String m){
        super(n,b);
        major = m;
    }

    public String toString(){
        return "Name: " + name + ", Birth Year: " + birthYear + ", Major: " + major;
    }
}
class Instructor extends Person{
    double salary;

    public Instructor(String n, int b, double s){
        super(n,b);
        salary = s;
    }

    public String toString(){
        return "Name: " + name + ", Birth Year: " + birthYear + ", Salary: $" + salary;
    }
}