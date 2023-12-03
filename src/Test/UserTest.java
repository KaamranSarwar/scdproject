package Test;

import Model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getUsername() {
        User user = new User("Kami", "1", "manager", "222", "abcd");
        assertEquals("abcd", user.getUsername());
    }
    @Test
    void setUsername() {
        User user = new User("Kami", "1", "manager", "222", "abcd");
        user.setUsername("hello");
        assertEquals("hello", user.getUsername());

    }

    @Test
    void getName() {
        User user = new User("Kami", "1", "manager", "222", "abcd");
        assertEquals("Kami", user.getName());

    }

    @Test
    void setName() {

        User user = new User("Kami", "1", "manager", "222", "abcd");
        user.setName("ahmad");
        assertEquals("ahmad", user.getName());
    }

    @Test
    void getId() {

        User user = new User("Kami", "1", "manager", "222", "abcd");
        assertEquals("1", user.getId());
    }

    @Test
    void setId() {

        User user = new User("Kami", "1", "manager", "222", "abcd");
        user.setId("4");
        assertEquals("4", user.getId());
    }

    @Test
    void getRole() {

        User user = new User("Kami", "1", "manager", "222", "abcd");
        assertEquals("manager", user.getRole());
    }

    @Test
    void setRole() {

        User user = new User("Kami", "1", "manager", "222", "abcd");
        user.setRole("sale assistant");
        assertEquals("sale assistant", user.getRole());
    }

    @Test
    void getPassword() {
        User user = new User("Kami", "1", "manager", "222", "abcd");
        assertEquals("222", user.getPassword());
    }

    @Test
    void setPassword() {
        User user = new User("Kami", "1", "manager", "222", "abcd");
        user.setPassword("123");
        assertEquals("123", user.getPassword());

    }
}