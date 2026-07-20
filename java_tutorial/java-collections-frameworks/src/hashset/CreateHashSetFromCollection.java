package hashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateHashSetFromCollection {
    public static void main(String[] args) {
//        Set<Integer> firstFiveEvenNumbers = new HashSet<Integer>();
        List<Integer> firstFiveEvenNumbers = new ArrayList<Integer>();
        firstFiveEvenNumbers.add(2);
        firstFiveEvenNumbers.add(4);
        firstFiveEvenNumbers.add(6);
        firstFiveEvenNumbers.add(8);
        firstFiveEvenNumbers.add(10);

        Set<Integer> firstTenEvenNumbers = new HashSet<Integer>(firstFiveEvenNumbers);

//        System.out.println(firstTenEvenNumbers);

//        Set<Integer> nextFiveEvenNumbers = new HashSet<>();
        List<Integer> nextFiveEvenNumbers = new ArrayList<>();
        nextFiveEvenNumbers.add(12);
        nextFiveEvenNumbers.add(14);
        nextFiveEvenNumbers.add(16);
        nextFiveEvenNumbers.add(18);
        nextFiveEvenNumbers.add(20);

        firstTenEvenNumbers.addAll(nextFiveEvenNumbers);

        System.out.println(firstTenEvenNumbers);
    }
}
