public class Inheretence {
    // A class has two basic elements
    // Methods and Attributes (variable values)
    // Constructors are not basic elements, they are optional to be included

    // At the top of the heirachy, there is a super class (or parent class)
    // Below that, there is a subclass (or child class)
    // Super classes may contain many subclasses
    // All methods and attibutes in super class are in the classes of subclasses

    // There are also other types of classes, Interface classes and abstract classes
    // Interface classes
    //   Do not have an implementation (the bodies in a method)
    //   You cannot make objects of an interface class as there is no attributes of the class

    // Abstract classes
    //   You cannot make objects of an abstract class as they have an empty body in every method

    // For inheriting methods, you can write the keyword "extends" followed by the class name
    //   This will allow you to use methods from another class

    // Child classes cannot have two parents
    // However, interface methods can inheret from multiple parents
    //   To do this, you would prite public className implements parent1, parent2, parent 3;

    // public class Car extends Vehicle
    // public class Bike extends Vehicle
    // public class Truck extends Vehicle
    // Car car = new Car(); - this is valid
    // Car car2 = new Vehicle(); - this will give an error as vehicle is not necessarily a car
    // Vehicle v = new Car(); - this is valid as car is a vehicle

    Object obj = new Object();
    // This is the parent of all of the parents
}
