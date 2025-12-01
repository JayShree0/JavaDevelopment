public class Thar extends Vehicles {

    Thar(String brand) {
        super(brand);  // 🔴 important point
        System.out.println("Thar constructor called");  // apna kaam
    }

    @Override
    void start() {
        System.out.println(brand + " is starting...");
    }

    public static void main(String[] args) {
        Thar t = new Thar("Mahindra");
        t.start();
        t.m1();
    }
}