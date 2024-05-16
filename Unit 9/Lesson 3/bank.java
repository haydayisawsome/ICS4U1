public class bank implements RBC,TD{
    public static void main(String[]args){
        
    }
    public void interestRateRBC(){
        System.out.println("RBC interest rate is 5%");
    }
    public void interestRateTD(){
        System.out.println("TD interest rate is 10%");
    }
}
interface RBC{
    public void interestRateRBC();
}
interface TD{
    public void interestRateTD();
}