/*
 * Author:  Isaac Man
 * Date:    May 27, 2024
 * Subject: Recursion
 */

public class Lesson_1_RecursionConcept{
    public static void main(String[] args) {
        Lesson_1_RecursionConcept obj = new Lesson_1_RecursionConcept();
        System.out.println("Sum using loop = " + sumLoop(10));
        System.out.println("Sum using loop = " + sumRecursive(10));
        System.out.println("Sum using loop = " + obj.func1Recursive(5));
        System.out.println("Reversed word = " + reverseLoop("Max"));
        System.out.println("Reversed word = " + reverseRecursive("Maxist"));
    }
    
    //sum of natural numbers using loops
    public static int sumLoop(int n){
        int sum = 0;
        for(int i = 1;i<=n;i++){
            sum += i;
        }
        return sum;
    }

    //sum of natural numbers using recursive approach
    public static int sumRecursive(int n){
        if(n<=1){ //base case
            return n;
        }
        else{ //recursive case
            return n + sumRecursive(n-1);
        }
    }

    public int func1Recursive(int n){
        //f(n) = 3f(n-1)-1, f(1) = 0,n>0
        //find f(n)
        //call method and find f(5)
        if(n<=1){
            return 2;
        }
        else{
            return 3*func1Recursive(n-1) -1;
        }
    }

    //write two methods that accepts a string variable and returns its reverse
    //e.g. Max outputs xaM
    public static String reverseLoop(String word){
        String newWord = "";
        newWord = newWord + word.substring(word.length()-1);
        for (int i = word.length() - 1; i >= 0; i--){
            newWord += word.substring(word.length()-1-i,word.length()-i);
        }
        return newWord;
    }
    public static String reverseRecursive(String word) {
        if (word.isEmpty()) {
            return "";
        } 
        else {
            return reverseRecursive(word.substring(1)) + word.charAt(0);
        }
    }
}