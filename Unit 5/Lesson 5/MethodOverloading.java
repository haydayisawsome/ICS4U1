/**
 * 
 */

public class MethodOverloading{
    final int INTEREST_RATE = 8;
    //# final keyword - value cannot be changed after assignment
    //# usually the name is upper case for formatting purposes
    
    public static void main(String[]args){
        /**#
        Definition of Overloading Methods;
        two or more methods that have the same name but different
        amounts/types of parameters are called
         */
    }    
    
    //are the following methods overloaded methods
    public int add(int x, int y){
        return x + y;
    }
    /*
    public int add(int a, int b){
        return x + y;
    }
    */
    //# no, because there are the same amount/types of parameters
    
    public void display(){
        //x = x+9;
        System.out.println("x = "+ INTEREST_RATE);
    }
}