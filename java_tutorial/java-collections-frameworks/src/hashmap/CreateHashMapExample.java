package hashmap;

import java.util.*;

public class CreateHashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> numberMapping = new HashMap<>();

        //add key value to map
        numberMapping.put("One", 1);
        numberMapping.put("Two", 2);
        numberMapping.put("Three", 3);
        numberMapping.put("Four", 4);
        numberMapping.put("Five", 5);
        numberMapping.put(null, 6);
        numberMapping.put(null, 7); // overwrites previous null value because duplicates are not allowed

        System.out.println(numberMapping);

        //check if hashmap is empty
        System.out.println(numberMapping.isEmpty());

        //find the size of hashmap
        System.out.println("size of the hashmap: " + numberMapping.size());

        //check if a key exist in the hashmap
        if (numberMapping.containsKey("One")) {
            System.out.println("Exists");
        }else  {
            System.out.println("Not exists");
        }

        //check if value exists in hashmap
        if (numberMapping.containsValue(8)) {
            System.out.println("Exists");
        }else  {
            System.out.println("Not exists");
        }

        //get value by key
        Integer v2 = numberMapping.get("Two");
        System.out.println("Two: " + v2);

        //how to remove keys from hashmap
        numberMapping.remove("Three");
        System.out.println(numberMapping);

        //get only keys from hashset
        Set<String> keys = numberMapping.keySet();
        System.out.println(keys);

        //retrieve only values
        Collection<Integer> values = numberMapping.values();
        System.out.println(values);


        //different ways to iterate over hashmap

        //simple for loop
//
//        for (Map.Entry<String, Integer> entry : numberMapping.entrySet()) {
//            System.out.println("key -> " + entry.getKey() + "," + " value -> " + entry.getValue());
//        }
//
        //using iterator

//        Set<Map.Entry<String, Integer>> entrySet = numberMapping.entrySet();
//        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<String, Integer> entry = iterator.next();
//            System.out.println("key -> " + entry.getKey() + "," + " value -> " + entry.getValue());
//        }

        //using java 8 for each
        numberMapping.forEach((K, V) -> {
            System.out.println("key -> " + K + " value ->" + V);
        });

    }
}
