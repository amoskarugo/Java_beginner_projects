package try_catch;

public class tryCatchExample2 {

    public static void main(String[] args) {
        try {
            //inner block 1
            try {
                int x = 9;
                int result = x / 0;
            }catch (ArithmeticException e) {
                System.out.println("divide by zero is prohibited");
            }

            //inner block 2
            try {
                String s = null;
                int result = s.length();
            }catch (NullPointerException e){
                System.out.println("cannot get length of a null object");
            }
        }catch(Exception e) {
            System.out.println("Exception caught in outer catch block");
        }finally {
            System.out.println("finally block is executed");
        }

        System.out.println("Normal flow of the program continues");
    }
}
