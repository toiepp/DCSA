package me.mikholsky.practice6.service;

import jakarta.transaction.Transactional;
import me.mikholsky.practice6.entity.User;
import me.mikholsky.practice6.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService extends AbstractService<User, UserRepository> {
    public UserService(UserRepository repository) {
        super(repository);
    }
}
