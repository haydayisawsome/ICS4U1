/*
Author:  Isaac Man
Date:    May 13, 2024
Subject: Inheretence concept
 */

public class Inheritence {
    public static void main(String[] args) {
        B b = new B();
        
        System.out.println(b.s1);
        // this gives you an error, unless B inherets the attributes/methods of A
        System.out.println(b.s2);

        b.methodA();
        // this gives you an erorr, unless B inherets the attributes/methods of A
        b.methodB();

        //private instance variables cannot be inhereted by the subclass
        //constructors are not inhereted by the child class

        //Access modifiers:
        //Public is accepted anywhere
        //Private cannot be inhereted
        //Protected can only be inhereted in the same package
    }
}
class A{
    String s1 = "Class A";
    public void methodA(){
        System.out.println("This method is in class A");
    }
}
class B extends A{
    String s2 = "Class B";
    public void methodB(){
        System.out.println("This method is in class B");
    }
}