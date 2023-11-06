package me.mikholsky.practice6.controller.dto;

import lombok.*;
import me.mikholsky.practice6.entity.CartRow;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class CartRowDto {
    private Long id;
    private String name;
    private double price;
    private int quantity;
    private double totalPrice;

    public static CartRowDto from(CartRow cartRow) {
        return CartRowDto.builder()
                .id(cartRow.getId().getProductId())
                .name(cartRow.getProduct().getName())
                .price(cartRow.getProduct().getPrice())
                .quantity(cartRow.getQuantity())
                .totalPrice(cartRow.getProduct().getPrice() * cartRow.getQuantity())
                .build();
    }
}

