package org.tpokora.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tpokora.users.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
