package com.example.demo.auth;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppUserRepository extends MongoRepository<AppUser, String> {
    AppUser findByUsername(String username);
}
