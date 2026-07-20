package hashset;

import java.util.HashSet;
import java.util.Set;

public class CreateHashSetExample {
    public static void main(String[] args) {
        //create a hashset object using the hashset noArgsConstructor
        Set<String> programmingLanguages = new HashSet<String>();
        programmingLanguages.add("Java");
        programmingLanguages.add("C");
        programmingLanguages.add("C++");
        programmingLanguages.add("Python");
        programmingLanguages.add("PHP");
        programmingLanguages.add("C#");
        programmingLanguages.add("JavaScript");

        System.out.println(programmingLanguages);

        // add a duplicate element
        programmingLanguages.add("PHP");
        System.out.println(programmingLanguages);

    }
}
