package com.mol.documents;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface DocumentRepository extends ReactiveMongoRepository<Recommendation, String> {
}
