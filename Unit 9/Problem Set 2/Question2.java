/*
 * Author:  Isaac Man
 * Date:    05/21/2024
 * Subject: Question 2 of Inheritence problem set 2
 */

public class Question2{
    public static void main(String[] args) {
        Employee bob = new Employee("Bob",100);
        System.out.println(bob.toString());
        Manager joe = new Manager("Joe", 1000, "Human Resources");
        System.out.println(joe.toString());
        Executive isaac = new Executive("Isaac", 10000, "Finance");
        System.out.println(isaac.toString());
    }
}
class Employee{
    String name;
    double salary;

    public Employee(String n, double s){
        name = n;
        salary = s;
    }
    public String toString(){
        return "Employee Name: " + name + ", Salary: $" + salary;
    }
}
class Manager extends Employee{
    String department;
    
    public Manager(String n, double s, String d){
        super(n,s);
        department = d;
    }
    public String toString(){
        return "Manager Name: " + name + ", Salary: $" + salary + ", Department: " + department;
    }
}
class Executive extends Manager{
    public Executive(String n, double s, String d){
        super(n,s,d);
    }
    public String toString(){
        return "Executive Name: " + name + ", Salary: $" + salary + ", Department: " + department;
    }
}