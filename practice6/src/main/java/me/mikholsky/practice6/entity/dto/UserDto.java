package me.mikholsky.practice6.entity.dto;

import me.mikholsky.practice6.entity.User;

public class UserDto implements CommonDto {
    private Long id;

    private String name;

    private UserDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static UserDto from(User user) {
        return new UserDto(user.getId(), user.getName());
    }
}
