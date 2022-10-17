package com.mol.documents;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("recommendations")
class DocumentsController {

    private DocumentRepository documentRepository;

    DocumentsController(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @GetMapping
    Flux<Recommendation> allRecommendation() {
        return documentRepository.findAll();
    }

    @PostMapping

    Mono<Recommendation> create(@NonNull @RequestBody Recommendation recommendation) {
        return documentRepository.save(recommendation);
    }
}
