package example;

public class Box<T, U> {
    public T type;
    public U value;

    public Box(T type, U value) {
        this.type = type;
        this.value = value;
    }
    public T getItem() {
        return this.type;
    }

    public void setItem(T item) {
        this.type = item;
    }

    public U getValue() {

        return this.value;
    }
    public static <E> void displayItem(E item) {
        System.out.println("displaying item: " + item);
    }
}
