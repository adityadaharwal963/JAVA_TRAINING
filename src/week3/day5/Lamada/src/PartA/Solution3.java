package PartA;

import java.util.ArrayList;

public class Solution3 {
    static void main() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);

        arrayList.stream()
                .filter(e->e%2==0)
                .map(e->e*e)
                .forEach(System.out::println);
    }
}
