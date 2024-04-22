/**
 * Author : Isaac Man
 * Date   : Feb 07, 2024
 * Subject: Creating Classes and Objects
 */

 public class Point{
    //A class is a blue print of an object
    //An object is an instance of a class
    //A method is something the object can do
    
    //you do not need a main method
    
    //instance variables
    private double x; //private is used to create variable that cannot be
    private double y; //read by other classes
    //global variables can be seen in the entire class
    
    //defult constructor
    //if you do not create any constructor, java creates a defult constructor
    //this constructor is used to tell java not to create defult one
    public Point(){
        //initializing coordinate system
        x=0;
        y=0;
    }
    
    //overloaded constructor - means they have the same name + parameters
    public Point(double xCor,double yCor){
        x=xCor;
        y=yCor;
    }
    
    //create a method that accepts a parameter but does not have return value
    public void setX(double num){
        x=num;
    } //only sets the variables, does not return anything
    public void setY(double num){
        y=num;
    }
    
    //method that does not have any parameters but returns a value
    //get method
    public double getX(){ //double in defining class = return a double
        return x;
    }
    public double getY(){
        return y;
    }
    
    //method that does not accept parameter and does not have return type
    public void move(){
        x=x+10;
        y=y+10;
        //x+=10; same thing
    }
    
    //java method only
    public String toString(){
        return "(" +x+ "," +y+ ")";
    }
}
class PointTester{
    public static void main(String[] args){ //main class, runs this code
        //create point(3,5)
        //calling overloaded constructor and setting poins
        Point p1=new Point(3,5);
        
        //calling getX() and getY()
        System.out.println("x= "+p1.getX()+"y= "+p1.getY());
        
        //calling setX and setY methods
        //changing point (3,5) to (2,3)
        p1.setX(2);
        p1.setY(3);
        //referenceVariableName.methodName(parameters)
        System.out.println("x= "+p1.getX()+"y= "+p1.getY());
        
        Point p2=new Point(8,12); //you can also create another reference var
        
        //calling move method
        p2.move();
        System.out.println("x= "+p2.getX()+"y= "+p2.getY());
        
        //working with defult constructor
        Point p3 = new Point();
        //if you dont put parameters, returns defult constructor
        //defult values: x=0, y=0
        System.out.println("x= "+p3.getX()+"y= "+p3.getY());
        
        //using toString method
        Point p4 = new Point(10,20);
        System.out.println(p4);
        //prints out the returned format
    }
}