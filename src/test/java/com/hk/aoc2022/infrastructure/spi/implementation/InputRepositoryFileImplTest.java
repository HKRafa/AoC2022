package com.hk.aoc2022.infrastructure.spi.implementation;

import com.hk.aoc2022.infrastructure.spi.InputRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebFluxTest
@ExtendWith(SpringExtension.class)
public class InputRepositoryFileImplTest {

    @Autowired
    private InputRepository fileInputRepository;


    @Test
    void dayOneTest() throws IOException {
        Map<Integer, List<Integer>> dayOneExpectedInput = Map.of(1, List.of(1000, 2000, 3000), 2, List.of(4000), 3, List.of(5000, 6000), 4, List.of(7000, 8000, 9000), 5, List.of(10000));

        StepVerifier
                .create(fileInputRepository.getDayOneInput())
                .assertNext(p -> assertEquals(p, dayOneExpectedInput))
                .verifyComplete();
    }

}
