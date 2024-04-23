
/**
 * Author:  Isaac Man
 * Date:    April 19, 2024
 * Subject: Arraylist Algorithms
 */

 import java.util.*;

 public class Lesson4_ArrayListAlgorithms{
     public static void main (String[]args){
         ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(12,5,22,82,16,51));
         System.out.println(list+"\n");
         
         //calling minimum method and printing its output
         System.out.println("Min = "+minimum(list));
         //calling maximum method and printing its output
         System.out.println("Max = "+maximum(list));
         
         int x = 20;
         System.out.println("Position of "+x+" is: "+search(list,x));
         
         System.out.println(swap(list,1,3));
         
         System.out.println(sort(list));
         
         System.out.println(reverse(list));
     }
     public static int minimum(ArrayList<Integer>list){
         int min = list.get(0);
         for (int i = 0;i<list.size();i++){
             if (list.get(i)<min){
                 min=list.get(i);
             }
         }
         return min;
     }
     public static int maximum(ArrayList<Integer>list){
         int max = list.get(0);
         for (int i = 0;i<list.size();i++){
             if (list.get(i)>max){
                 max=list.get(i);
             }
         }
         return max;
     }
     public static int search(ArrayList<Integer> a, int item){
         int location = -1;
         for (int i = 0;i<a.size();i++){
             if (a.get(i) == item){
                 location = i;
             }
         }
         return location;
     }
     public static ArrayList<Integer> swap(ArrayList<Integer> a, int indexA, int indexB){
         int temp = a.get(indexA);
         a.set(indexA, a.get(indexB));
         a.set(indexB, temp);
         //set method: name.set(index,value);
         return a;
     }
     public static ArrayList<Integer>sort(ArrayList<Integer>num){
         for (int i = 0;i<num.size();i++){
             for (int j = i+1;j<num.size();j++){
                 int temp = 0;
                 if (num.get(i)>num.get(j)){
                     temp = num.get(i);
                     num.set(i,num.get(j));
                     num.set(j,temp);
                 }
             }
         }
         return num;
     }
     public static ArrayList<Integer> reverse (ArrayList<Integer>list){
         //creating an empty arraylist
         ArrayList<Integer>revList = new ArrayList<Integer>();
         //fill up the arraylist in the reverse order
         for(int i = list.size()-1;i>=0;i--){
             revList.add(list.get(i));
         }
         return revList;
     }
 }