package com.hk.aoc2022;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hk.aoc2022")
public class AoC2022Application {

	public static void main(String[] args) {
		SpringApplication.run(AoC2022Application.class, args);
	}

}
