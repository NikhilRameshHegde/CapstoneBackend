package com.communityapp.notification.auth.repository;

import com.communityapp.notification.auth.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
