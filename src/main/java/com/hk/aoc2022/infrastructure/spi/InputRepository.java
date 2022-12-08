package com.hk.aoc2022.infrastructure.spi;

import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

public interface InputRepository {
    Mono<Map<Integer, List<Integer>>> getDayOneInput();
}
