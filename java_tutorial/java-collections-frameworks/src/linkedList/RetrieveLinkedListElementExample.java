package linkedList;

import java.util.LinkedList;
//How to get the first element in the linked list.
//How to get the last element in the linked list.
//How to get an element at a given index in the linked list.
//How to get all element in a linked list.
public class RetrieveLinkedListElementExample {
    public static void main(String[] args) {

        LinkedList<String> fruits = new LinkedList<>();


        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        //getting the first element from the linked list using the getFirst() method.
        String firstFruit = fruits.getFirst();
        System.out.println("first element => " + firstFruit);

        //getting the last element from the linked list using the getLast() method.
        String lastFruit = fruits.getLast();
        System.out.println("last element => " + lastFruit);

        //get an element from a given index
        String element = fruits.get(1);
        System.out.println("element at index 1 => " + element);

        //getting all element from a linked list
        for (String fruit: fruits){
            System.out.println(fruit);
        }
    }
}
