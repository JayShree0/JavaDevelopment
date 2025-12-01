package Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(9);
        arrayList.add(10);
        arrayList.add(33);
        arrayList.add(2);
        System.out.println(arrayList);
        Collections.sort(arrayList);
        System.out.println(arrayList); // sorting class

    }
}
