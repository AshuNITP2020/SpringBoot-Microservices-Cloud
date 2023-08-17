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
        System.out.println("controller");

        orderService.placeOrder(orderRequest);
        return "order placed successfully";
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getOrder(){
        return "GET ORDER";
    }
}
