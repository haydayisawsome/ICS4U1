package _Shooter_Game_;

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

    //setters and getters (dont need to set size/angle/speed, always the same)
    public void setPosX(int newPosX){
        posX = newPosX;
    }
    public void setPosY(int newPosY){
        posY = newPosY;
    }
    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
    public int getAngle(){
        return angle;
    }
    public int getSpeed(){
        return speed;
    }
    public int getSize(){
        return size;
    }
}