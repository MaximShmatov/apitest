package com.test.mshmatov.dto;

import java.time.LocalDate;

public record UserDto(
        Integer id,
        String firstName,
        String lastName,
        LocalDate birthDate,
        String gender
) {}

//@Data
//public class UserDto {
//    private Integer id;
//    private String firstName;
//    private String lastName;
//    private LocalDate birthDate;
//    private String gender;
//}
