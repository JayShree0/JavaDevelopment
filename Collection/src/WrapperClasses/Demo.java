package WrapperClasses;

public class Demo {
    public static void main(String[] args) {

        // ✅ valueOf(): primitive ya string ko wrapper object banata hai
        Integer i = Integer.valueOf(20);      // int → Integer object
        Integer i2 = Integer.valueOf("123");  // String → Integer object

        System.out.println(i);   // 20
        System.out.println(i2);  // 123

        // ✅ parseXxx(): String ko primitive me convert karta hai
        int obj1 = Integer.parseInt("2323"); // String → int
        boolean aTrue = Boolean.parseBoolean("true"); // String → boolean
        System.out.println(obj1);   // 2323
        System.out.println(aTrue);  // true

        // ✅ Wrapper class se primitive extract karna (unboxing by method)
        Double d = 9.88;           // Autoboxing: double → Double
        int i3 = d.intValue();     // Double object se primitive int
        System.out.println(i3);    // 9 (decimal part truncate)

        // ✅ Wrapper caching demo
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);
        // TRUE → kyunki -128 se 127 tak ke Integer values cache me store hote hain,
        // dono same object ko point karte hain

        Integer c = 1000;
        Integer f = 1000;
        System.out.println(c == f);
        // FALSE → kyunki 1000 cache range ke bahar hai,
        // isliye alag alag objects banenge

        // ✅ Agar content compare karna hai to equals() use karo
        System.out.println(c.equals(f)); // TRUE (kyunki value same hai)
    }
}
