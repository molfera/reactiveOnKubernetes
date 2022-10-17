package com.mol;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("users")
class UserController {

    private UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    Flux<User> allUser() {
        return userRepository.findAll();
    }

    @PostMapping
    Mono<User> create(@NonNull @RequestBody User user) {
        return userRepository.save(user);
    }

}
