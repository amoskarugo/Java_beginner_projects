package interfaces;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {


    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        //allows duplicate elements
//        list.add("element1");
//        list.add("element1");
//        list.add("element2");
//        list.add("element2");



        // allow you to have 'null' elements
//
//        list.add(null);
//        list.add(null);
//        System.out.println(list);



        //maintains insertion order
        list.add("element1");
        list.add("element2");
        list.add("element3");
        list.add("element4");
        list.add("element0");
        list.add("element9");


        //access elements from the list

        System.out.println(list.get(0));

        System.out.println(list);

    }
}
