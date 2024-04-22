import java.util.Scanner;
import java.io.*;

public class MarkReader{
    public static void main (String[] args) throws IOException{
        //asking student to enter name and marks on 4 tests
        String name = "";
        double mark1, mark2, mark3, mark4;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        name = sc.nextLine();
        System.out.println("Enter mark on first test: ");
        mark1 = sc.nextDouble();
        System.out.println("Enter mark on second test: ");
        mark2 = sc.nextDouble();
        System.out.println("Enter mark on third test: ");
        mark3 = sc.nextDouble();
        System.out.println("Enter mark on fourth test: ");
        mark4 = sc.nextDouble();
        
        //prints results in marks.txt
        PrintWriter results = new PrintWriter("marks.txt");
        results.printf("%s%10.2f%10.2f%10.2f%10.2f",name,mark1,mark2,mark3,mark4);
        
        //reads results in marks.txt
        FileReader fr = new FileReader("marks.txt");
        Scanner inFile = new Scanner(fr);
        
        String Name = "anonymus";
        double m1 = 0;
        double m2 = 0;
        double m3 = 0;
        double m4 = 0;
        while(inFile.hasNext()){
            Name = inFile.next();
            m1 = inFile.nextDouble();
            m2 = inFile.nextDouble();
            m3 = inFile.nextDouble();
            m4 = inFile.nextDouble();
        }
        
        //calculating and writing in averagMark.txt
        PrintWriter outFile = new PrintWriter("averagMark.txt");
        double avrg = (m1+m2+m3+m4)/4;
        outFile.printf("Student name: %s",Name);
        outFile.printf("%nMark 1: %7.2f%nMark 2: %7.2f%nMark 3: %7.2f%nMark 4: %7.2f",m1,m2,m3,m4);
        outFile.printf("%nAverage: %5.2f",avrg);
        
        results.close();
        fr.close();
        inFile.close();
    }
}