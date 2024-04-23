/**
 * Author:  Isaac Man
 * Date:    March 18, 2024
 * Subject: Methods with reference variables
 */

class Point{
    //instance variables
    private double x;
    private double y;
    //defult constructor
    public Point(){
        x=0;
        y=0;
    }
    //overloaded constructor
    public Point(double x,double y){
        this.x=x;
        this.y=y;
        //"this." is used to call variables with the same name as parameters
    }
    //a method to find the distance of 2 points
    public double distance(Point p1, Point p2){
        //these parameters calls methods in the same class
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        double dist = Math.sqrt(dx*dx+dy*dy);
        return dist;
    }
    //a method that accepts two reference variables and returns a reference 
    //variable
    public Point midPoint(Point p1,Point p2){
        double midX = (p1.x+p2.x)/2;
        double midY = (p1.y+p2.y)/2;
        return new Point(midX,midY);
    }
    public String toString(){
        return "(" +x+ "," +y+ ")";
    }
}
//Tester Class
public class PointTester{
    public static void main(String[]args){
        //create first two points
        Point p1 = new Point(3,5);
        Point p2 = new Point(6,9);
        System.out.println(p1.distance(p1,p2));
        //you dont need to call an object to call a method if the method
        //is in the same class as the main method
        Point mid = p1.midPoint(p1,p2);
        System.out.println(mid.toString());
    }
}