package me.mikholsky.practice6.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.mikholsky.practice6.controller.dto.TokenDto;
import me.mikholsky.practice6.controller.dto.TokenVerificationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

@Component
public class OncePerRequestAuthFilter extends OncePerRequestFilter {
    @Value("${AUTH_SERVER_URL}")
    private String jwtAuthServerUrl;

    private UserDetailsService userDetailsService;

    @Autowired
    public OncePerRequestAuthFilter setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        return this;
    }

    /*
     * По идее должен принимать запрос
     * При каждом запросе он должен брать куки с JWT токеном
     * Потом проверить этот токен и на основе результата
     * сервера авторизации выдать ответ пользователю */
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            Stream.of(cookies)
                    .filter(cookie -> cookie.getName().equals("jwt"))
                    .findFirst()
                    .ifPresent(cookie -> {
                        RestTemplate restTemplate = new RestTemplate();

                        HttpEntity<TokenDto> tokenDtoHttpEntity = new HttpEntity<>(TokenDto.builder()
                                .token(cookie.getValue())
                                .build());

                        ResponseEntity<TokenVerificationDto> verificationResponse = restTemplate.exchange(
                                jwtAuthServerUrl + "/jwt/verify",
                                HttpMethod.POST,
                                tokenDtoHttpEntity,
                                TokenVerificationDto.class
                        );

                        if (verificationResponse.getStatusCode().equals(HttpStatus.OK)) {
                            String email = Objects.requireNonNull(verificationResponse.getBody()).getEmail();

                            var userDetails = userDetailsService.loadUserByUsername(email);

                            var authToken = new UsernamePasswordAuthenticationToken(
                                    userDetails,
                                    null,
                                    userDetails.getAuthorities()
                            );

                            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                            SecurityContextHolder.getContext().setAuthentication(authToken);
                        }
                    });
        }
        filterChain.doFilter(request, response);
    }
}
