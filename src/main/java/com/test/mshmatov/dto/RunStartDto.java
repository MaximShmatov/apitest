package com.test.mshmatov.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@Builder
public class RunStartDto {
    private static final String REGEXP = "(\\d{4}-\\d{2}-\\d{2})[A-Z]+(\\d{2}:\\d{2}:\\d{2}).([0-9+-:]+)";

    @NotNull
    private Integer userId;

    @NotNull
    private Float startLatitude;

    @NotNull
    private Float startLongitude;

    @Pattern(regexp = REGEXP)
    private String startDatetime;

}
