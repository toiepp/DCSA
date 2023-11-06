package me.mikholsky.practice6.controller.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
public class CartDto {
    @JsonProperty("content")
    private List<CartRowDto> cartRows;

    @JsonProperty("total")
    private double totalPrice;

    public static CartDto from(List<CartRowDto> cartRows) {
        return CartDto.builder()
                .cartRows(cartRows)
                .totalPrice(cartRows.stream()
                        .map(CartRowDto::getTotalPrice)
                        .reduce(0D, Double::sum))
                .build();

    }
}
