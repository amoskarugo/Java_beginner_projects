package Basic_java;

public class Operators {


    /*
    * Arithmetic operators
    * Used to perform arithmetic operations on primitive data types
    * / Division
    * + Addition
    * - Subtraction
    * % modulo
    * Multiplication
    * */
    int x =  0;
    public void arithmeticOperators(){
        int a = 10;
        int b = 3;

        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));
    }

    /*
    * Unary operators need only one operand. They are used to increment, decrement, or negate a value.
    * + indicates positive value & - indicates negative value
    * ++ post-increment(value incremented after use)  -- post-decrement(value decremented after use)
    * and vice-versa for pre increment and post decrement
    * */

    public void unaryOperators(){
        // Interger declared
        int a = 10;
        int b = 10;

        // Using unary operators
        System.out.println("Postincrement : " + (a++));
        System.out.println("Preincrement : " + (++a));

        System.out.println("Postdecrement : " + (b--));
        System.out.println("Predecrement : " + (--b));
    }


    // Assignment Operator

    public void assignmentOperator(){
        // Assignment operators
        int f = 7;
        System.out.println("f += 3: " + (f += 3));
        System.out.println("f -= 2: " + (f -= 2));
        System.out.println("f *= 4: " + (f *= 4));
        System.out.println("f /= 3: " + (f /= 3));
        System.out.println("f %= 2: " + (f %= 2));
        System.out.println("f &= 0b1010: " + (f &= 0b1010));
        System.out.println("f |= 0b1100: " + (f |= 0b1100));
        System.out.println("f ^= 0b1010: " + (f ^= 0b1010));
        System.out.println("f <<= 2: " + (f <<= 2));
        System.out.println("f >>= 1: " + (f >>= 1));
        System.out.println("f >>>= 1: " + (f >>>= 1));

    }

    //Relational Operators
    public void relationshipOperators(){
        // Comparison operators
        int a = 10;
        int b = 3;
        int c = 5;

        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));
        System.out.println("a == c: " + (a == c));
        System.out.println("a != c: " + (a != c));
    }

    //Logical Operators
    /*
    * &&, Logical AND: returns true when both conditions are true.
        ||, Logical OR: returns true if at least one condition is true.
       !, Logical NOT: returns true when a condition is false and vice-versa
    * */

    public void logicalOperators(){
        boolean x = true;
        boolean y = false;

        System.out.println("x && y: " + (x && y));
        System.out.println("x || y: " + (x || y));
        System.out.println("!x: " + (!x));
    }

    public void print(){
        int x = 10;

        System.out.println(this.x);
    }
}
