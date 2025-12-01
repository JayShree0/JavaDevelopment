package LambdaExpression;

public class Test {
    public static void main(String[] args) {
        ThreadB t = new ThreadB();
        t.start();

        for(int i = 0; i < 5; i++) {
            System.out.println("main....");
        }
    }
}
