package demo;

public class RecursionTester {
    public static void main(String[] args) {
        System.out.println("productSome(3,6) = " + Recursion.productSome(3,6));
        System.out.println("factorial(5) = " + Recursion.factorial(5));
        System.out.println("reverse(\"abcd\") = " + Recursion.reverse("abcd"));
    }
}
class Recursion{
    public static int productSome(int start, int end){
        if(start == end){
            return end;
        }
        else{
            return productSome(start+1,end) * start;
        }
    }
    public static int factorial(int num){
        if(num == 1){
            return 1;
        }
        else{
            return factorial(num - 1) * num;
        }
    }
    public static String reverse(String value){
        if(value.length() == 1){
            return value;
        }
        else{
            return reverse(value.substring(1)) + value.substring(0,1);
        }
    }
}