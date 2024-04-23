class ThisKeyword {
    int x = 5;
    int y = 2;
    public ThisKeyword(int x){
        x = x;
        y = this.x;
    }
    public 
}
public class ThisKeywordTester{
    ThisKeyword x = new ThisKeyword(3);
}