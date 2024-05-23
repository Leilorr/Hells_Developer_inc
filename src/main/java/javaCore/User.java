package javaCore;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class User {
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("Londo", "New York", "Amsterdam");

    private String name;
    private int age;
    private String work;
    private String adress;

    public static void main(String[] args) {
        User oneuser = new User("Alex", 17, "Pizza Driver", "USA");
        User twouser = new User("Anna", 21, "Chef", "Cannada");
        User threeuser = new User("Alex", 17, "Driver", "USA");
        List<User> userList = List.of(oneuser, twouser, threeuser);
        System.out.println(groupUsers(userList));
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {

        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : userList) {
            int age = user.getAge();
            groupedUsers.putIfAbsent(age, new ArrayList<>());
            groupedUsers.get(age).add(user);
        }
        return groupedUsers;
    }

    public User(String name, int age, String work, String adress) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Enter your name");
    }
}