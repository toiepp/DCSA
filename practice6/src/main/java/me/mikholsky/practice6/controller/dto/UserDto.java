package me.mikholsky.practice6.controller.dto;

import lombok.*;
import me.mikholsky.practice6.entity.User;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private CartDto cartDto;

    public static UserDto from(User user) {
        var cartDto = CartDto.from(
                user.getCart().stream()
                        .map(CartRowDto::from)
                        .toList()
        );

        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .cartDto(cartDto)
                .build();
    }
}
