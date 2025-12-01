public interface Animal {
    void makeSound();
    void eat();
}

class Dog implements Animal {

    @Override
    public void makeSound() {
        System.out.println("Dog bark...");
    }

    @Override
    public void eat() {
        System.out.println("Dudh-roti");
    }

    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.eat();
        dog.makeSound();
    }
}