import com.sun.security.jgss.GSSUtil;

public class Q2 {
    public static void main(String[] args) {
        try{
            int x = 100/0;
            System.out.println("hello div");
        }
        catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
        }
        System.out.println("Done");
    }
}
