public class NumberTester{
    public static void main (String[]args){
        Number n = new Number();
        n.greeting();
    }
}

class Number{
    private int x;
    private int y;
    //this is not a method as it does not have return type
    public Number(){
        x = 10;
        y = 20;
        int sum = x + y;
        System.out.println("Sum = "+sum);
        int sub = x - y;
        System.out.println("Sub = "+sub);
    }
    public void greeting(){
        System.out.println("Hello");
    }
}