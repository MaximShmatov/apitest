package com.test.mshmatov.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserStatDto {
    private Integer runsQuantity;
    private Long totalDistance;
    private Long averageSpeed;
}
