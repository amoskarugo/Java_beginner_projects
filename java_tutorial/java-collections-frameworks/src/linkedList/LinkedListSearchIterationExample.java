package linkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListSearchIterationExample {
    public static void main(String[] args) {
        LinkedList<String> progLangs = new LinkedList<String>();
        progLangs.add("C");
        progLangs.add("C++");
        progLangs.add("Core Java");
        progLangs.add("Java EE");
        progLangs.add("Spring Framework");
        progLangs.add("Core Java");
        progLangs.add("Hibernate Framework");

        //check if the list contains a particular element
        boolean elementFound = progLangs.contains("C");
        System.out.println("elementFound =>  " + elementFound);

        //find index of the first occurrence of an element

        int indexOf = progLangs.indexOf("C");
        System.out.println("indexOf C =>  " + indexOf);

        //find index of the last occurrence of an element

        int lastIndexOf = progLangs.lastIndexOf("Core Java");
        System.out.println("lastIndexOf =>  " + lastIndexOf);

        //iterator
        Iterator<String> iterator = progLangs.iterator();
        while (iterator.hasNext()) {
            String progLang = (String) iterator.next();
            System.out.println(progLang);
        }
        //for each

        progLangs.forEach((element) -> {
            System.out.println(element);
        });
        //advance for each loop

        for (String s: progLangs) {
            System.out.println(s);
        }
        //simple for loop

    }
}
