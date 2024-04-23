/**
 * Author:  Isaac Man
 * Date:    April 10, 2024
 * Subject: Arraylist basics
 */

import java.util.ArrayList;

public class Lesson1_ArrayList_Basics{
    public static void main(String[]args){
        //declaring an arraylist
        //Arraylist of integers
        ArrayList<Integer>num = new ArrayList<Integer>();
        //<Integer> is not mandatory for the second time
        //ArrayList<Integer>numAlt = new ArrayList<>();
        
        //filling up the arraylist using add method
        num.add(2);
        num.add(4);
        num.add(6);
        num.add(8);
        
        //printing arraylist
        System.out.println(num);
        
        //arraylist of doubles
        ArrayList<Double> num2 = new ArrayList<>();
        num2.add(2.5);
        num2.add(4.5);
        num2.add(6.5);
        num2.add(8.5);
        System.out.println(num2);
        
        //arraylist of booleans
        ArrayList<Boolean> b = new ArrayList<>();
        b.add(true);
        b.add(false);
        b.add(true);
        b.add(false);
        System.out.println(b);
        
        //arraylist of char
        ArrayList<Character> c = new ArrayList<>();
        c.add('@');
        c.add('#');
        c.add('$');
        c.add('&');
        System.out.println(c);
    }
}