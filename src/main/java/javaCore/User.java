package javaCore;

import lombok.Data;

import java.util.*;

@Data
public class User {
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String work;
    private String adress;

    public User(String name, int age, String work, String adress) {
        if (name.isBlank())
            throw new IllegalArgumentException("Enter your name");
        if (age < 18)
            throw new IllegalArgumentException("You are still young");
        if (!VALID_JOBS.contains(work))
            throw new IllegalArgumentException("Invalid workplace");
        if (!VALID_ADDRESSES.contains(adress))
            throw new IllegalArgumentException("Invalid address");

        this.name = name;
        this.age = age;
        this.work = work;
        this.adress = adress;
    }

    public static void main(String[] args) {
        User oneUser = new User("Alex", 25, "Google", "New York");
        User twoUser = new User("Anna", 21, "Uber", "Amsterdam");
        User threeUser = new User("Alex", 21, "Amazon", "London");
        List<User> userList = List.of(oneUser, twoUser, threeUser);
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

}