/**
 * Author:  Isaac Man
 * Date:    April 9, 2024
 * Subject: Array list
 */

public class RemovingAndInsertingElements{
    //# an array has a constant number of values
    //# you can change the number/type of values in an array list
    
    int[] array = new int[3];
    //# this will always have 3 different int indexes
    
    public static void main(String[]args){
        int[]a = {2,4,6,8};
        int[]b = addEnd(a,10);
        
        printArray(a);
        System.out.println(" ");
        printArray(b);
        System.out.println(" ");
        int[] num = {1,2,4,5,6,7};
        printArray(num);
        System.out.println(" ");
        printArray(insert(num,2,3));
        
        System.out.println();
        String[]name = {"John","Mina","Minoo","Jack","Komar"};
        printArray(name);
        System.out.println();
        printArray(remove(name,3));
    }
    public static int[] addEnd(int[]a, int item){
        //# adding an int element to an array
        int[] b = new int[a.length+1];
        for (int i = 0; i < b.length;i++){
            if (i < a.length){
                b[i] = a[i];
            }
            else{
                b[i] = item;
            }
        }
        return b;
    }
    public static void printArray(int[]a){
        for (int i = 0; i<a.length; i++){
            System.out.print( a[i] +"\t");
         }
    }
    public static void printArray(String[]a){
        for (int i = 0; i<a.length; i++){
            System.out.print( a[i] +"\t");
         }
    }
    
    //# inserting an item at a given position
    public static int[] insert(int[]a, int index, int item){
        int[] b = new int[a.length+1];
        for (int i = 0; i < b.length ; i++){
            if (i < index){
                b[i] = a[i];
            }
            else if (i == index){
                b[i] = item;
            }
            else if (i > index){
                b[i] = a[i-1];
            }
        }
        return b;
    }
    
    //# removing an element at a given position (index)
    public static String[] remove (String[]a, int index){
        String[]b = new String[a.length-1];
        for (int i = 0; i < b.length; i++){
            if (i < index){
                b[i] = a[i];
            }
            else if (i >= index){
                b[i] = a[i+1];
            }
        }
        return b;
    }
}