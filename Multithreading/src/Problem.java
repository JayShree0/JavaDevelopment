// Shared resource class
class Counter {
    int count = 0;

    // increment method (❌ not synchronized)
    // Problem: agar multiple thread ek saath is method ko call karenge
    // to value overwrite ho sakti hai (data inconsistency ho jayegi)
    void increment() {
        count++;
    }
}

// Thread-1 class
class MyThread3 extends Thread {
    Counter c; // shared counter ka reference

    MyThread3(Counter c) {
        this.c = c; // constructor se shared object pass karte hain
    }

    @Override
    public void run() {
        // thread 1 → counter ko 1000 baar increment karega
        for (int i = 0; i < 1000; i++) {
            c.increment();
        }
    }
}

// Thread-2 class
class MyThread4 extends Thread {
    Counter c; // shared counter ka reference

    MyThread4(Counter c) {
        this.c = c; // constructor se shared object pass karte hain
    }

    @Override
    public void run() {
        // thread 2 → counter ko 1000 baar increment karega
        for (int i = 0; i < 1000; i++) {
            c.increment();
        }
    }
}

// Main class
public class Problem {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter(); // ek hi Counter object banaya (shared resource)

        // dono threads ko same Counter object diya
        MyThread3 t1 = new MyThread3(c);
        MyThread4 t2 = new MyThread4(c);

        // threads ko start kiya
        t1.start();
        t2.start();

        // join → main thread wait karega jab tak t1 aur t2 khatam na ho jaye
        t1.join();
        t2.join();

        // theoretically result 2000 hona chahiye
        // lekin synchronization problem ke wajah se value kabhi 2000 se kam aa sakti hai
        System.out.println("Final Count: " + c.count);
    }
}
