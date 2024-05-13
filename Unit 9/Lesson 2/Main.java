public class Main {
    public static void main(String[]args){

    }
}
class Animal{
    //instance variables
    protected String name;
    protected int age;

    //default constructor
    public Animal(){
        System.out.println("This is a default constructor of Animal class");
    }

    //overloaded constructor
    public Animal(String n, int a){
        name = n;
        age = a;
    }

    //methods
    public void eat(){
        System.out.println("Animal is eating");
    }
    public void sleep(){
        System.out.println("Animal is sleeping");
    }
}
class Dog extends Animal{
    String ownerName;
    public Dog(){
        super();
        //this calls the constuctor of the parent class
        System.out.println("This is the default constructor of Dog class");
    }
    public Dog(String n, int a, String oN){
        super(n,a);
        //super must be the first line in the constructor
        ownerName = oN;
    }

    @Override
    //@Override does not do anything to the code
    //It lets the programmers know that this is an overrided method
    public void eat(){
        System.out.println("Dog is eating");
        //This is polymorphism as the header of this method is the exact same as the parent method
        //This overrides the parent method of eat()
    }
    public void bark(){
        System.out.println("Dog is barking");
    }
}

class BabyDog extends Dog{
    private boolean needsMilk;
    public BabyDog(){
        super();
        System.out.println("It is BabyDog default constructor");
    }
    public BabyDog(String n, int a, String oN){
        name = n;
        age = a;
        ownerName = oN;
    }
    public void noMilk(){
        needsMilk = true;
    }
}