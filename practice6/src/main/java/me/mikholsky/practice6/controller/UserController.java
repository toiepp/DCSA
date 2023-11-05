package me.mikholsky.practice6.controller;

import me.mikholsky.practice6.entity.User;
import me.mikholsky.practice6.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController<User, UserService> {
    public UserController(UserService service) {
        super(service);
    }
}
