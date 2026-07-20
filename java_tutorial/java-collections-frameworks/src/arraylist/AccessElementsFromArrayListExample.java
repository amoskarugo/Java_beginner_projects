package arraylist;

import java.util.ArrayList;
import java.util.List;

public class AccessElementsFromArrayListExample {

    public static void main(String[] args) {

        List<String> topFiveProgrammingLanguages = new ArrayList<>();

        //check if the list is empty
        System.out.println("Is the top five programming languages list Empty? "
                + topFiveProgrammingLanguages.isEmpty());

        topFiveProgrammingLanguages.add("Java");
        topFiveProgrammingLanguages.add("Python");
        topFiveProgrammingLanguages.add("C");
        topFiveProgrammingLanguages.add("C++");
        topFiveProgrammingLanguages.add("C#");

        //find the size of an arraylist

        System.out.println("Here are the top " + topFiveProgrammingLanguages.size()
                +  " programming languages in the world.");

        // Retrieve element at a given index
        System.out.println(topFiveProgrammingLanguages.get(0)
                + " is the best programming language.");

        //modify element at a given index
        topFiveProgrammingLanguages.set(1, "javascript");

        System.out.println(topFiveProgrammingLanguages);

    }
}
