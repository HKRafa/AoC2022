package com.hk.aoc2022.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaloriesResume implements Serializable {
    private int mostCaloriesElfId;
    private int mostCalories;
    private int leastCaloriesElfId;
    private int leastCalories;
}
