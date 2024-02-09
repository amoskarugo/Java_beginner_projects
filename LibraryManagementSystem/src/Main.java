import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("Welcome to our library!");
        User user1 = new User("karugoamos@gmail.com", "amos karugo", "admin", "1234567");
        String[][] books = {{"To Kill a Mockingbird", "Harper Lee", "98"}, {"1984", "George Orwell", "326"},
                            {"The Great Gatsby", "F.Scott Fitzgerald", "201"}, {"The Catcher in the Rye", "J.D. Salinger", "400"}
                            };
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Book> booksArrayList = new ArrayList<>();
        for (String[] book: books){
            Book newBook = new Book(book[0], book[1], Integer.parseInt(book[2]));
            booksArrayList.add(newBook);
        }
        users.add(user1);

        System.out.println("1. Login 2. Sign up");


        Scanner in = new Scanner(System.in);
        try {
            int choice = in.nextInt();
            switch (choice){
                case 1:
                    boolean successful_login = login(users);
                    if (successful_login)
                        System.out.println("Login successful");
                    else
                        System.out.println("log in fail");
                    break;
                case 2:
                    System.out.print("Account Registration \n email: ");
                    String user_email = in.nextLine();
                    System.out.print("Name: ");
                    String user_name = in.nextLine();
                    System.out.print("password: ");
                    String user_password = in.nextLine();
                    System.out.print("Confirm password: ");
                    String confirm_password = in.nextLine();

                    if (!user_password.equals(confirm_password))
                        throw new Exception("password mismatch");
                    else {
                        User newUser = registerUser(user_name, user_email, user_password);
                        users.add(newUser);
                        boolean x = login(users);
                        if (x)
                            System.out.println("logged in");
                    }
                    break;
                default:
                    break;

            }
        }catch (Exception e){
            System.out.println("Invalid choice");
        }









    }

    public static User getUser(ArrayList<User> users, String email){
        for (User user: users){
            if (user.getEmail().equals(email))
                return user;
        }

        return null;
    }

    public static User registerUser(String name, String email, String password){
        try {
            return new User(name, email, "student", password);

        }catch (Exception e){
            System.out.println("something went wrong try again");
        }
        return null;
    }

    public static boolean login(ArrayList<User> users){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email =  in.nextLine().trim();
        System.out.println("Enter your password: ");
        String password = in.nextLine();
        Login login = new Login(email, password);
        User loginUser = getUser(users, email);

        try {
            if (loginUser == null)
                throw new Exception("email does not exist");
            else return login.login(loginUser);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return false;
    }
}