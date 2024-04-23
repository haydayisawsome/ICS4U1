/**#
 * Author:  Isaac Man
 * Date:    March 25, 2024
 * Subject: Static variables
 */

public class PocketMoney{
    //# instance variable of non-static variable
    //private int count; 
    //#taking the record of money paid to every kid
    /**#
     * Output: 
     * 1
     * 1
     * 1
     */
    //#Creates 3 different objects with different variable values
    
    //# Class/Static variables
    private static int count; 
    //# the same value for every instance
    //# all objects call from the same variable
    //# used to save memory space
    
    private static int x;
    
    public PocketMoney(){
        count++;
        System.out.println(count);
    }
    public static void main(String[]args){
        //# Non static variables cannot be used in static variables
        //# Static variables can be accessed in static methods
        PocketMoney mom = new PocketMoney();
        PocketMoney dad = new PocketMoney();
        PocketMoney grandma = new PocketMoney();
        
        /**# static methods can be accessed anywhere in the program
         * Static variables can be accessed by static and non static methods
         * Static variables reduce the amount of memory used by a program
         * Static variables are shared among all instances
         * Static variable is like a global variable and is available to all methods
         */
        
        /**#
         * Non Static variables can only be accessed by non static methods
         */
    }
    public static void display(){
        System.out.println("x = "+x);
    }
    
    
    /**#                    *********   VERY IMPORTANT   ***********
     * For example:
     * public static int (double x);
     * public/private of any method is called the access modifier
     * static - a keyword to determine if the method is a static or non static method
     * int - return type
     * (double x) - parameter
     * 
     * Access Modifiers
     *            Accessible within class?          Accessible outside of class?
     * public           Yes                                 Yes
     * private          Yes                                 No
     * defult           Yes                      Only in the classes what are in the same package
     * protected        ???                                 ???         (will be talked about in unit 9 - inheretence)
     * 
     * all classes and constructors are public
     * - to be able to access the values in classes and constructor
     */
}