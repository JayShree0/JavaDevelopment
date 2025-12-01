package MapDemo.HashMapDemo;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap {
    public static void main(String[] args) {

        // ✅ HashMap creation (Key = String, Value = Integer)
        Map<String, Integer> map = new HashMap<>();

        // ✅ put(): Add key-value pairs
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("duplicate two", 2);

        // ✅ null key: HashMap me ek hi null key allow hoti hai
        map.put(null, 6);
        map.put(null, 7); // Overwrites previous null → final value = 7

        // ✅ get(): fetch value from key
        System.out.println("Get value of key 'four' : " + map.get("four")); // 4

        // ✅ containsKey(): check key present hai ya nahi
        if (map.containsKey("four")) {
            System.out.println("Key 'four' exists, Value: " + map.get("four")); // 4
        }

        System.out.println("\n--- Traversing HashMap ---");

        // 1️⃣ Traversing using keySet() → get all keys
        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        System.out.println();
        System.out.println("\n--- Traversing using values() ---");

        // 2️⃣ Traversing using values() → get all values
        for (Integer value : map.values()) {
            System.out.println("Value: " + value);
        }

        System.out.println();
        System.out.println("\n--- Traversing using entrySet() ---");

        // 3️⃣ Traversing using entrySet() → get key + value together
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        System.out.println();
        System.out.println("\n--- Traversing using forEach ---");

        // 4️⃣ Traversing using Java 8 forEach (lambda expression)
        map.forEach((key, value) -> {
            System.out.println("Key: " + key);
            System.out.println("Value: " + value);
        });
    }
}
