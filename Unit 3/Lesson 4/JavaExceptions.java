/**
 * Author:  Isaac Man
 * Date:    Feb 29, 2024
 * Subject: Exceptions in Java
 */

public class JavaExceptions{
    public static void main (String[]args){
        int x = 20;
        for (int i = -5; i <= 5; i ++){
            //System.out.println("Z = "+x/i);
            //results in an exception as java cannot divide x by 0
            //you must throw the exception for the program to ignore it
            try{ //this sees if there is any error
                System.out.println("Z = "+x/i);
            }  
            catch (Exception e){ //this activtes when it caught an error
                System.out.println("An error occured");
            }
        }
    }
}