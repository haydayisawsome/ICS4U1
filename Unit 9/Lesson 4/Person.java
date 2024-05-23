/**
 * Author:  Isaac Man
 * Date:    May 21, 2023
 * Subject: Abstract Classes
 */

public abstract class Person{
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