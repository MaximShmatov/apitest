package com.test.mshmatov.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@Builder
public class RunDto {
    private static final String REGEXP = "(\\d{4}-\\d{2}-\\d{2})[A-Z]+(\\d{2}:\\d{2}:\\d{2}).([0-9+-:]+)";

    @NotNull
    private Integer id;

    @NotNull
    private UserDto userDto;

    @NotNull
    private Float startLatitude;

    @NotNull
    private Float startLongitude;

    @NotBlank
    @Pattern(regexp = REGEXP)
    private String startDatetime;

    private Float finishLatitude;

    private Float finishLongitude;

    @Pattern(regexp = REGEXP)
    private String finishDatetime;

    private Integer distance;
}
