/*
 * Author:  Isaac Man
 * Date:    May 29,2024
 * Subject: Recursive Algorithms
 */

public class RecursiveAlgorithms{
    public static void main(String[] args) {
        System.out.println("gcd of 36 and 44 is: " + gcd(36,44));
        System.out.println(isPal("hello"));
        System.out.println(isPal("racecar"));

        int[]array = {4,3,5,7,8};
        System.out.println(rangeOfSum(array,2,4));
    }

    //method that finds the greatest common divisor of two integers
    //Euclid Algorithms gcd(m,n) = gcd(n,m%n)
    public static int gcd(int m, int n){
        if(n == 0){
            return m;
        }
        else{
            return gcd(n,m%n);
        }
    }

    //palindrome method: a method that reads a string the same forward and backward
    public static boolean isPal(String s){
        if(s.length() == 0||s.length() == 1){ //base case 1
            return true;
        }
        else if(s.charAt(0) == s.charAt(s.length()-1)){ //recursive case
            return isPal(s.substring(1,s.length() - 1));
        }
        else{ //base case 2
            return false;
        }
    }

    //write a method that accepts an array of integers and two integers start and end
    //then it finds the sum of integers between start and end indicies and returns the sum
    public static int rangeOfSum(int[]a,int start,int end){
        if(start > end){ //base case
            return 0;
        }
        else{ //recursive case
            return a[start] + rangeOfSum(a,start+1,end);
        }
    }
}