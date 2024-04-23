/**
 * Author:  Isaac Man
 * Date:    April 12, 2024
 * Subject: Arraylist Methods
 */

import java.util.ArrayList;
public class Lesson2_ArrayListMethods{
    public static void main(String[]args){
        ArrayList<String> names = new ArrayList<>();
        
        //add method
        //adds one element at the end of the arraylist
        names.add("Ammar");
        names.add("Isaac");
        names.add("Kiyan");
        System.out.println(names);
        
        //adds element to the index position
        names.add(2,"Daniel");
        System.out.println(names);
        
        //replaces element with another value
        names.set(2,"Mina");
        System.out.println(names);
        
        //remove method
        names.remove(3);
        System.out.println(names);
        
        //indexOf method
        //returns the index of the first method with the value
        System.out.println(names.indexOf("Mina"));
    }
}