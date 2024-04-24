


import java.util.*;
import java.util.Arrays;
public class myArrayListsTester {
    public static void main(String[]args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list = myArrayLists.numbers(20);
        System.out.println(list);


        ArrayList<String> names = new ArrayList<String>(Arrays.asList("Isaac","Ali","Jacob","Sebastion","Mazz","Minoo"));
        System.out.println(myArrayLists.search(list,3));
        System.out.println(myArrayLists.sort(list));
        System.out.println(myArrayLists.swap(list,19,1));
        System.out.println(myArrayLists.shuffle(list));
        System.out.println(myArrayLists.reverse(list));
        System.out.println(myArrayLists.insert(names,4,"Bob"));
        System.out.println(myArrayLists.takeOut(names,2));
        System.out.println(myArrayLists.takeOut(names,"Isaac"));
    }
}