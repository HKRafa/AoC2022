package com.hk.aoc2022.domain.service.implementation;

import com.hk.aoc2022.domain.model.CaloriesResumeDTO;
import com.hk.aoc2022.domain.service.ElfCaloriesService;
import com.hk.aoc2022.infrastructure.spi.InputRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class ElfCaloriesServiceImpl implements ElfCaloriesService {
    @Autowired
    InputRepository fileInputRepository;

    @Override
    public Mono<CaloriesResumeDTO> getCaloriesResume() {
        return fileInputRepository.getDayOneInput()
                .map(e -> {
                    final AtomicInteger[] maxElf = {new AtomicInteger(0)};
                    final AtomicInteger[] minElf = {new AtomicInteger(0)};
                    final AtomicInteger[] maxCalories = {new AtomicInteger(0)};
                    final AtomicInteger[] minCalories = {new AtomicInteger(Integer.MAX_VALUE)};
                    e.forEach((u, v) -> {
                        int caloriesCandidate = v.stream().mapToInt(Integer::intValue).sum();
                        if (caloriesCandidate > maxCalories[0].get()) {
                            maxCalories[0] = new AtomicInteger(caloriesCandidate);
                            maxElf[0] = new AtomicInteger(u);
                        }
                        if (caloriesCandidate < minCalories[0].get()) {
                            minCalories[0] = new AtomicInteger(caloriesCandidate);
                            minElf[0] = new AtomicInteger(u);
                        }
                    });
                    return new CaloriesResumeDTO(maxElf[0].get(), maxCalories[0].get(), minElf[0].get(), minCalories[0].get());
                })
                .doOnError(Mono::error);
    }
}
