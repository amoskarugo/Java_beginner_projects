package linkedList;

import java.util.LinkedList;

//How to remove 1st or last element from a linked list
//Remove first occurrence of a given element from a linked list
//How to clear linked list completely
public class RemoveElementFromLinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> fruits = new LinkedList<>();


        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");
        fruits.add("Orange");
        fruits.add("Pear");

        System.out.println("initial linked list: " + fruits);

        //remove first element from the list.
        String removeFirstFruit = fruits.removeFirst();
        System.out.println("after removing first fruit: " + fruits);

        //remove last element from the linked list
        String removeLastFruit = fruits.removeLast();
        System.out.println("after removing last fruit: " + fruits);

        //remove element from linked list
        fruits.remove("Orange");
        System.out.println(fruits);

    }
}
