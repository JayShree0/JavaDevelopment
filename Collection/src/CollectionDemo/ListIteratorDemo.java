package CollectionDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.List;

public class ListIteratorDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("java", "dsa", "python", "devOps"));
        ListIterator<String> li = list.listIterator();
        System.out.println("Forward direction...");

        while(li.hasNext()) {
            String data = li.next();
            System.out.println(data);
            if(data.equals("python")) {
                li.set("React");
            }
        }

        System.out.println("Backward direction");
        while(li.hasPrevious()) {
            System.out.println(li.previousIndex());
        }
        System.out.println(list);
    }
}
