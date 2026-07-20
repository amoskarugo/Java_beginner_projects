package javaEightFearures;


import java.util.ArrayList;

public class LambdaExpressionExample

{
    public static void main(String[] args) {

        //lambda with multiple parameters
        Add add = (a, b) -> a + b;

        System.out.println(add.addition(12, 5));

        //lambda with a single parameter
        FuncInterface funcInterface = (x ->
        System.out.println("product " + (x * 2)));

        funcInterface.abstractFunMultiplyByTwo(9);

        //lambda without a parameter
        printOnScreen printOnScreen = () ->
                System.out.println("print on screen");


        printOnScreen.display();

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);

//        System.out.println("print even numbers");
//        numbers.forEach(n -> {
//            if (n % 2 == 0)
//                System.out.println(n);
//        });

        numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .forEach(System.out::println);

    }

}

@FunctionalInterface
interface Add{
    abstract int addition(int a, int b);
    default void sayHello(){
        System.out.println("Hello World");
    }
}

@FunctionalInterface
interface FuncInterface{
    abstract void abstractFunMultiplyByTwo(int b);
}

interface printOnScreen{
    void display();
}