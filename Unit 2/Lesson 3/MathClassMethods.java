/**
 * Date:    Feb 12, 2024
 * Subject: Math Classes
 */

 public class MathClassMethods{
    public static void main (String[] args){
        double x = 16.64;
        double y = 30;
        double z;
        double r;
        
        //Method to find square root of a number
        z = Math.sqrt(x); //static method
        //this is static method as you can call it with the class name
        System.out.printf("%.2f\n",z);
        //public class Math{
        //  public static double sqrt(double x){
        //  }
        //}
        
        //methods for trigonometric functions
        //first convert degrees to radian
        //example calculate sin,cos,tan   of var y
        r = Math.toRadians(y); //still a static/object method
        System.out.printf("sin 30 = %.2f\n",Math.sin(r));
        System.out.printf("sin 30 = %.2f\n",Math.cos(r));
        System.out.printf("sin 30 = %.2f\n",Math.tan(r));
        
        //max and min of 2 numbers
        System.out.println("Min = " + Math.min(3,6));
        System.out.println("Max = " + Math.max(3,6));
        
        //max and min of 3+ numbers
        System.out.println("Min = " + Math.min(Math.min(55,66),88));
        System.out.println("Max = " + Math.max(Math.max(55,66),88));    
        
        //calculate 2^5
        System.out.println("2^5 = " + Math.pow(2,5));
        
        //random numbers between two integers min and max inclusive
        //(int)(Math.random()*(max-min+1)+min);
        //find a random number between 20 to 50 inclusive
        System.out.println((int)(Math.random()*(31)+20));
        //Math.random picks random num from 0 to 1
        //you need to mult by 31 for base num of 31 and top num of 51
        //you also need to convert into an int
        
        //log functions
        System.out.println(Math.log(10)); //this returns logx in base e
        System.out.println(Math.log10(100)); //returns log base 10
        
        //exponential functions
        System.out.println(Math.exp(5)); //returns e^5
    }
}