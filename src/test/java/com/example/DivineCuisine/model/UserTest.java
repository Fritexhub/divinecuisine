package com.example.DivineCuisine.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    void testUserBuilder() {
        User user = User.builder()
                .setFullname("Nwekori Friday")
                .setEmail("fenicrt@bolton.ac.uk")
                .setAddress("Thynne Street, Bolton")
                .setPassword("fenicrt@bolton.ac.uk")
                .build();
        assertEquals("Nwekori Friday", user.getFullname());
        assertEquals("fenicrt@bolton.ac.uk", user.getEmail());
        assertEquals("Thynne Street, Bolton", user.getAddress());
        assertEquals("fenicrt@bolton.ac.uk", user.getPassword());
    }
    @Test
    void testUserSettersAndGetters() {
        User user = new User();
        user.setFullname("Egede Friday");
        user.setEmail("egedefrio@gmail.com");
        user.setAddress("Bolton Street");
        user.setPassword("gedefrio1@gmail.com");
        assertEquals("Egede Friday", user.getFullname());
        assertEquals("egedefrio@gmail.com", user.getEmail());
        assertEquals("Bolton Street", user.getAddress());
        assertEquals("gedefrio1@gmail.com", user.getPassword());
    }
}