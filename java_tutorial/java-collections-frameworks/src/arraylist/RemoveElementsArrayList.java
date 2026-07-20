package arraylist;

import java.util.ArrayList;
import java.util.List;

//remove()
//removeAll()
//clear()
public class RemoveElementsArrayList {

    public static void main(String[] args) {
        //create arraylist object
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("cherry");
        fruits.add("lemon");
        fruits.add("grapes");
        fruits.add("pineapple");
        System.out.println(fruits);

        fruits.remove(4);
        System.out.println("after removing element at index 4: " + fruits);

        fruits.remove("grapes");
        System.out.println("after removing grapes at index 5 grapes: " + fruits);

        //remove all elements that exists in a given collection.
        List<String> subFruitsList = new ArrayList<>();
        subFruitsList.add("apple");
        subFruitsList.add("banana");

        fruits.removeAll(subFruitsList);

        System.out.println(fruits);
    }
}
