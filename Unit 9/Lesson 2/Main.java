public class Main {
    @SuppressWarnings("unused")
    public static void main(String[]args){
        //Dog d = new Animal();
        //this doesnt work as an animal is not necessarily a dog
        BabyDog BabyDog1 = new BabyDog();
        /*
        Output: 
        This is a default constructor of Animal class
        This is a default constructor of Dog class
        It is BabyDog default constructor
         */
        //this output is the result of traversing to the higher parent classes to the child classes

        new BabyDog();
        //this will only call the constructor the same way as the line above
        //however, there are no objects with the assigned address thus you cannot call the methods

        BabyDog babyDog2 = new BabyDog("My dog",8,"John",true);

        BabyDog1.eat();
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
        System.out.println("It is an overloaded constructor of Animal");
    }

    //methods
    public void eat(){
        System.out.println("Animal is eating");
    }
    public void sleep(){
        System.out.println("Animal is sleeping");
    }
    public void display(){
        System.out.println(name);
    }
}
class Dog extends Animal{
    @SuppressWarnings("unused")
    private String ownerName;
    String name = "Dog";

    public Dog(){
        super();
        //this calls the constuctor of the parent class
        System.out.println("This is the default constructor of Dog class");
    }
    public Dog(String n, int a, String oN){
        super(n,a);
        //you cannot access the private variable from animal but u can access it through a constructor
        //super must be the first line in the constructor
        ownerName = oN;
        System.out.println("It is an overloaded constructor of Dog");
    }

    @Override
    //@Override does not do anything to the code
    //It lets the programmers know that this is an overrided method
    public void eat(){
        super.eat();
        System.out.println("Dog is eating");
        //This is polymorphism as the header of this method is the exact same as the parent method
        //Action that does a method a different way
        //Different from method overloading
        //This overrides the parent method of eat()
    }

    public void bark(){
        System.out.println("Dog is barking");
    }

    //@Override;
    public void display(){
        System.out.println(name);
        System.out.println(super.name);
    }
}

class BabyDog extends Dog{
    @SuppressWarnings("unused")
    private boolean needsMilk;
    private String name = "Baby Dog";
    public BabyDog(){
        super();
        System.out.println("It is BabyDog default constructor");
    }
    public BabyDog(String n, int a, String oN, boolean nM){
        super(n,a,oN);
        needsMilk = nM;
        System.out.println("It is an overloaded constructor of BabyDog");
    }
    public void eat(){
        super.eat(); //super can be on any line when calling a method
        System.err.println("BabyDog is eating");
    }

    public void display(){
        System.out.println(name);
    }
}