
//simplifies data processing using a functional programming approach.
//supports operations like filtering, mapping, reducing, sorting and collecting elements.
//does not store, it only processes it.
// Internal working of a stream via a three-step operation
 /*- create a stream -
 create stream from collection, file or other data source


 perform intermediate operations :-
 Transform or filter data using operations suc as:- filter, map, sorted
 These operations are lazy meaning they are not immediately executed


  - perform terminal operations
  Triggers the execution of a pipeline and produces the final result.
  - forEach()
  - count()
  -collect
  */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        //CREATION OF A STREAM
        // using a collection
        List<String> list = Arrays.asList("java", "docker", "kafka", "microservices");
        Stream<String> stream1 = list.stream();

        //from an array
        String[] array = {"java", "docker", "kafka", "microservices"};
        Stream<String> stream2 = Arrays.stream(array);

        //using stream.of()
        Stream<Integer> stream3 = Stream.of(1, 2, 3);

        // 4. Infinite Stream (limit to avoid infinite loop)
        Stream<Integer> stream4 = Stream.iterate(1, n -> n + 1).limit(5);
//        stream4.forEach(System.out::println);

        /* STREAM PIPELINE
        * - A stream pipeline is a sequence of operations performed on a stream to process data efficiently
        * - processes data in a streamlined manner
        *
        *
        * STREAM PIPELINE DATA FLOWS IN DIFFERENT STAGES
        * 1. SOURCE
        * 2. INTERMEDIATE OPERATIONS
        * filter(): Filters elements based on a specified condition.
            - map(): Transforms each element in a stream to another value.
            - Sorted(): Sorts the elements of a stream.
            - Distinct(): Remove duplicates.
         -   Skip(): Skip first n elements.
        * */

        List<Integer> numbers = Arrays.asList(70, 22, 33, 90, 70, 124, 11, 13, 22);

        numbers.stream()
                .filter(n -> n > 20)
                .map(n -> n * 2)
                .distinct()
                .sorted().forEach(System.out::println);

        //TERMINAL OPERATIONS
        /*
        Terminal Operations are the operations that on execution return a final result as an absolute value.

            ForEach(): It iterates all the elements in a stream.
            collect(Collectors.toList()): It collects stream elements into a list (or other collections like set/map).
            Reduce(): It reduces stream elements into a single aggregated result.
            count(): It returns the total number of elements in a stream.
            anyMatch() / allMatch() / noneMatch(): They check whether elements match a given condition.
            findFirst() / findAny(): They return the first or any element from a stream.

        * */

        List<String> names = Arrays.asList("Amit", "Riya", "Rohan", "Amit");

        // Collect into Set (removes duplicates)
        Set<String> uniqueNames = names.stream().collect(Collectors.toSet());
        System.out.println(uniqueNames);

        // Count names starting with 'R'
        long count = names.stream().filter(n -> n.startsWith("R")).count();
        System.out.println("Names starting with R: " + count);

        // Reduce (concatenate names)
        String result = names.stream().reduce("", (a, b) -> a + b + " ");
        System.out.println(result);
    }

}
