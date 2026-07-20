package try_catch;

public class tryCatchExample {

    public static int division(int  a, int b) throws ArithmeticException {

        return a/b;
    }

    public static void main(String[] args) {
            int m = 3;
            int n = 0;
            try {
            System.out.println(division(m,n));
            }catch (ArithmeticException e) {
                System.out.println("division by zero not allowed");
            }
    }
}
