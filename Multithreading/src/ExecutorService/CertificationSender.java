package ExecutorService;

// Each task implements Runnable, so it can be executed by a thread
public class CertificationSender implements Runnable {

    private final String stdName;

    // Constructor to initialize student name
    public CertificationSender(String stdName) {
        this.stdName = stdName;
    }

    @Override
    public void run() {
        // Print which thread is sending the certificate
        System.out.println("Sending certificate to " + stdName +
                " | by thread: " + Thread.currentThread().getName());

        try {
            // Simulate time taken to send certificate (2 sec delay)
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Print confirmation after sending
        System.out.println("Certificate sent to " + stdName +
                " | by thread: " + Thread.currentThread().getName());
    }
}
