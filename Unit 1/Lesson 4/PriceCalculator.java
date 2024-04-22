import javax.swing.JOptionPane;

public class PriceCalculator{
    public static void main (String[] args){
        double price;
        String priceStr;
        double num;
        String numStr;
        
        priceStr = JOptionPane.showInputDialog(null,"Please enter the price: ");
        price = Double.parseDouble(priceStr);
        
        numStr = JOptionPane.showInputDialog(null,"Please enter the number: ");
        num = Double.parseDouble(numStr);
        
        double total = (price*num)*1.13;
        
        System.out.printf("Total price: $%.2f%n",total);        
    }
}