package com.test.mshmatov.inttegration.services;

import static org.junit.jupiter.api.Assertions.*;

import com.test.mshmatov.database.entities.GenderType;
import com.test.mshmatov.database.entities.UserEntity;
import com.test.mshmatov.inttegration.annotation.IT;
import com.test.mshmatov.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@IT
@Slf4j
@RequiredArgsConstructor
public class UserServiceIT {
    private static final Integer USER_ID = 1;
    private final UserService userService;

    @Test
    void findUserById() {
        assertTrue(userService.findById(USER_ID).isPresent());
    }

    @Test
    void getAllUsers() {
        assertEquals(userService.getAll().size(), 3);
    }

    @Test
    void deleteUserById() {
        assertEquals(userService.deleteById(USER_ID), USER_ID);
        assertFalse(userService.findById(USER_ID).isPresent());
    }

    @Test
    void updateUser() {
        var user = userService.findById(USER_ID)
                .map(u -> {
                    u.setLastName("lastname");
                    return userService.update(u);
                })
                .orElse(null);
        assertNotNull(user);
        assertEquals(user.getLastName(), "lastname");
    }

    @Test
    void createUser() {
        UserEntity user = UserEntity.builder()
                .firstName("firstName")
                .lastName("lastName")
                .birthDate(LocalDate.now())
                .gender(GenderType.W)
                .build();
        userService.create(user);
        assertEquals(userService.getAll().size(), 4);
    }
}
