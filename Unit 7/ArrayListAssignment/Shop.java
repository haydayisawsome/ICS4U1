
import java.util.*;

public class Shop{
    public static void main(String[]args){
        Item item;
        String itemName;
        double itemPrice;
        int quantity;
        double total = 0;
        ArrayList<Item> cart = new ArrayList<Item>();
        
        String keepShopping = "y";
        
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the name of the item: ");
            itemName = sc.nextLine();
            System.out.print("Enter the unit price: ");
            itemPrice = sc.nextDouble();
            System.out.print("Enter the quantity: ");
            quantity = sc.nextInt();
            item = new Item(itemName,quantity,itemPrice);
            cart.add(item);
            System.out.println(item);
            System.out.print("Continue shopping (y/n)? ");
            keepShopping = sc.nextLine();
            keepShopping = sc.nextLine();
            total += item.getUnitPrice() * item.getQuantity();
        } while (keepShopping.equals("y"));
        System.out.println();
        System.out.println("Item\t     Quantity\t     Unit Price\t        Total");
        for (int i = 0;i<cart.size();i++){
            System.out.println(cart.get(i));
        }
        System.out.println("Total: "+total);
    }
}