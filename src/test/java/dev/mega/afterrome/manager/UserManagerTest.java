package dev.mega.afterrome.manager;

import dev.mega.afterrome.user.User;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.mockito.Mockito.mock;

class UserManagerTest {

    @Test
    void testUsersList() {
        UserManager userManager = mock(UserManager.class);

        User user = User.of(UUID.randomUUID());
        userManager.addUser(user);

        System.out.println(userManager.getUsers());
    }
}