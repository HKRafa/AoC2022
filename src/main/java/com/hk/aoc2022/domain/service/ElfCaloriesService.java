package com.hk.aoc2022.domain.service;

import com.hk.aoc2022.domain.model.CaloriesResumeDTO;
import reactor.core.publisher.Mono;

public interface ElfCaloriesService {

    Mono<CaloriesResumeDTO> getCaloriesResume();
}
