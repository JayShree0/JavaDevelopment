package CollectionDemo;

import java.util.ArrayList;
import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        // insertion order
        // Duplicate allowed
        // random access allowed
        // index access

        // parent child ka object hold kr sekta hai
        List<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(20);
        nums.add(30);
        nums.add(10);
        nums.add(50);
        nums.add(60);
        nums.add(2, 70);
        System.out.println(nums); // [10, 20, 30, 10, 50, 60]
        System.out.println("size of arrayList is : " + nums.size());
        System.out.println("Remove the element at index arr[4] : " + nums.remove(4));
        System.out.println(nums.isEmpty());

        System.out.println(nums.get(3)); // 10

        Iterator<Integer> it = nums.iterator();
        while (it.hasNext()) {
            int data = it.next();
            if (data == 30) {
                System.out.println("Removing 30");
                it.remove();
            } else {
                System.out.println(data);
            }
        }
    }
}