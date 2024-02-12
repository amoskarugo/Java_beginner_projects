import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        System.out.println("Welcome to our library!");
        String[][] books = {{"To Kill a Mockingbird", "Harper Lee", "98"}, {"1984", "George Orwell", "326"},
                {"The Great Gatsby", "F.Scott Fitzgerald", "201"}, {"The Catcher in the Rye", "J.D. Salinger", "400"}
        };
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Book> booksCollection = new ArrayList<>();
        User user1 = new User("karugoamos@gmail.com", "amos karugo", "user", "1234567");
        for (String[] book : books) {
            Book newBook = new Book(book[0], book[1], Integer.parseInt(book[2]));
            booksCollection.add(newBook);
        }
        users.add(user1);

        System.out.println("1. Login 2. Sign up");


        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch (choice){
            case 1 -> {
                User user = login(users);
                if (user != null) {
                    if (user.getType().toLowerCase(Locale.ROOT).equals("admin")){
                        System.out.println();
                        listAllBooks(booksCollection);
                }
                        //admin functions
                    else {
                        //student functions
                        System.out.println("welcome to xyz library");
                        System.out.println("Books available");
                        //listAllBooks(booksCollection);
                        System.out.println();
                        //borrow_a_book(user, booksCollection);
                        //addBook(booksCollection);
                        //listAllBooks(booksCollection);
                        removeBook(booksCollection);
                    }
                }
            }
            case 2 ->{
                User newUser = registerUser();
                users.add(newUser);
                System.out.println("account created successfully");
                User user = login(users);
                if (user != null)
                    System.out.println("login successful");
            }
        }


    }

    public static User getUser(ArrayList<User> users, String email) {
        for (User user : users) {
            if (user.getEmail().equals(email))
                return user;
        }

        return null;
    }

    public static User registerUser() {
        Scanner in = new Scanner(System.in);
        String name, password, confirm_password, email;
        while (true) {

            System.out.println("Account registration!");
            System.out.print("Name: ");
            name = in.nextLine();
            if (name == null || name.isEmpty()) {
                System.out.print("name cannot be empty");
                continue;
            }
            System.out.print("Email: ");
            email = in.nextLine();
            if (email == null || email.isEmpty()) {
                System.out.println("email cannot be empty");
                continue;
            }
            System.out.print("Password, minimum 6 characters: ");
            password = in.nextLine();
            if (password == null || password.isEmpty()) {
                System.out.println("password cannot be empty");
                continue;
            }
            if (password.length() < 6) {
                System.out.println("password too short, enter at least six characters");
                continue;
            }
            System.out.print("confirm password: ");
            confirm_password = in.nextLine();
            if (!password.equals(confirm_password)) {
                System.out.println("password mismatch!");
                continue;

            }

            break;
        }
        return new User(email, name, "student", password);
    }
    public static User login(ArrayList<User> users){
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
            else if (!login.login(loginUser)) {
                throw new Exception("incorrect password");
            } else return loginUser;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static void borrow_a_book(User user, ArrayList<Book> books){
        listAllBooks(books);
        Scanner in = new Scanner(System.in);
        System.out.println("Borrow? Enter the number on list select the book you wish to borrow?");
        Book book;
        try {
            int select_book = in.nextInt();
            if (select_book > books.size())
                throw new Exception();
            book = books.get(select_book);
            LocalDate currentDate = LocalDate.now();
            LocalDate newDate = currentDate.plusDays(30);
            user.setBooks(book);
            System.out.println("You have borrowed " + book.getTitle() + "return due date " + newDate);
            System.out.println("To be charged $"  + 1.2 + " per day after return date deadline");

        } catch (Exception e){
            System.out.println("select a valid number");
        }



    }

    private static void listAllBooks(ArrayList<Book> books) {
        int index = 0;
        for (Book book: books){
            System.out.println(index++ + ". " + book.getTitle());
        }
    }

    public static void myBooks(User user){
        ArrayList<Book> books = user.getBooks();

        for (Book book: books)
            System.out.println(" ->" + book.getTitle());
    }

    public static void addBook(ArrayList<Book> books){
        System.out.println("enter the book's details");
        Scanner in = new Scanner(System.in);
        String title, author;
        int pages;

        while (true){
          try {
              System.out.print("Title: ");
              title = in.nextLine();
              if (title.isEmpty())
              {
                  System.out.println("title cannot be empty");
                  continue;
              }
              System.out.print("Author: ");
              author = in.nextLine();
              if (author.isEmpty()){
                  System.out.println("author cannot be empty");
                  continue;
              }
              System.out.print("Pages: ");
              pages= in.nextInt();

              Book newBook = new Book(title, author, pages);
              books.add(newBook);
              System.out.println("book added successfully");
              break;

          } catch (Exception e) {
              System.out.println(e.getMessage());
          }
        }
     }

     public static void removeBook(ArrayList<Book> books){
        listAllBooks(books);
         System.out.print("Choose a book to remove");
         Scanner in = new Scanner(System.in);

         int selected = in.nextInt();
         if (selected > books.size()){
             System.out.println("book not found, try again");
             removeBook(books);
         }else {
             books.remove(selected);
             System.out.println("\n book removed successfully");
             listAllBooks(books);
         }
     }
}