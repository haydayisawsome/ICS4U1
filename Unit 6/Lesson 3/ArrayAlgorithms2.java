/**#
 * Author:  Isaac Man
 * Date:    April 4, 2024
 * Subject: Array algorithms
 */

public class ArrayAlgorithms2{
    public static void main (String[] args){
        int[]a = {2,4,7,18,15,22};
        printArray(a);
        System.out.println("Swapping 4 with 15");
        printArray(swap(a,1,4));
        int[]b = {4,1,9,5,11};
        printArray(b);
        printArray(sort(b));
        
        String[]name = {"Romy", "Zoran", "Ali", "Warren", "Joshua"};
        printArray(name);
        printArray(sort(name));
    }
    public static void printArray(int[]a){
        for (int i = 0;i<a.length;i++){
            System.out.print(a[i]+"\t");
        }
        System.out.println();
    }
    public static void printArray(String[]a){
        for (int i = 0;i<a.length;i++){
            System.out.print(a[i]+"\t");
        }
        System.out.println();
    }
    public static int[] swap(int[]a,int indexA,int indexB){
        int temp = a[indexA];
        //# creates a temp value holder that holds the value of indexA
        a[indexA]=a[indexB];
        //# replaces the indexA value with the indexB value
        a[indexB]=temp;
        //# replaces the indexB value with the temp value
        return a;
    }
    
    //# sorting by swapping 
    public static int[] sort(int[]a){
        for (int i = 0;i<a.length;i++){
            for (int j = i+1;j<a.length;j++){
                if (a[i]>a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }
    
    //# sorting alphabetically
    //# you can use the same name but must have different
    //# num/types of parameters for overloaded method
    public static String[] sort(String[]s){
        for (int i = 0;i<s.length;i++){
            for (int j = i+1;j<s.length;j++){
                if (s[i].compareTo(s[j])>0){
                    String temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }
        return s;
    }
}