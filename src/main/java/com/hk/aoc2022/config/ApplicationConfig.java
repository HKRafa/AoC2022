package com.hk.aoc2022.config;

import com.hk.aoc2022.application.mapper.CaloriesResumeMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.hk.*")
public class ApplicationConfig {

    @Bean
    public CaloriesResumeMapper caloriesResumeMapper() {
        return Mappers.getMapper(CaloriesResumeMapper.class);
    }
}
