package com.mol.mainservice;

import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

import static io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType.COUNT_BASED;

@SpringBootApplication
public class MainserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainserviceApplication.class, args);
    }

    @Bean
    public CircuitBreakerConfigCustomizer externalServiceFooCircuitBreakerConfig() {
        return CircuitBreakerConfigCustomizer
                .of("recommendationService",
                        builder -> builder.slidingWindowSize(10)
                                .slidingWindowType(COUNT_BASED)
                                .waitDurationInOpenState(Duration.ofSeconds(5))
                                .minimumNumberOfCalls(5)
                                .failureRateThreshold(50.0f));
    }

}
