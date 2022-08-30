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
public class RunFinishDto {

    @NotNull
    private Integer userId;

    @NotNull
    private Integer runId;

    @NotNull
    private Float finishLatitude;

    @NotNull
    private Float finishLongitude;

    @NotBlank
    private String finishDatetime;

    private Integer distance;

}
