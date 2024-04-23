class employee{
    private String name;
    private int Salary;
    
    private int year;
    private int month;
    private int day;
    public employee(String name,int Salary,int year,int month,int day){
        this.name = name;
        this.Salary = Salary;
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSalary(int Salary){
        this.Salary = Salary;
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public void setDay(int day){
        this.day = day;
    }
    public String getName(){
        return name;
    }
    public int getSalary(){
        return Salary;
    }
    public int getYear(){
        return year;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    public int raiseSalary(int percentage){
        return (int)(Salary * ((double)percentage/100 + 1));
    }
    public String toString(){
        return "Name: "+name+" ,Salary: "+Salary+",HireDay: "+year+"/"+month+"/"+day;
    }
}
public class EmployeeTester{
    public static void main(String[]args){
        employee[]workplace = new employee[3];
        workplace[0] = new employee("John Smith",70000,1987,12,15);
        workplace[1] = new employee("Tara James",60000,1989,10,22);
        workplace[2] = new employee("Tony Baker",50000,1990,11,26);
        System.out.println("Salaries before increase");
        for (employee num : workplace){
            System.out.println(num);
        }
        System.out.println("\nSalaries after increase");
        for (employee nums : workplace){
            nums.setSalary(nums.raiseSalary(5));
            System.out.println(nums);
        }
    }
}