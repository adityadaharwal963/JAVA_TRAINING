package com.rcoem.zomato_demo.controller;

import com.rcoem.zomato_demo.dto.BillOrderDTO;
import com.rcoem.zomato_demo.dto.OrderDTO;
import com.rcoem.zomato_demo.services.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public BillOrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.addOrder(orderDTO);
    }

    @GetMapping("/all")
    public List<OrderDTO> getAllOrders(HttpSession session) {
        Long customer_id = (Long) session.getAttribute("user_id");
        return orderService.getOrders(customer_id);
    }

}
