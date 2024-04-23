public class InstanceStaticMethods{
    public static void staticMethod(){
        System.out.println("This is static method");
    }
    public void instanceMethod(){
        System.out.println("This is instance method");
    }
    public static void main(String[]args){
        //can call static methods from class
        InstanceStaticMethods.staticMethod();
        //must create object to call instance methods
        InstanceStaticMethods ISM = new InstanceStaticMethods();
        ISM.instanceMethod();
    }
}