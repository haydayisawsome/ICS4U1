/*
 * Author:  Isaac Man
 * Date:    May 23, 2024
 * Subject: Interface problem set 3
 */

class BankAccount{
    protected double balance;

    public BankAccount(double b){
        balance = b;
    }
    public void deposit(double amount){
        balance += amount;
    }
    public void withdraw(double amount){
        balance -= amount;
    }
    public void transfer(BankAccount other, double amount){
        withdraw(amount);
        other.deposit(amount);
    }
    public String toString(){
        return "Balance: $" + String.format("%.2f",balance);
    }
}

class CheckingAccount extends BankAccount{
    protected String name;

    public CheckingAccount(double b,String n){
        super(b);
        name = n;
    }
    
    @Override
    public void deposit(double amount){
        super.deposit(amount);
    }
    @Override
    public void withdraw(double amount){
        super.withdraw(amount);
    }
    @Override
    public void transfer(BankAccount other,double amount){
        super.transfer(other,amount);
    }
    @Override
    public String toString(){
        return "Name: " + name + ", Balance: $" + String.format("%.2f",balance);
    }
}

public class AccountTester {
    public static void main(String[] args) {
        System.out.println("Mina and Minoo initial balances: ");
        CheckingAccount Mina = new CheckingAccount(1200.6,"Mina");
        System.out.println(Mina.toString());
        CheckingAccount Minoo = new CheckingAccount(1800.8, "Minoo");
        System.out.println(Minoo.toString());
        Mina.deposit(600);
        Mina.withdraw(250);
        Mina.transfer(Minoo,450);
        Minoo.deposit(800);
        Minoo.withdraw(450);
        Minoo.transfer(Mina,150);
        System.out.println("\nMina and Minoo final balances: ");
        System.out.println(Mina.toString());
        System.out.println(Minoo.toString());
    }
}