public class Lesson2_ArrayOfObjects{
    public static void main(String[]args){
        car[]car = new car[3];
        //# this is declaring a new array
        
        car[0] = new car ("Mazda",2020,18750.00);
        car[1] = new car ("Nissan",2021,19700.00);
        car[2] = new car ("Ford",2022,20750.00);
        
        //# printing the car object
        for (int i = 0;i<car.length;i++){
            System.out.println(car[i]);
        }
    }   
}
class car{
    //instance variables
    private String name;
    private int year;
    private double price;
    
    //overloaded constructor
    public car(String n,int y,double p){
        name = n;
        year = y;
        price = p;
    }
    public String toString(){
        return "Name: "+name+", Year: "+year+", Price: $"+String.format("%.2f",price);
        //# since you cannot printf in a return statement,
        //# you can format it as String.format();
    }
}