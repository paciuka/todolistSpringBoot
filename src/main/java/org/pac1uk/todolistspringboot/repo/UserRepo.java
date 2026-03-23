package org.pac1uk.todolistspringboot.repo;

import org.pac1uk.todolistspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}