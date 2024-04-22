import java.io.*;
import java.util.*;

public class ReadingFile{
    public static void main (String[] args) throws IOException{
        double test1,test2,test3;
        double average;
        String name;
       
        FileReader fr = new FileReader ("TESTfile.txt");
       
        Scanner inFile = new Scanner (fr);
        System.out.println(inFile);
       
        PrintWriter outFile = new PrintWriter("TestAverage.txt");
       
        while(inFile.hasNext()){
            name = inFile.next();
            outFile.println("Student Name: "+name);
           
            test1 = inFile.nextDouble();
            test2 = inFile.nextDouble();
            test3 = inFile.nextDouble();
           
            outFile.printf("Test scores: %10.2f%10.2f%10.2f",test1,test2,test3);
            average = (test1+test2+test3)/3;
            outFile.printf("\nAverage test score: %5.2f",average);
            outFile.println();
        }
        inFile.close();
        outFile.close();
    }
}