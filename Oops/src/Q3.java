public class Q3 {
    public static void main(String[] args) {
        try{
            int arr[] = {10, 20, 23};
            System.out.println(arr[4]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("hello finally");
        }
    }
}
