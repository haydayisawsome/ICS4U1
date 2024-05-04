package _Shooter_Game_;

import java.awt.*;

class Ammo{
    private int posX;
    private int posY;
    private int angle;
    final private int size;
    final private int speed;

    //overloaded constructor
    public Ammo(int posX, int posY, int angle, int size, int speed){
        this.size = size;
        this.angle = angle;
        this.posX = posX;
        this.posY = posY;
        this.speed = speed;
    }
    //method for moving ammo
    public void paint (Graphics g){
        super.paint(g);
    }
    //method for hitting enemy
}
