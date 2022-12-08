package com.hk.aoc2022.domain.service.implementation;

import com.hk.aoc2022.domain.service.ElfCaloriesService;
import com.hk.aoc2022.infrastructure.spi.InputRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebFluxTest
@ExtendWith(SpringExtension.class)
public class ElfCaloriesServiceImplTest {
    @Autowired
    ElfCaloriesService elfCaloriesServiceImpl;

    @Mock(name = "inputRepositoryMock")
    private InputRepository inputRepositoryMock;

    @Test
    void dayOneTest() {
        Mockito
                .when(inputRepositoryMock.getDayOneInput())
                .thenReturn(Mono.just(Map.of(1, List.of(1000, 2000, 3000), 2, List.of(4000), 3, List.of(5000, 6000), 4, List.of(7000, 8000, 9000), 5, List.of(10000))));

        StepVerifier
                .create(elfCaloriesServiceImpl.getCaloriesResume())
                .assertNext(p -> {
                    assertEquals(p.getLeastCalories(), 4000);
                    assertEquals(p.getLeastCaloriesElfId(), 2);
                    assertEquals(p.getMostCalories(), 24000);
                    assertEquals(p.getMostCaloriesElfId(), 4);
                })
                .verifyComplete();
    }

}
