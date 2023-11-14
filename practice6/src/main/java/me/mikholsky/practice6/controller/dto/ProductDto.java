package me.mikholsky.practice6.controller.dto;

import lombok.*;
import me.mikholsky.practice6.entity.Product;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private int amount;
    private UserDto userDto;

    public static ProductDto from(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(BigDecimal.valueOf(product.getPrice()))
                .amount(product.getAmount())
                .userDto(UserDto.from(product.getUser()))
                .build();
    }
}
