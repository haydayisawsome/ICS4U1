import java.awt.Graphics;
import javax.swing.*;
public class MyPanel extends JPanel{
    Ball ball;
    Paddle paddle;
    Ellipse ellipse;

    public MyPanel(){
        ball = new Ball();
        add(ball);
        paddle = new Paddle();
        add(paddle);
        ellipse = new Ellipse();
        add(ellipse);
    }
    public void paint(Graphics g){
        ball.draw(g);
        paddle.draw(g);
        ellipse.draw(g);
    }
}