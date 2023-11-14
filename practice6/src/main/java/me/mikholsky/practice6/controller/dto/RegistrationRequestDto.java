package me.mikholsky.practice6.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequestDto {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
}
