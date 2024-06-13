package demo;

/*
Output Example
ID: 123456
Salary per hour: $58.00
Number of hours: 2000 Hours per year
Yearly salary before tax: $116000
Yearly salary after decrease: $98600 
 */

public class SalePersonTester{
    public static void main(String[] args) {
        SalePerson demo = new SalePerson(123456,58.00,2000);
        System.out.println("ID: " + demo.getEmployeeNumber());
        System.out.println("Salary per hour: $" + demo.getHourlySalary());
        System.out.println("Number of hours: " + demo.getNumberOfHours() + " Hours per year");
        System.out.println("Yearly salary before tax: $" + demo.yearlySalary());
        demo.afterTax(15);
        System.out.println("Yearly salary after decrease: $" + demo.yearlySalary());
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
        hourlySalary = (100-taxRate)*hourlySalary/100;
    }
}