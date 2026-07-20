import java.util.Locale;
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        String[] names = new String[10];
       // System.out.println(names[5]); Throws a NullPointerException
         /*
            Therefore, to avoid abnormal termination we use Optional class.
            so our program executes without crashing.
        */


        Optional<String> checkNull = Optional.ofNullable(names[0]);
        if (checkNull.isPresent()) {
            String name = names[0].toLowerCase();
            System.out.println(name);
        }else
            System.out.println("Name is null.");

        //CREATING OPTIONAL OBJECTS
        /*
        * Optional.empty() : returns and empty Optional
        * Optional.of(): Return an Optional containing the given non-null value.
        * */


        // using empty() and of()
        String[] str = new String[5];
        str[0] = "Amos";

        Optional<String> empty = Optional.empty();
        System.out.println(empty);

        Optional<String> value = Optional.of(str[0]);

        System.out.println(value);

        System.out.println(value.get());
        System.out.println(value.hashCode());
        System.out.println(value.isPresent());

    }
}
