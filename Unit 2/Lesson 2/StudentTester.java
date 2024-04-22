class Student{
    //global variables
    String name = "";
    Double Test1 = new Double(0);
    Double Test2 = new Double(0);
        
    //defult constructor
    public Student(){
        Test1 = 0.0;
        Test2 = 0.0;
        name = "anonymus";
    }
        
    //overloaded constructor
    public Student(String who, double test1, double test2){
        name = who;
        Test1 = test1;
        Test2 = test2;
    }
    
    //setting methods
    public void setName(String who){
        name = who;
    }
    public void setTest1(double mark){
        Test1 = mark;
    }
    public void setTest2(double mark){
        Test2 = mark;
    }
    
    //get methods
    public String getName(){
        return name;
    }
    public double getTest1(){
        return Test1;
    }
    public double getTest2(){
        return Test2;
    }
    
    //average
    public double average(){
        return (Test1+Test2)/2;
    }
    
    //toString
    public String toStr(){
        return String.format("Name: %s%nTest 1: %f%nTest 2: %f%nAverage: %.2f",name,Test1,Test2,average());
    }
}

public class StudentTester{
    public static void main(String[] args){
        Student s = new Student("Angelo",93,96);
        System.out.println(s.toStr());
    }
}