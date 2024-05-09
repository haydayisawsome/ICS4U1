// Question 6 and 7
public class SeatingPlan {
    String name;
    int row;
    int col;

    public SeatingPlan(String name, int row, int col){
        this.name = name;
        this.row = row;
        this.col = col;
    }
    public String toString(){
        return name + "(" + row + "," + col + ")";
    }
}
