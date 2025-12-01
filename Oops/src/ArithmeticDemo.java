public class ArithmeticDemo {
    public static void main(String[] args) {
        String s = null;
        try{
            int length = s.length();
        }
//        yeah nhi chllega kyu ky yeah pakar nhi piyega kyuky yeah ArithmeticException exception nhi hai to isko parent pakar lega
        catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
        }
//        isko runtimeException pakar laka iska parent
        catch (RuntimeException e) {
            System.out.println("RuntimeException");
        }
        // pehla exception iska child pakar liya aur wo chllega kyu ky upper rekha hai hai to yeah nhi chllega
        catch (Exception e) {
            System.out.println("Exception");
        }
        finally {
            System.out.println("Finally.....");
        }
    }
}
