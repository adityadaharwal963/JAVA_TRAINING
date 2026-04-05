package com.rcoem.zomato_demo.services;

import com.rcoem.zomato_demo.dto.BillOrderDTO;
import com.rcoem.zomato_demo.dto.MenuItemDTO;
import com.rcoem.zomato_demo.dto.OrderDTO;
import com.rcoem.zomato_demo.entities.Customer;
import com.rcoem.zomato_demo.entities.MenuItem;
import com.rcoem.zomato_demo.entities.FoodOrder;
import com.rcoem.zomato_demo.exceptions.ResourceNotFoundException;
import com.rcoem.zomato_demo.repositories.CustomerRepository;
import com.rcoem.zomato_demo.repositories.MenuItemRepository;
import com.rcoem.zomato_demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MenuItemRepository menuItemRepository;

    public BillOrderDTO addOrder(OrderDTO orderDTO){
        Customer customer = customerRepository.findById(orderDTO.getCustomerId()).orElse(null);
        if(customer == null){
            throw new ResourceNotFoundException( "Customer not found");
        }
        List<MenuItemDTO> menuItemDTOS = new ArrayList<>();
        double total = 0.0;
        for(Long menu_id : orderDTO.getMenuIds()){
            MenuItem menuItem = menuItemRepository.findById(menu_id).orElse(null);
            if(menuItem == null){
                throw new ResourceNotFoundException( "Menu not found");
            }
            MenuItemDTO menuItemDTO = new MenuItemDTO();
            menuItemDTO.setName(menuItem.getName());
            menuItemDTO.setPrice(menuItem.getPrice());
            total = total + menuItem.getPrice();
            menuItemDTOS.add(menuItemDTO);
            menuItemDTOS.add(menuItemDTO);
        }
        BillOrderDTO billOrderDTO = new BillOrderDTO();
        billOrderDTO.setItems(menuItemDTOS);
        billOrderDTO.setTotal(total);
        billOrderDTO.setCustomerName(customer.getName());

        return billOrderDTO;
    }

    public List<OrderDTO> getOrders(Long customerId){
        Customer customer = customerRepository.findById(customerId).orElse(null);

        if(customer == null){
            throw new ResourceNotFoundException("Customer not found");
        }
        if(customer.getOrders() == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }

        List<FoodOrder> orders = customer.getOrders();
        List<OrderDTO> orderDTOs = new ArrayList<>();
        for (FoodOrder order : orders) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setMenuIds(order.getMenuItems().stream().map(MenuItem::getId).collect(ArrayList::new, ArrayList::add, ArrayList::addAll));
            orderDTOs.add(orderDTO);
        }
        return orderDTOs;
    }
}
