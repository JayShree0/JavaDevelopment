package org.cfs;

public class Car {


    private Engine engine;

    // constructor
    public Car(Engine engine){
        System.out.println("Car Constructor running...");
        this.engine = engine;
    }

    // for setter DI
    public void setEngine(Engine engine) {
        System.out.println("setter constructor....");
        this.engine = engine;
    }



    public void drive() {
        int start = engine.start();
        if(start >= 1){
            System.out.println("Lets drive");
        }
        else{
            System.out.println("Engine not started yet..");
        }
    }
}
