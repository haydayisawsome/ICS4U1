/*
Output Example
ID: 123456
Salary per hour: $58.00
Number of hours: 2000 Hours per year
Yearly salary before tax: $116000
Yearly salary after decrease: $98600 
 */
import java.util.Scanner;
public class SalePersonTester{
    public static void main(String[] args) {
        System.out.print("ID: ");
        int id = sc.nextInt();
        
    }
}
class SalePerson{
    private int employeeNumber;
    private double hourlySalary;
    private int numberOfHours;

    public SalePerson(){
        employeeNumber = 0;
        hourlySalary = 0;
        numberOfHours = 0;
    }
    public SalePerson(int e,double s,int h){
        employeeNumber = e;
        hourlySalary = s;
        numberOfHours = h;
    }

    public void setEmployeeNumber(int num){
        employeeNumber = num;
    }
    public void setHourlySalary(int s){
        hourlySalary = s;
    }
    public void setNumberOfHours(int n){
        numberOfHours = n;
    }
    public int getEmployeeNumber(){
        return employeeNumber;
    }
    public double getHourlySalary(){
        return hourlySalary;
    }
    public int getNumberOfHours(){
        return numberOfHours;
    }

    public double yearlySalary(){
        return hourlySalary * numberOfHours;
    }
    public void afterTax(double taxRate){
        hourlySalary = (100-taxRate)*hourlySalary;
    }
}