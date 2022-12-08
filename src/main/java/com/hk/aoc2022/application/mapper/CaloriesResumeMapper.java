package com.hk.aoc2022.application.mapper;

import com.hk.aoc2022.application.model.CaloriesResume;
import com.hk.aoc2022.domain.model.CaloriesResumeDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CaloriesResumeMapper {
    CaloriesResume toCaloriesResume(CaloriesResumeDTO caloriesResumeDTO);
}
