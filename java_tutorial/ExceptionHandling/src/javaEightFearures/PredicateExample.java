package javaEightFearures;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("amos", "admin"));
        users.add(new User("monjan", "member"));
        users.add(new User("Nicholas", "admin"));


        List<User> list = User.process(users, (User u) -> u.getRole().equals("admin"));
        System.out.println(list);


    }


}

class User {
    private final String name;
    private final String role;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }
    public String getName() {
        return name;
    }
    public String getRole(){
        return role;
    }

    public static List<User> process(ArrayList<User> users, Predicate<User> predicate) {
        ArrayList<User> filteredUsers = new ArrayList<>();
        for (User user : users) {
            if (predicate.test(user)) {
                filteredUsers.add(user);
            }
        }
        return filteredUsers;
    }
    public String toString(){
        return "[name: " + name + ", role: " + role +"]";
    }
}
