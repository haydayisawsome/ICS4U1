class Fraction{
    private int numerator;
    private int denominator;
    
    public Fraction(){
        numerator = 0;
        denominator = 1;
    }
    public Fraction(int n,int d){
        numerator = n;
        denominator = d;
    }
    public void reduce(Fraction f){
        int max = Math.max(numerator,denominator);
        for (int i=2; i<max;i++){
            if (numerator % i == 0 && denominator % i == 0){
                numerator = numerator / i;
                denominator = denominator / i;
                i--;
            }
        }
    }
    public Fraction add(Fraction f1, Fraction f2){
        int min = Math.min(f1.getDenominator(),f2.getDenominator());
        int gcf = 1;
        int lcm;
        int d1 = f1.getDenominator();
        int d2 = f2.getDenominator();
        for (int i=2; i<=min;){
            if (d1 % i == 0 && d2 % i == 0){
                gcf *= i;
                d1 /= i;
                d2 /= i;
            }
            else{
                i++;
            }
        }
        lcm = gcf * d1 * d2;
        int n1 = (lcm / f1.getDenominator()) * f1.getNumerator();
        int n2 = (lcm / f2.getDenominator()) * f2.getNumerator();
        Fraction added = new Fraction (n1+n2,lcm);
        return added;
    }
    public Fraction addTo(Fraction that){
        int min = Math.min(denominator,that.getDenominator());
        int gcf = 1;
        int lcm;
        int d1 = denominator;
        int d2 = that.getDenominator();
        for (int i=2; i<=min;){
            if (d1 % i == 0 && d2 % i == 0){
                gcf *= i;
                d1 /= i;
                d2 /= i;
            }
            else{
                i++;
            }
        }
        lcm = gcf * d1 * d2;
        int n1 = (lcm / denominator) * numerator;
        int n2 = (lcm / that.getDenominator()) * that.getNumerator();
        Fraction added = new Fraction (n1+n2,lcm);
        return added;
    }
    public String toString (){
        return "("+numerator+" / "+denominator+")";
    }
    public int getNumerator(){
        return numerator;
    }
    public int getDenominator(){
        return denominator;
    }
}
public class FractionTester{
    public static void main(String[]args){
        Fraction frac1 = new Fraction(1,2);
        Fraction frac2 = new Fraction(2,8);
        Fraction fracAdd = frac1.add(frac1,frac2);
        System.out.println("Fraction 1: "+frac1.toString());
        System.out.println("Fraction 2: "+frac2.toString());
        System.out.println();
        
        System.out.println("Using add method, unsimplified: " + fracAdd.toString());
        fracAdd.reduce(fracAdd);
        System.out.println("Using add method, simplified: " + fracAdd.toString());
        System.out.println();
        
        Fraction fracAddTo = frac1.addTo(frac2);
        System.out.println("Using addTo method, unsimplified: "+fracAddTo.toString());
        fracAddTo.reduce(fracAddTo);
        System.out.println("Using addTo method, simplified: "+fracAddTo.toString());
    }
}