import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {
    private String email;
    private String name;
    private String type;
    private String password;


    private ArrayList<Book> books;

    public User(String email, String name, String type, String password) {
        this.email = email;
        this.name = name;
        this.type = type;
        this.password = password;
        this.books = new ArrayList<Book>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Book book) {
        this.books.add(book);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
