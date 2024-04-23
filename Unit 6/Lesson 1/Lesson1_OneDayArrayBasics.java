/**
 * Author:  Isaac Man
 * Date:    March 27, 2024
 * Subject: Basics of 1 dimensional array
 */

public class Lesson1_OneDayArrayBasics {
    //# an array is an object, not a primitive type
    
    //# there are two columns, stack and heap
    //# in the stack, only the entire variable can be accessed
    //# in a heap, any variable in the object can be accessed
    //# primitive variables are in the stack, arrays are in the heaps
    
    public static void main(String[]args){
        //# 1. array of integers
        int[] a = new int[4];
        //# you must put square brackets beside the
        //# data type to make an array
        
        //# arrays are objects that must be
        //# initialized like other objects
        
        //# array of doubles
        double[] b = new double[4];
        
        //# array of characters
        char[] c = new char[4];
        
        //# array of booleans
        boolean[] d = new boolean[3];
        
        //# array of strings
        String[] s = new String[3];
        //# the number in the second bracket is how many
        //# values can be entered
        
        //# array of various objects
            //# filling up the arrays
            a[0] = 2;
            //# a is the name, the indexes start from 0 and
            //# increase by 1
            //# this assignes the first index with the value 0
            a[1] = 4;
            a[2] = 6;
            a[3] = 8;
            
            //# create an array only on one line
            int[]num = {1,3,5,7};
            
            //# traversing and printing an array using loop
            for (int i = 0; i < a.length;i++){
                System.out.print(a[i] + "\t");
            }
            
            //# using enhanced for loop
            System.out.println();
            for (int number:a){
                System.out.print(number+"\t");
            }
            //# enhanced for loop does not have an index (i)
            //# used when u want to go through an object entirely
            //# when no index values are needed
            //# do not use enhanced for loops when you want to access
            //# a certain element of your array
            
            //# printing an array that is partially filled
            //# by defult, the non-filled values are set to 0
            int[] z = new int[4];
            z[0] = 4;
            z[1] = 6;
            z[2] = 8;
            for (int number:z){
                System.out.print(number+"\t");
            }
            //# the defult value of booleans are false
            
            
        
    }
}