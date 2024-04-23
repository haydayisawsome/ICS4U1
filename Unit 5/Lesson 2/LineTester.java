/**
 * Author:  Isaac Man
 * Date:    March 19, 2024
 * Subject: Instance variables as reference
 */

class Line{
    Point p1;
    Point p2;
    public Line(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    
    public double slope(){
        double S = (p2.getY() - p1.getY()) / (p2.getX() - p1.getY());
        return S;
    }
}
public class LineTester{
    public static void main(String[]args){
        Point p1 = new Point(2,8);
        Point p2 = new Point(3,10);
        Line line = new Line(p1,p2);
        System.out.println(line.slope());
    }
}