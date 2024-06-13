package demo;

/*
V = (4.0,  5.0,  6.0)
U = (1.0, 2.0,  3.0
Sum of vectors = (5.0, 7.0, 9.0)
Cross Product = (3.0, -6.0, 3.0)
Dot Product = 32
 */

public class VectorTester{
    public static void main(String[] args) {
        Vector V = new Vector(4,5,6);
        Vector U = new Vector(1,2,3);
        System.out.println("V = " + V);
        System.out.println("U = " + U);
        System.out.println("Sum of vectors = " + V.sum(V,U));
        System.out.println("Cross Product = " + V.crossProduct(V,U));
        System.out.println("Dot Product: " + V.dotProduct(V,U));
    }
}

class Vector{
    private double Vx;
    private double Vy;
    private double Vz;
    public Vector(){
        Vx = 0;
        Vy = 0;
        Vz = 0;
    }
    public Vector(double x, double y, double z){
        Vx = x;
        Vy = y;
        Vz = z;
    }
    public double getX(){
        return Vx;
    }
    public double getY(){
        return Vy;
    }
    public double getZ(){
        return Vz;
    }
    public Vector sum(Vector v, Vector u){
        return new Vector(v.getX()+u.getX(),v.getY()+u.getY(),v.getZ()+u.getZ());
    }
    public Vector crossProduct(Vector v, Vector u){
        return new Vector(v.getY()*u.getZ() - u.getY()*v.getZ(),  u.getX()*v.getZ() - v.getX()*u.getZ(), v.getX()*u.getY() - u.getX()*v.getY());
    }
    public double dotProduct(Vector v, Vector u){
        return v.getX()*u.getX() + v.getY()*u.getY() + v.getZ()*u.getZ();
    }
    public String toString(){
        return "(" + Vx + ", " + Vy + ", "  + Vz + ")";
    }
}