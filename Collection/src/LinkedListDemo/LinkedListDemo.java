package LinkedListDemo;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Jay");
        list.add("Raman");
        list.add("Rohit");
        list.add("Raj");
        list.add("Jyoti");
        list.add("jaya");

        // fetch
        String first = list.getFirst();
        String last = list.getLast();


        System.out.println("First element : " + first);
        System.out.println("Last element : " + last);
    }
}
