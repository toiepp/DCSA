package me.mikholsky.practice6.controller.dto;

import lombok.*;
import me.mikholsky.practice6.entity.User;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private CartDto cartDto;

    public static UserDto from(User user) {
        var cartDto = CartDto.from(
                user.getCart().stream()
                        .map(CartRowDto::from)
                        .toList()
        );

        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole().name())
                .cartDto(cartDto)
                .build();
    }
}
