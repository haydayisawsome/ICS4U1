/*
 * Author:  Isaac Man
 * Date:    05/21/2024
 * Subject: Question 3 of Inheritence problem set 2
 */

public class Question3{
    public static void main(String[] args) {
        HourlyWorker bob = new HourlyWorker("Bob", 20, 30);
        System.out.println("Bob worked for 30 hours with a $20 pay per hour. His salary was: $" + bob.comutePay());
        HourlyWorker joe = new HourlyWorker("Joe", 20, 50);
        System.out.println("Joe worked for 50 hours with a $20 pay per hour. His salary was: $" + joe.comutePay());
        SalariedWorker isaac = new SalariedWorker("Isaac", 50, 100);
        System.out.println("Isaac worked for 100 hours with a $50 pay per hour. His salary was: $" + isaac.comutePay());
    }
}
abstract class Worker{
    String name;
    double salaryRate;

    public Worker(String n,double sR){
        name = n;
        salaryRate = sR;
    }
    public abstract double comutePay();
}
class HourlyWorker extends Worker{
    int hours;

    public HourlyWorker(String n, double sR, int h){
        super(n,sR);
        hours = h;
    }
    public double comutePay(){
        if (hours <= 40){
            return hours*salaryRate;
        }
        else{
            return 40*salaryRate + (hours-40)*1.5*salaryRate;
        }
    }
}
class SalariedWorker extends Worker{
    int hours;

    public SalariedWorker(String n, double sR, int h){
        super(n,sR);
        hours = h;
    }
    public double comutePay(){
        return hours*salaryRate;
    }
}