import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(1011070,
                3723183737282828L, 16.1d,
                38620.67d);

        Billing billing = new Billing();

        Scanner in = new Scanner(System.in);



        System.out.println("Welcome to your Electricity Billing Manager");
        System.out.println("Enter: 1 To check your bill, 2: to pay bill");

        int choice = in.nextInt();

        switch (choice){
            case 1:
                System.out.println("Meter Number: " + customer.getMeter_number() + "\n"
                        + "Units: " + customer.getUsage() + "Kwh \n" + "Total: ");
            case 2:
                System.out.println("Enter amount: " + " ");
                int amount = in.nextInt();
                System.out.println("Transaction successful");
            default:
                System.out.println("Select a valid choice");
        }
    }

}