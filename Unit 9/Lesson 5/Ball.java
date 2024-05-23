import javax.swing.*;
import java.awt.*;

public class Ball extends JPanel{
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillOval(50,100,50,50);
    }
}