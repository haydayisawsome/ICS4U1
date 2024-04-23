import java.util.Scanner;
public class DeliveryChargeCalculator{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the type of package: ");
        String packageType = sc.nextLine();
        System.out.println("Enter the type of service: ");
        String service = sc.nextLine();
        System.out.println("Enter the weight of the package: ");
        double weight = sc.nextDouble();
        double cost  = 0;
        
        System.out.println("Type of Package: \t"+packageType);
        System.out.println("Type of Service: \t"+service);
        System.out.printf("Weight of Package(oz): \t%.0f\n",weight);
        
        if (service.equals("Next Day Priority")){
            if (packageType.equals("Letter")){
                if (weight > 8){
                    System.out.println("");
                    System.out.println("This service is not available for weights greater than 8 oz.");
                }
                else if (weight <= 8){
                    cost = 12;
                    System.out.printf("Cost of Delivery: \t%.2f",cost);
                }
            }
            if (packageType.equals("Box")){
                if (weight > 16){
                    cost = 15.75 + 1.25*Math.floor(weight/16-1);
                }
                if (weight <= 16){
                    cost = 15.75 + 1.25*Math.ceil(weight/16-1);
                }
                System.out.printf("Cost of Delivery: \t%.2f",cost);
            }
        }
        else if (service.equals("Next Day Standard")){
            if (packageType.equals("Letter")){
                if (weight > 8){
                    System.out.println("");
                    System.out.println("This service is not available for weights greater than 8 oz.");
                }
                else if (weight <= 8){
                    cost = 10.5;
                    System.out.printf("Cost of Delivery: \t%.2f",cost);
                }
            }
            if (packageType.equals("Box")){
                if (weight > 16){
                    cost = 13.75 + Math.floor(weight/16-1);
                }
                if (weight <= 16){
                    cost = 13.75 + Math.ceil(weight/16-1);
                }
                System.out.printf("Cost of Delivery: \t%.2f",cost);
            }
        }
        else if (service.equals("Two-Day")){
            if (packageType.equals("Letter")){
                if (weight > 8){
                    System.out.println("");
                    System.out.println("This serice is not available for weights greater than 8 oz.");
                }
                if (weight <= 8){
                    System.out.println("");
                    System.out.println("This service is not available for weights less than 8 oz.");
                    System.out.println("Please use Next Day Standard or Next Day Priority.");
                }
            }
            if (packageType.equals("Box")){
                if (weight > 16){
                    cost = 7 + 0.5*Math.floor(weight/16-1);
                }
                if (weight <= 16){
                    cost = 7 + 0.5*Math.ceil(weight/16-1);
                }
                System.out.printf("Cost of Delivery: \t%.2f",cost);
            }
        }
    }
}