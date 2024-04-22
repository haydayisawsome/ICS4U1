//BankAccount
class Account{
    private String name;
    private double balance;
    private double deposit;
    private double withdraw;
  
    public Account(){
      name = "null";
      balance = 0;
    }
    public Account(String who, double money){
      name = who;
      balance = money;
    }
    public void setName(String who){
      name = who;
    }
    public void setBalance(double money){
      balance = money;
    }
    public void setDeposit(double depositAmount){
      deposit = depositAmount;
    }
    public void setWithdraw(double withdrawAmount){
      withdraw = withdrawAmount;
    }
    public String getName(){
      return name;
    }
    public void calculateBalance(){
      balance = balance + deposit - withdraw;
    }
    public double getBalance(){
      return balance;
    }
    public String toString(){
      return "Name: " + name + ", Balance: $" + balance;
    }
    public void addInterest(int rate){
      balance = balance*(((double)rate/100)+1);
    }
}
public class BankAccount{
    public static void main(String[] args){
      Account account1 = new Account("Tara",500);
      account1.setWithdraw(500);
      account1.setDeposit(1600);
      account1.calculateBalance();
      System.out.println("Balance before adding interest");
      System.out.println(account1.toString());
  
      System.out.printf("%nBalance after adding interest%n");
      account1.addInterest(5);
      System.out.println(account1.toString());
    }
  }