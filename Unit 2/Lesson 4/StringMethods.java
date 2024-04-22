/**
 * Author:  Isaac Man
 * Date:    Feb 14, 2024
 * Subject: String class methods
 */

public class StringMethods{
    public static void main (String []args){
        //contacanation method
        String s1 = "Computer";
        String s2 = "Science";
        
        //same output using different method
        System.out.println(s1+s2);
        System.out.println(s1.concat(s2));
        
        
        //substring method *VERY IMPORTANT*
        String s3 = "Northern Secondary School";
        //index num  0123456789         first letter is 0, not one
        //any part inside a string is a substring
        //you can print only a part of a string
        //e.g. print northern (0 to 4)
        System.out.println(s3.substring(0,4)); //index 4 is not included
        //prints Nort
        System.out.println(s3.substring(0,5)); //index 5 is not included
        //prints North
        
        System.out.println(s3.substring(9,18));
        //prints Secondary
        
        //overloaded method (same method name with diff # of parameters)
        System.out.println(s3.substring(9)); //prints index 9 onwards
        //prints from index 9 to the end of the string
        
        System.out.println(s3.substring(0,1)+s3.substring(9,10)+s3.substring(19,20));
        //prints 244 because it prints the letter as a number that rep. it
        
        //charAt method -> prints a char from an index of a string
        String name = "Daniel";
        System.out.println(name.charAt(0));
        //you can only print 1 at a time, not add them
        //when you add the char, it causes the char to convert to the 
        //number value 
        
        //length method
        System.out.println(name.length());
        //this is a method without parameters
        //prints # of indexes in string (in this case its 6)
        
        //replace method
        String s4 = "Kava is a programming language. Kava is popular";
        String replaceString = s4.replace("Kava","Java");
        //replaces "Java" with "Java"
        System.out.println(s4);
        System.out.println(replaceString);
        
        //convert int and double to string
        int x = 12;
        double y = 8.5;
        String a = String.valueOf(x);
        String b = String.valueOf(y);
        System.out.println(a+b);
        
        //convert string to int and double
        String hi = "44";
        String bye = "38";
        int c = Integer.parseInt(hi);
        System.out.println(c);
        double d = Double.parseDouble(bye);
        System.out.println(d);
        System.out.println(hi+" + "+bye+" = "+(c+d));
        
        //indexOf method
        String string = "book";
        System.out.println(string.indexOf('k'));
        //when there are multiple of the same characters you are trying to
        //find in the string, it gives the first result
        
        //equals equalsIgnore
        //String literal vs String as an object
        //primitive type variable
        String p1 = "Jacob";
        String p2 = "Jacob";
        System.out.println(p1 == p2); //both strings are equal
        //reference type variable
        String p3 = new String ("Jacob");
        String p4 = new String ("Jacob");
        System.out.println(p3 == p4);
        //prints out false because even though the content is the same
        //because the address of the object is still different
        System.out.println(p3.equals(p4));
        //this finds what is inside the object, not the address
        
        //equalsIgnoreCase method
        String p5 = new String("jacob");
        System.out.println(p4.equalsIgnoreCase(p5));
        
        //contains method
        String string1 = "Java Excercises and Python Exercises";
        String string2 = "Python";
        String string3 = "html";
        System.out.println(string1.contains(string2));
        System.out.println(string1.contains(string3));
        
        //compareTo method
        //compares two strings lexicographically
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = "Bello"; //returns 6 as H is 6 characters after B
        String str4 = "ezkkn"; //returns -29 
        System.out.println(str1.compareTo(str2));
        System.out.println(str1.compareTo(str3));
        System.out.println(str1.compareTo(str4));
        
        //round method
        double number = 2.34;
        System.out.println(Math.round(number)); //rounds up if >.5, or down if <0.5
        
        //floor method
        System.out.println(Math.floor(number)); //will always round down to nearest whole num
        System.out.println(Math.floor(2.999999));
        
        //ceil method
        System.out.println(Math.ceil(number)); //will always round up to nearest whole number
        System.out.println(Math.ceil(0.000001));
    }
}