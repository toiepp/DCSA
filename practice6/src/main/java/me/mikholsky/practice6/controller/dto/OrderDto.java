package me.mikholsky.practice6.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import me.mikholsky.practice6.entity.Order;
import me.mikholsky.practice6.entity.OrderRow;
import me.mikholsky.practice6.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class OrderDto {
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    @Setter
    private static class OrderProductsDto {
        private Long id;
        private String name;
        private double price;
        private int quantity;
        private double totalPrice;

        public static OrderProductsDto from(OrderRow orderRow) {
            return OrderProductsDto.builder()
                    .id(orderRow.getProduct().getId())
                    .name(orderRow.getProduct().getName())
                    .price(orderRow.getProduct().getPrice())
                    .quantity(orderRow.getQuantity())
                    .totalPrice(orderRow.getQuantity() * orderRow.getProduct().getPrice())
                    .build();
        }
    }

    private Long id;
    @JsonIgnoreProperties({"cartDto"})
    private UserDto user;
    private double total;
    @JsonProperty("content")
    private List<OrderProductsDto> orderRows;

    public static OrderDto from(User user, Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .user(UserDto.from(user))
                .orderRows(order.getProducts().stream()
                        .map(OrderProductsDto::from)
                        .collect(Collectors.toList()))
                .total(order.getProducts().stream()
                        .map(o -> o.getProduct().getPrice() * o.getQuantity())
                        .reduce(0D, Double::sum))
                .build();
    }
}
