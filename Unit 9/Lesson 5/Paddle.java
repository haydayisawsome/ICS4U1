import javax.swing.*;
import java.awt.*;

public class Paddle extends JPanel{
    public void draw(Graphics g){
        g.setColor(Color.green);
        g.fillRect(50,200,100,30);
    }
}