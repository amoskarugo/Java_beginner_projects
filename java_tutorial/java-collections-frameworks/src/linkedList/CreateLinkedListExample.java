package linkedList;

import java.util.LinkedList;

// add()
//add(2, element)
//addFirst()
//addLast()
public class CreateLinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> fruits = new LinkedList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");
        fruits.add("Pear");
        fruits.add("Strawberry");

        System.out.println("initial linked list: " + fruits);

        //adding element at a specified position in the linked list
        fruits.add(2, "pineapple");
        System.out.println("after adding an element at position 2: " + fruits);

        //add element at the beginning of the linkedlist
        fruits.addFirst("mango");
        System.out.println("after adding mango: " +  fruits);

        fruits.addLast("grapes");
        System.out.println("after adding grapes: " +  fruits);


    }
}
