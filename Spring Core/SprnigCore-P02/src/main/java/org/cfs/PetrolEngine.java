package org.cfs;

public class PetrolEngine implements Engine{
    public PetrolEngine() {
        System.out.println("Petrol constructor running......");
    }

    @Override
    public int start() {

        return 1;
    }
}
