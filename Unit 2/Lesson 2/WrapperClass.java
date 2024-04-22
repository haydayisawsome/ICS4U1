
public class WrapperClass{
    public static void main (String[] args){
        //num1 and num2 are students in room 231 and room 240
        int num1 = 30;
        System.out.println("num1 = " + num1);
        int num2 = 30;
        
        //comparing primitive types
        System.out.println(num1==num2);
        
        System.out.println("num2 = " + num2);
        //primitive types only pass values
        System.out.println("num1 equals num 2: "+(num1==num2));
        
        
        //reference type variable
        Integer room231 = new Integer(30);
        System.out.println("room231 = " + room231);
        Integer room240 = new Integer(30);
        System.out.println("room240 = " + room240);
        
        //comparing reference variable
        System.out.println(room231==room240); //returns false
        //compares the room 231 not equal to room 240
        //must compare the values of the objects
        //the room is different but the # of students is the same
        
        //comparing objects
        System.out.println(room231.equals(room240)); //returns true
        
        //objects are more useful than primitive variables because they can
        //carry more data types than primitive variables
        //used in arraylist, hashmaps: ,more flexable 
        //arraylist - you can add more values with different types
        
        //doubles
        Double d = new Double(2.34);
        System.out.println(d);
        
        //booleans
        Boolean b = new Boolean(true);
        System.out.println(b);
        
        //char
        Character c = new Character('$');
        System.out.print(c);
        
        //bytes have 8 bits, can range in values from -2^7 to 2^7-1
        byte x = 12;
        byte y = 18;
        //using bytes is beneficial when using smaller numbers
        //due to being able to save space and compiling time
        System.out.println("y = "+y);
        System.out.println("x = "+x);
    }
}