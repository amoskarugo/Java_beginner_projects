package interfaces;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {


    public static void main(String[] args) {
        Collection<String> fruitCollection = new ArrayList<>();
        fruitCollection.add("banana");
        fruitCollection.add("apple");
        fruitCollection.add("mango");

        System.out.println(fruitCollection);

        fruitCollection.remove("apple");

        System.out.println(fruitCollection);


        fruitCollection.forEach(System.out::println);


        fruitCollection.clear();

        System.out.println(fruitCollection);


    }
}
