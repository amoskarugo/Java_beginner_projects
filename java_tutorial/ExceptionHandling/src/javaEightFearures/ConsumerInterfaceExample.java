package javaEightFearures;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaceExample {

    public static void main(String[] args) {

        //consumer functional interface example
        //accepts only one input performs an action on it and does not return anything
        //It can be used for modifying collections, logging data, printing data and performing side effects,
        Consumer<String>  consumer = (name ->
                System.out.println("Hello "+ name + "!")
                );

//        consumer.accept("amos");


        //methods of consumer 1. accept()
        //receives the object and passes it to the consumer for operation

        Consumer<List<Integer>> displayList = (list -> {
            list.forEach((element) ->
                    System.out.print(element + " "));
        });
        System.out.println();

            ArrayList<Integer> list = new ArrayList<>();
            list.add(78);
            list.add(0);
            list.add(26);
//            displayList.accept(list);


            //2. andThen() method
        //combining two consumer operations into a single consumer
        //current consumer executes first followed by consumer passed as an argument.

        Consumer<List<Integer>> modify = (list2 -> {
            list2.replaceAll(integer -> integer * 2);
        });

        modify.andThen(displayList).accept(list);
    }

}
