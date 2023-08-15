package com.ak.orderService.controller;

import com.ak.orderService.dto.OrderRequest;
import com.ak.orderService.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody  OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
        return "ordder placed successfully";
    }
}
