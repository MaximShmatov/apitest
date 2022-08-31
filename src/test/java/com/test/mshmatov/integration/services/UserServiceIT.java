package com.test.mshmatov.integration.services;

import static org.junit.jupiter.api.Assertions.*;

import com.test.mshmatov.dto.UserDto;
import com.test.mshmatov.integration.annotation.IT;
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
        assertEquals(userService.getAll().size(), 4);
    }

    @Test
    void deleteUserById() {
        assertTrue(userService.deleteById(USER_ID));
        assertFalse(userService.findById(USER_ID).isPresent());
    }

    @Test
    void updateUser() {
        UserDto userDto = userService.findById(USER_ID)
                .map(user -> {
                    user.setLastName("lastname");
                    return userService.update(user).orElse(null);
                })
                .orElse(null);
        assertNotNull(userDto);
        assertEquals(userDto.getLastName(), "lastname");
    }

    @Test
    void createUser() {
        UserDto user = UserDto.builder()
                .id(1)
                .firstName("firstName")
                .lastName("lastName")
                .birthDate(LocalDate.now().toString())
                .gender("W")
                .build();
        userService.create(user);
        assertEquals(userService.getAll().size(), 5);
    }
}
