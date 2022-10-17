package com.mol.mainservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType.COUNT_BASED;

@Service
class DocumentClient {

    private final WebClient client;

    private final DefaultRecommendation defaultRecommendation;

    DocumentClient(@Value("${document.service.url}") String url, DefaultRecommendation defaultRecommendation) {
        client = WebClient.builder()
                .baseUrl(url)
                .build();

        this.defaultRecommendation = defaultRecommendation;
    }

    @CircuitBreaker(name = "recommendationService", fallbackMethod = "defaultRecommendations")
    Flux<DocumentDTO> all() {
        return client
                .get()
                .retrieve()
                .bodyToFlux(DocumentDTO.class);
    }

    Mono<DocumentDTO> create(DocumentDTO documentDTO) {
        return client
                .post()
                .bodyValue(documentDTO)
                .retrieve()
                .bodyToMono(DocumentDTO.class);
    }

    private Flux<DocumentDTO> defaultRecommendations(Throwable ex) {
        return defaultRecommendation.defaultRecommendation();
    }

}
