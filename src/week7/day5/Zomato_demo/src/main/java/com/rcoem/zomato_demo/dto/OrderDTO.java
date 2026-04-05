package com.rcoem.zomato_demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderDTO {
    private List<Long> menuIds;
    private Long customerId;
}
