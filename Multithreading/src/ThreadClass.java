class MyThread1 extends Thread {

    @Override
    public void run() {
        System.out.print(Thread.currentThread().getName());
    }
}

public class ThreadClass {
    public static void main(String[] args) {

        /*
         * start()  -> ek naya thread create karta hai aur uske run() method ko call karta hai
         * run()    -> thread ka actual task yaha likha jata hai (ye method automatically start() ke andar se call hota hai)
         * getName()-> thread ka naam return karta hai (by default -> Thread-0, Thread-1 ...)
         * setName()-> thread ka custom naam set karne ke liye use hota hai
         * setPriority() -> thread ki priority set karne ke liye (1 = MIN, 5 = NORM (default), 10 = MAX)
         *
         **/

        System.out.println(Thread.currentThread().getName());
        Thread t = Thread.currentThread();
        t.setName("mera thread");
        System.out.println(Thread.currentThread().getName());

        MyThread1 t1 = new MyThread1();
        t1.setName("Child-Thread");
        t1.start();

    }
}

