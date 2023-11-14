package me.mikholsky.practice6.repository;

import me.mikholsky.practice6.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CommonRepository<User> {
    Optional<User> findByEmail(String email);
}
