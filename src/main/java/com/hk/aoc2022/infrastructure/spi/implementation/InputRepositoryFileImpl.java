package com.hk.aoc2022.infrastructure.spi.implementation;

import com.hk.aoc2022.infrastructure.spi.InputRepository;
import com.hk.aoc2022.exception.DefaultException;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@NoArgsConstructor
@Data
@Slf4j
public class InputRepositoryFileImpl implements InputRepository {
    @Value("${input.day-one}")
    private String dayOneInput;

    @Override
    public Mono<Map<Integer, List<Integer>>> getDayOneInput() {
        Stream<String> lines = null;
        try {
            lines = Files.lines(Path.of(ClassLoader.getSystemResource(dayOneInput).toURI()));
        } catch (IOException | URISyntaxException e) {
            log.error(e.getMessage());
            return Mono.error(new DefaultException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e));
        }

        AtomicInteger i = new AtomicInteger(1);
        return Mono.just(lines
                .collect(Collectors
                        .toMap(s -> s.equals("") ? i.getAndIncrement() : i.get(), u -> List.of(u.equals("") ? 0 : Integer.valueOf(u)), (u, v) -> Stream.concat(u.stream(), v.stream()).filter(e -> !e.equals(0)).toList())));
    }
}
