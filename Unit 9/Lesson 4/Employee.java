public class Employee extends Person{
    //instance variables
    private int empID;

    //overloaded constructor
    public Employee(String n,String g,int e){
        super(n,g);
        empID = e;
    }
    @Override
    public void work(){
        if(empID == 0){
            System.out.println("Not working");
        }
        else{
            System.out.println("Working as employee");
        }
    }
    @Override
    public String toString(){
        return super.toString() + ", Employee ID: " + empID;
    }

    public static void main(String[] args) {
        //Person p = new Person("Minoo","Female",0); //doesnt work for person, only works for employee
        Person student = new Employee("Minoo","Female",0);
        System.out.println(student);
        student.work();
        Person employee = new Employee("John","Male",1234);
        System.out.println(employee);
        employee.work();

        employee.changeName("William Smith");
        System.out.println(employee);
        employee.work(); 
    }
}

abstract class Person{
    //instance variables
    private String name;
    private String gender;

    //overloaded constructor
    public Person(String n,String g){
        name = n;
        gender = g;
    }

    //abstract method
    public abstract void work(); //must be semicolon to not specify a body
    
    //concrete method
    public void greeting(){
        System.out.println(name + " welcome to the world");
    }
    public void changeName(String newName){
        name = newName;
    }
    public String toString(){
        return "Name: "+name+", Gender: " + gender;
    }
}