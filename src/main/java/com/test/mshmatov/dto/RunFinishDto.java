package com.test.mshmatov.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@Builder
@Validated
public class RunFinishDto {
    private static final String REGEXP = "(\\d{4}-\\d{2}-\\d{2})[A-Z]+(\\d{2}:\\d{2}:\\d{2}).([0-9+-:]+)";

    @NotNull
    private Integer userId;

    @NotNull
    private Integer runId;

    @NotNull
    private Float finishLatitude;

    @NotNull
    private Float finishLongitude;

    @Pattern(regexp = REGEXP)
    private String finishDatetime;

    private Integer distance;

}
