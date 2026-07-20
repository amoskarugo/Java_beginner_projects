import example.Box;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Box.displayItem("amos");

        Box<String, String> box1 = new Box<>("WUX0Z_METALLIC", "76.6 USD");
        Box<String, Integer> box2 = new Box<>("SQR110Z_METALLIC", 47);

        System.out.println(box1.getItem());

        box2.setItem("PJER001_WOODEN");

//        System.out.println(box1.getItem());

        System.out.println(box2.getItem() + " -> " + box2.getValue() + " USD");


    }


}