import java.util.Scanner;
public class LoopingPractice3{
    public static void main(String[]args){
        System.out.print("Distance to destination: ");
        Scanner sc = new Scanner (System.in);
        double distance = sc.nextDouble();
        System.out.println("");
        double walk = 0;
        while (walk < distance){
            System.out.print("Step 1 Distance: ");
            double step = sc.nextDouble();
            walk+=step;
            System.out.printf("       Total is %.2f km\n",walk);
        }
        System.out.println("\nYou have reached your destination.");
    }
}