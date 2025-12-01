package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {

        // Create a thread pool of 8 threads
        // (At most 8 tasks will run in parallel)
        ExecutorService service = Executors.newFixedThreadPool(8);

        // Student list to whom certificates will be sent
        String[] studentList = {
                "Riya", "Raj", "Jay", "Rohit", "Anita",
                "Karan", "Meena", "Sohan", "Priya", "Arjun",
                "Simran", "Aman", "Neha", "Vikas", "Pooja"
        };

        // For each student, create a task and submit it to the pool
        for (String student : studentList) {
            CertificationSender task = new CertificationSender(student);
            service.submit(task);
        }

        // Shutdown the executor service
        // (No new tasks will be accepted, but existing tasks finish execution)
        service.shutdown();
    }
}
