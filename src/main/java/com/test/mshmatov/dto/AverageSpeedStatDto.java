package com.test.mshmatov.dto;

import lombok.*;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@Builder
@Validated
public class AverageSpeedStatDto {
    private RunDto run;
    private Float averageSpeed;
}
