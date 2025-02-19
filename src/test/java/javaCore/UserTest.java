package javaCore;



import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void ValidUserCreationTest(){
        User user = new User("Alex", 25, "Google", "New York");
        assertNotNull(user);
        assertEquals("Alex", user.getName());
        assertEquals(25, user.getAge());
        assertEquals("Google", user.getWork());
        assertEquals("New York", user.getAdress());
    }

    @Test
    void InvalidNameTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new User("", 25, "Google", "New York");
        });
        assertEquals("Enter your name", exception.getMessage());
    }

    @Test
    void InvalidAgeTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new User("Alex", 12, "Google", "New York");
        });
        assertEquals("Age must be greater than 18", exception.getMessage());
    }

    @Test
    void InvalidWorkTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new User("Alex", 25, "Microsoft", "New York");
        });
        assertEquals("Invalid workplace", exception.getMessage());
    }

    @Test
    void InvalidAddressTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new User("Alex", 25, "Google", "Paris");
        });
        assertEquals("Invalid address", exception.getMessage());
    }

    @Test
    void GroupUsersTest(){
        User oneUser = new User ("Alex", 25, "Google", "New York");
        User twoUser = new User ("Anna", 21, "Uber", "Amsterdam");
        User threeUser = new User ("Alex", 21, "Amazon", "London");
        List<User> userList = List.of(oneUser, twoUser, threeUser);

        Map<Integer, List<User>> groupedUser = User.groupUsers(userList);

        assertEquals(2, groupedUser.size());
        assertTrue(groupedUser.containsKey(21));
        assertTrue(groupedUser.containsKey(25));
        assertEquals(2, groupedUser.get(21).size());
        assertEquals(1, groupedUser.get(25).size());
    }
}
