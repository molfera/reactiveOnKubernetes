package com.mol.mainservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
class UserClient {

    private final WebClient client;

    UserClient(@Value("${user.service.url}") String url) {
        client = WebClient.builder()
                .baseUrl(url)
                .build();
    }

    Flux<UserDTO> all() {
        return client
                .get()
                .retrieve()
                .bodyToFlux(UserDTO.class);
    }

    Mono<UserDTO> create(UserDTO userDTO) {
        return client
                .post()
                .bodyValue(userDTO)
                .retrieve()
                .bodyToMono(UserDTO.class);
    }

}
