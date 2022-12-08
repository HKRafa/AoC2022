package com.hk.aoc2022.config;

import com.hk.aoc2022.infrastructure.spi.InputRepository;
import com.hk.aoc2022.infrastructure.spi.implementation.InputRepositoryFileImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfrastructureConfig {
    @Bean
    public InputRepository fileInputRepository() {
        return new InputRepositoryFileImpl();
    }
}
