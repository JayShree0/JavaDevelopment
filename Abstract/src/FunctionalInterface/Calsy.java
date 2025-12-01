package Abstract.src.FunctionalInterface;

public interface Calsy {
    int add(int a, int b);

    default void m1() {
        System.out.println("Hello......");
    }
}

// before java 1.8 to give implementation pure Oops
class Child implements Calsy {

    @Override
    public int add(int a, int b) {
        return 0;
    }
}

class Driver {
    public static void main(String[] args) {

        // After java 1.8
        Calsy operation = (a,b) -> a + b;
        System.out.println(operation.add(5,5));
    }
}
