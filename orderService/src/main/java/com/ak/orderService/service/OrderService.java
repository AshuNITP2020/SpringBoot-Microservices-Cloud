package com.ak.orderService.service;

import com.ak.orderService.dto.OrderLineItemsdto;
import com.ak.orderService.dto.OrderRequest;
import com.ak.orderService.model.Order;
import com.ak.orderService.model.OrderLineItems;
import com.ak.orderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private  final OrderRepository orderRepository;

//    public OrderService(OrderRepository orderRepository) {
//        this.orderRepository = orderRepository;
//    }

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        System.out.println("service");

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsdtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItems(orderLineItems);
        orderRepository.save(order);

    }

    private OrderLineItems mapToDto(OrderLineItemsdto orderLineItemsdto) {
         return OrderLineItems.builder()
                 .id(orderLineItemsdto.getId())
                 .skuCode(orderLineItemsdto.getSkuCode())
                 .price(orderLineItemsdto.getPrice())
                 .quantity(orderLineItemsdto.getQuantity())
                 .build();
    }
}
