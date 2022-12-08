package com.hk.aoc2022.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaloriesResumeDTO {
    private int mostCaloriesElfId;
    private int mostCalories;
    private int leastCaloriesElfId;
    private int leastCalories;
}
