package StackDemo;

import java.util.*;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(70);
        set.add(140);
        set.add(330);
        set.add(40);
        System.out.println(set); // [10, 40, 70, 140, 330]
    }
}
