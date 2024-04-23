import java.util.Scanner;
public class WeatherActivities{
    public static void main(String[]args){
        System.out.println("Guides for Lake LazyDays Activities\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the temperature: ");
        int temp = sc.nextInt();
        String activity = "";
        if (temp > 95){
            activity = "Visiting our shops";
        }
        else if (temp <= 95 && temp >= 80){
            activity = "Swimming";
        }
        else if (temp < 80 && temp >= 60){
            activity = "Tennis";
        }
        else if (temp < 60 && temp >= 40){
            activity = "Golf";
        }
        else if (temp < 40 && temp >= 20){
            activity = "Skiing";
        }
        else if (temp < 20){
            activity = "Visiting our shops";
        }
        
        System.out.println(activity+ " is the best option");
    }
}