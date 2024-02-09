import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        System.out.println("Total " + Customer.getTotal());
        while (true){
            System.out.println("Welcome to Electricity Bill Manager");
            System.out.println("1 .display meter info, 2. payBill , 3. exit");
            Scanner in = new Scanner(System.in);

            try {
                int choice = in.nextInt();
                if (choice == 1)
                    displayInfo(customer);
                else if (choice == 2) {
                    System.out.println("Enter amount" + " ");
                    int amount = in.nextInt();
                    pay(customer, amount);
                    System.out.println("perform another transaction? 1.Yes, 2. No");
                    int answer = in.nextInt();
                    if (answer == 1){
                        System.out.println("display total: " + Customer.getTotal());
                        System.out.println("Enter amount" + " ");
                        int a = in.nextInt();
                        pay(customer, a);

                    }
                }
                else if (choice == 3){
                    System.out.println("Bye");
                    break;
                }else {
                    System.out.println("invalid entry, try again");
                }

            }catch (RuntimeException e){
                System.err.println("Caught an exception: " + e.getMessage());
                break;  // Exit the loop when an exception is caught
            }
        }

    }

    public static void displayInfo(Customer customer){
        LocalDate date = LocalDate.now();
        System.out.println("Date:" + date + "\nAccount No: " + customer.getMeter_number() + "\nUsage(Kwh): " + customer.getUsage() +
                "\nCost(per Kwh): " + Customer.price_per_unit + "\nDiscount(per Kwh): " + customer.getDiscount()
        + "\nTotal charges: " + Customer.getTotal());

    }
    public static void pay(Customer customer, int amount){
        customer.payBill(amount);
        System.out.println("Arrears: "+ customer.getArrears() + "\nOverpaid: " + customer.getBillOverpaid());

    }

}