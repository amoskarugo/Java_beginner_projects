package arraylist;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DifferentWaysToIterateOverAList {
    public static void main(String[] args) {
        List<String> courses = Arrays.asList("C", "C#", "C++", "Spring", "JavaScript");
        //Using basic for loop
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(courses.get(i));
        }
        //Using Enhanced for loop
        for (String course : courses) {
            System.out.println(course);
        }

        //basic loop with Iterator
        for(Iterator<String> iterator = courses.iterator(); iterator.hasNext();) {
            String course = (String) iterator.next();
            System.out.println(course);
        }
        //while loop using iterator
        Iterator<String> iterator = courses.iterator();
        while (iterator.hasNext()) {
            String course = (String) iterator.next();
            System.out.println(course);
        }

        //java 8 stream + lambda example

        courses.stream().forEach((course -> System.out.println(course)));
    }
}
