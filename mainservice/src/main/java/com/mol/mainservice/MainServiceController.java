package com.mol.mainservice;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("main")
class MainServiceController {

    private UserClient userClient;
    private DocumentClient documentClient;

    MainServiceController(UserClient userClient, DocumentClient documentClient) {
        this.userClient = userClient;
        this.documentClient = documentClient;
    }

    @GetMapping("users")
    Flux<UserDTO> users() {
        return userClient.all();
    }

    @GetMapping("recommendations")
    Flux<DocumentDTO> documents() {
        return documentClient.all();
    }

    @PostMapping("users")
    Mono<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return userClient.create(userDTO);
    }

    @PostMapping("recommendations")
    Mono<DocumentDTO> createDocument(@RequestBody DocumentDTO documentDTO) {
        return documentClient.create(documentDTO);
    }


}
