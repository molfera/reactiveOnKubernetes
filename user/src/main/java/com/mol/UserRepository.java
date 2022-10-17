package com.mol;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserRepository extends ReactiveCrudRepository<User, Integer> {
}
