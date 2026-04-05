package com.rcoem.zomato_demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MenuItemDTO {
    private String name;
    private String description;
    private double price;
    private Long restaurant_id;
}
