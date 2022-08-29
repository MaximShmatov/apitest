package com.test.mshmatov.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
@Validated
public class RunDto {

    @NotNull
    private Integer id;

    @NotNull
    private UserDto userDto;

    @NotNull
    private Float startLatitude;

    @NotNull
    private Float startLongitude;

    @NotBlank
    private String startDatetime;

    private Float finishLatitude;

    private Float finishLongitude;

    private String finishDatetime;

    private Integer distance;
}
