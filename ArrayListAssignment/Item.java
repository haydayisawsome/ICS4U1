public class Item{
    private String itemName;
    private int quantity;
    private double unitPrice;
    
    public Item(){
        itemName = "unknown";
        quantity = 0;
        unitPrice = 0;
    }
    public Item(String in,int q, double up){
        itemName = in;
        quantity = q;
        unitPrice = up;
    }
    
    public String getItemName(){
        return itemName;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getUnitPrice(){
        return unitPrice;
    }
    
    public String toString(){
        return itemName + "\t\t" + quantity + "\t\t" + unitPrice + "\t\t" + unitPrice*quantity;
    }
}