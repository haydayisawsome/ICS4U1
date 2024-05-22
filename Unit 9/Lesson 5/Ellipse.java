import javax.swing.*;
import java.awt.*;

public class Ellipse extends JPanel{
    public void draw(Graphics g){
        g.setColor(Color.blue);
        g.fillOval(50,300,50,50);
    }
}