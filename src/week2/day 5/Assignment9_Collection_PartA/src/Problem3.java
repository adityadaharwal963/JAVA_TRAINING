import kotlin.Pair;

import java.util.HashSet;
import java.util.Map;

public class Problem3 {
    /*
    Java HashSet – Count Unique Pairs
    Problem Statement:
    You are given N pairs of strings representing employee first name and last name.
    Print the number of unique name pairs.
     */
    static HashSet<Pair<String,String>> uniqueName = new HashSet<>();

    static void printNames(){
        System.out.println("First Name | Last Name");
        for(Pair<String,String> pair : uniqueName){
            System.out.println(pair.getFirst()+"  | "+pair.getSecond());
        }
    }

    public static void main(String[] args) {
        uniqueName.add(new Pair("john","tom"));
        uniqueName.add(new Pair("john","tom"));
        uniqueName.add(new Pair("mary","jane"));
        uniqueName.add(new Pair("john","jane"));
        uniqueName.add(new Pair("mary","jane"));
        printNames();
    }
}
