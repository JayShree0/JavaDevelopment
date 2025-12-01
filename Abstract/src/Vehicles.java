public abstract class Vehicles {
    String brand;

    Vehicles(String brand) {
        this.brand = brand;
    }

    abstract void start();

    public void m1() {
        System.out.println("hello m1");
    }
}



