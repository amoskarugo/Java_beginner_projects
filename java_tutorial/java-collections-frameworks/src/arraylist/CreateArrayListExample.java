package arraylist;

import java.util.ArrayList;
import java.util.List;

//How to create an arraylist using ArrayList() constructor
//add elements using add() method
public class CreateArrayListExample {
    // it is a re-sizable array, also called dynamic array.
    //Grows in size to accommodate elements, shrinks in size if elements are removed.
    //Uses regular array to store elements, allows indexing of elements.
    //Ordered collection, maintains insertion order of the elements.
    //You cannot use primitive datatypes/
    //Not synchronized(not thread safe)

    public static void main(String[] args) {
        //created arraylist object
        List<String> cars = new ArrayList<>();
        cars.add("bmw cs f90");
        cars.add("audi_rsq8");
        cars.add("Mercedes gle 400d");
        System.out.println(cars);
    }


}
