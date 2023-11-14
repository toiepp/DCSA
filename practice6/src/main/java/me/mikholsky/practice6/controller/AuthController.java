package me.mikholsky.practice6.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import me.mikholsky.practice6.controller.dto.AuthenticationRequestDto;
import me.mikholsky.practice6.controller.dto.RegistrationRequestDto;
import me.mikholsky.practice6.controller.dto.TokenDto;
import me.mikholsky.practice6.controller.dto.UserDto;
import me.mikholsky.practice6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Value("${AUTH_SERVER_URL}")
    private String jwtAuthUrl;

    @Value("${COOKIE_MAX_AGE}")
    private int cookieMaxAge;

    private UserService userService;

    @Autowired
    public AuthController setUserService(UserService userService) {
        this.userService = userService;
        return this;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody RegistrationRequestDto requestDto) {
        var user = userService.register(requestDto);
        return ResponseEntity.ok(UserDto.from(user));
    }

    /* Requesting user principles and return JWT for authentication*/
    @GetMapping("/authentication")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequestDto requestDto,
                                          HttpServletResponse response) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<AuthenticationRequestDto> authRequestEntity = new HttpEntity<>(requestDto);

        ResponseEntity<TokenDto> tokenResponse = restTemplate.exchange(
                jwtAuthUrl + "/jwt/authenticate",
                HttpMethod.POST,
                authRequestEntity,
                TokenDto.class
        );

        if (tokenResponse.getBody() != null && tokenResponse.getStatusCode().isSameCodeAs(HttpStatus.OK)) {
            var cookie = new Cookie("jwt", tokenResponse.getBody().getToken());
            cookie.setPath("/");
            cookie.setMaxAge(cookieMaxAge);

            response.addCookie(cookie);
        }

        return ResponseEntity.status(response.getStatus()).build();
    }
}
