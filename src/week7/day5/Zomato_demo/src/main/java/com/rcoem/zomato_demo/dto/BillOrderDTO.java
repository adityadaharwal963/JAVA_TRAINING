package com.rcoem.zomato_demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BillOrderDTO {
    private double total;
    private List<MenuItemDTO> items;
    private String customerName;
}
