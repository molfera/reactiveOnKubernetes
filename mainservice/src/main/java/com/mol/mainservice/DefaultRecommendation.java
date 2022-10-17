package com.mol.mainservice;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
class DefaultRecommendation {

    Flux<DocumentDTO> defaultRecommendation() {
        System.out.println("Get default values");
        return Flux.range(0, 3)
                .map(i -> DocumentDTO.ofDescription("very interesting recommendation:" + i) );
    }

}
