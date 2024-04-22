/**
 * Subject: Static and instance variables
 */
class Calculator{
    public static void main (String[] args){
        //calling static method in same class
        System.out.println("sub = "+sub(12,18));
        //calling instance method
        //System.out.println("add = "+add(12,18));
        //doesnt work as it is not a class
        //you need constructor or it will call defult constructor w/ class name
        Calculator ca = new Calculator(); //ca is an instance of Calculator
        System.out.println("add = "+ca.add(12,18));
        
        //instances are copies of the class
        //object is the actual class
    }
    //this is an instance method
    public int add(int x, int y){
        return x+y;
    }
    //this is a class or static method
    public static int sub(int x, int y){
        return x-y;
    }
}
//math class uses instance method

public class CalculatorTester{
    public CalculatorTester(){
        //a class or static method has a static keyboard in its header
        //a instance method does not have a static keyboard in its header
        
        //calling static method from outside class
        System.out.println("sum = "+Calculator.sub(10,20));
        //for static methods, you can use the name of the class without 
        //creating new instance
        
        //calling instance method from outside class
        Calculator ca = new Calculator();
        System.out.println("sum = " + ca.sub(3,5));
        //for isntance methods, you need to create a new instance for a new copy
        
    }
}