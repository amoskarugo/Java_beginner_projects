package arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortList {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(17);
//        list.add(118);
//        list.add(30);
//        list.add(56);
//        list.add(7);
//        list.add(90);
//
//        Collections.sort(list); //ascending order -> default
//        System.out.println(list);
//        Collections.reverse(list);// descending order.
//        System.out.println(list);

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1, 29, "amos", 500000));
        employees.add(new Employee(2, 39, "kariuki", 300000));
        employees.add(new Employee(3, 40, "Morris", 350000));
        employees.add(new Employee(4, 34, "monjan", 250000));

        Collections.sort(employees, new MySort());

        System.out.println(employees);
    }
}
class MySort implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o1.getSalary() - o2.getSalary());
    }
}