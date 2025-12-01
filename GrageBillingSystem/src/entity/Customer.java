package entity;

public class Customer {

    // Fields representing customer data
    private int id;
    private String name;
    private String phone;

    // Constructor to initialize customer
    public Customer(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Customer() {

    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Readable output format
    @Override
    public String toString() {
        return "[ Customer id = " + id + ", name = " + name + ", phone = " + phone + " ]";
    }
}
