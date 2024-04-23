public class Point{
    private double x;
    private double y;
    public Point (){
        x = 0;
        y = 0;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setX(double x){
        x = this.x;
    }
    public void setY(double y){
        y = this.y;
    }
    public String toString(){
        return "(" + x + "," + y + ")";
    }
}
class Line {
    //p1 and p2 are two point on the line 
    private Point p1;
    private Point p2;
    
    //Overloaded constructor
    public Line(Point p1,Point p2){
	this.p1 = p1;
	this.p2 = p2;
    }
    
    //a method that returns the slope of the current  line
    public double slope(){
        return (p2.getY() - p1.getY())/(p2.getX() - p1.getX());
    }
 
    //a method that checks if the current line is perpendicular 
    //to the line given in the header of the method
    public boolean isPerpendicular(Line that){
        return (that.slope() * slope()) == -1;
    }

    //a method that checks if the current line is parallel to the line given in the header of  //the method
    public boolean isParallel(Line that){
        return (that.slope() * slope()) == 1;
    }

    //a method that returns the the coordinates of the current line
    public Point x_int(){
	return Point(p1,p2);
	return Point(p
    }
    
    //a method that returns the coordinates of the y-int of the current line
    public Point y_int(){
	//Complete
    }
    //a method that checks if the current line is horizontal.
    public boolean isHorizontal(){
         //Complete
    }
    //a method that checks if the current line is vertical.
    public boolean isVertical(){
        //complete
    }
    //a method that prints the equation of the current line
    public void lineEquation(){
      //Complete
    }
    //a method that returns the coordinates of the point of intersection of the current line //with the line given in the header of the method
    public Point intersection(Line that){
	//Complete
    }

}
