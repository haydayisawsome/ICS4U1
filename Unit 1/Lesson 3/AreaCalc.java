//writing a class that asks the user to enter width and length
//of the rectangle in a dialog box, then calculates and prints
//the area of a rectangle in a dialog box
import javax.swing.*;
public class AreaCalc{
    public static void main(String [] args){
        int length = 0;
        int width = 0;
        String w;
        String l;
       
        w = JOptionPane.showInputDialog("Enter width of rectangle");
        l = JOptionPane.showInputDialog("Enter length of rectangle");
        width = Integer.parseInt(w);
        length = Integer.parseInt(l);
        int area = length *width;
        String result = Integer.toString(area);
        JOptionPane.showMessageDialog(null,"Your area is: "+result);
    }
}