//package com.test.mshmatov.inttegration.services;
//
//import com.test.mshmatov.dto.UserDto;
//import com.test.mshmatov.inttegration.annotation.IT;
//import com.test.mshmatov.services.RunService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@IT
//@Slf4j
//@RequiredArgsConstructor
//public class RunServiceIT {
//    private static final Integer RUN_ID = 1;
//    private final RunService runService;
//
//    @Test
//    void findRunById() {
//        assertTrue(runService.findById(RUN_ID).isPresent());
//    }
//
//    @Test
//    void getAllUsers() {
//        assertEquals(runService.getAll().size(), 3);
//    }
//
//    @Test
//    void deleteUserById() {
//        assertTrue(runService.deleteById(RUN_ID));
//        assertFalse(runService.findById(RUN_ID).isPresent());
//    }
//
//    @Test
//    void updateUser() {
//        UserDto userDto = runService.findById(RUN_ID)
//                .map(user -> {
//                    user.setLastName("lastname");
//                    return runService.update(user).orElse(null);
//                })
//                .orElse(null);
//        assertNotNull(userDto);
//        assertEquals(userDto.getLastName(), "lastname");
//    }
//
//    @Test
//    void createUser() {
//        UserDto user = UserDto.builder()
//                .id(1)
//                .firstName("firstName")
//                .lastName("lastName")
//                .birthDate(LocalDate.now().toString())
//                .gender("W")
//                .build();
//        runService.create(user);
//        assertEquals(runService.getAll().size(), 4);
//    }
//}
