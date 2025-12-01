class JoinThread extends Thread {

    @Override
    public void run() {
        for(int i = 0; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Child thread");
        }
    }
}


public class JoinDemo {
    public static void main(String[] args) throws InterruptedException{
        JoinThread j1 = new JoinThread();
        j1.start();
        j1.join(); // main -> jo line execute krega wahi wait krega

        for(int i = 0; i < 3; i++) {
            System.out.println("main thread");
        }
    }
}
