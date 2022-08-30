package com.test.mshmatov.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class AverageSpeedStatDto {
    private RunDto run;
    private Long averageSpeed;
}
