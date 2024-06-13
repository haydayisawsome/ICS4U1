package demo;

import java.util.ArrayList;
import java.util.Arrays;

public class demo {
    public static void main(String[] args) {
        ArrayList<String> myFriends = new ArrayList<String>(Arrays.asList("Maria",
        "Minoo","Mina","Maryam"));  
        myFriends.add(2, "Mitra");
        System.out.println(myFriends);

        myFriends.remove("Minoo");
        System.out.println(myFriends);
        
        myFriends.set(1,"Ann");
System.out.println(myFriends);

    }
}
