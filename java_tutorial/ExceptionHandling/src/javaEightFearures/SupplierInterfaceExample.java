package javaEightFearures;

import java.util.function.Supplier;

public class SupplierInterfaceExample {

    public static void main(String[] args) {

        //Supplier functional interface implementation
        //Does not accept any inputs but gives out a result/output
        //useful for lazy value generation and creation of objects
        //supports lambda methods and method references
        Supplier<String> message = () -> "Welcome to Java World";
        System.out.println(message.get());


        //object creation

        Supplier<StringBuilder> object = () -> new StringBuilder("Hello World");
        System.out.println(object.get());


    }
}
