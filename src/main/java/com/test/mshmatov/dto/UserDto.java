package com.test.mshmatov.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@Builder
public class UserDto {
    private static final String REGEXP = "(\\d{4}-\\d{2}-\\d{2})";

    @NotNull
    private Integer id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;


    @Pattern(regexp = REGEXP)
    private String birthDate;

    @NotBlank
    @Size(min = 1, max = 2)
    private String gender;

}

