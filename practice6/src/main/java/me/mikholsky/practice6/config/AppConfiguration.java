package me.mikholsky.practice6.config;

import me.mikholsky.practice6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class AppConfiguration {
    private UserRepository userRepository;

    @Autowired
    public AppConfiguration setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
        return this;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return (username) ->
                userRepository
                        .findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("No such user with email " + username));
    }
}
