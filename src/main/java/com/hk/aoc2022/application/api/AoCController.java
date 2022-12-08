package com.hk.aoc2022.application.api;

import com.hk.aoc2022.application.mapper.CaloriesResumeMapper;
import com.hk.aoc2022.application.model.CaloriesResume;
import com.hk.aoc2022.domain.service.ElfCaloriesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("/aoc2022")
@Slf4j
public class AoCController {
    @Autowired
    private ElfCaloriesService elfCaloriesServiceImpl;

    @Autowired
    private CaloriesResumeMapper caloriesResumeMapper;

    @GetMapping("/day-1")
    public Mono<ResponseEntity<CaloriesResume>> getDayOne() {
        elfCaloriesServiceImpl.getCaloriesResume().subscribe(caloriesResumeDTO -> {
            log.debug(String.valueOf(caloriesResumeDTO.getLeastCalories()));
            log.debug(String.valueOf(caloriesResumeDTO.getMostCalories()));
            log.debug(String.valueOf(caloriesResumeDTO.getLeastCaloriesElfId()));
            log.debug(String.valueOf(caloriesResumeDTO.getMostCaloriesElfId()));
        });
        return  elfCaloriesServiceImpl.getCaloriesResume()
                .doOnError(throwable -> {
                    try {
                        throw throwable;
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(caloriesResumeMapper::toCaloriesResume)
                .map(e -> ResponseEntity.of(Optional.of(e)));
    }
}
