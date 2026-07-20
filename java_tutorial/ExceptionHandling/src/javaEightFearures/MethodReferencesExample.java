package javaEightFearures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class MethodReferencesExample {

    public MethodReferencesExample() {
        System.out.println("MethodReferencesExample constructor invoked.");
    }
    static void print(String string){
        System.out.println(string);
    }
    public int square(int x){
        return x * x;
    }
    public static void main(String[] args) {
        //There are four types of method references
        // 1. Reference to a static method
        String[] names = {"John", "Joe", "Jane"};
        Arrays.stream(names).forEach(MethodReferencesExample::print);


        // 2. Reference to an instance method of a particular object
        MethodReferencesExample example = new MethodReferencesExample();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
//        list.stream().map(example::square).forEach(System.out::println);

        //3. Reference to an Instance Method of an Arbitrary Object

        List<String> courses = Arrays.asList("java", "spring", "microservice");
        courses.stream().map(String::toUpperCase).forEach(System.out::println);


        //4. reference to a constructor
        Supplier<MethodReferencesExample> supplier = MethodReferencesExample::new;
        supplier.get();


    }
}
