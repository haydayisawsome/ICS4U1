public class MathClassMethods{
    public static void main(String[]args){
        Double hehe = 3.45982;
        System.out.println(Math.floor(hehe));       //3
        System.out.println(Math.ceil(hehe));        //4
        System.out.println(Math.round(hehe));       //3
        Double jeje = 4.0;                          
        System.out.println(Math.pow(jeje,2));       //16
        System.out.println(Math.sqrt(jeje));        //2
        System.out.println(Math.max(hehe,jeje));    //4.0
        System.out.println(Math.min(hehe,jeje));    //3.45982
        System.out.println(5 % 2);                  //1
        System.out.println(Math.sin(90));           //1
        //print random num from 28 to 42
        System.out.println((Math.random())*14+28);
        System.out.println(Math.log(100));          //log 100 with base of e
        System.out.println(Math.log10(100));        //2
        System.out.println(Math.exp(3));            //e^5
        
        /**
         * floor        Math.floor(x);
         * ciel         Math.ciel(x);
         * round        Math.round(x);
         * max          Math.max(x,y);
         * min          Math.min(x,y);
         * pow          Math.pow(base,exponent);
         * sqrt         Math.sqrt(x);
         * log          Math.log(x);
         * log10        Math.log10(x);
         * exp          Math.exp(2);
         * sin          Math.sin(degrees);
         * random       (Math.random())*range)+lowestNum
         */
    }
}