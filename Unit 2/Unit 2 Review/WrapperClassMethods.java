public class WrapperClassMethods{
    public static void main(String[]args){
        Integer int1 = new Integer(3);
        System.out.println(int1);               //3
        Integer int2 = new Integer(3);
        System.out.println(int1==int2);         //false
        System.out.println(int1.equals(int2));  //true
        Character ch = new Character('*');
        Double d = new Double(-3.28);
        String st = new String("wfwf");
        Boolean hehe = new Boolean(true);
        
        //String double char int boolean 
        //String Double Character Integer Boolean
    }
}