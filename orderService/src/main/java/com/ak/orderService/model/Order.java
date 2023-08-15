package com.ak.orderService.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

@Document(value = "orders")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private String id;
    private String orderNumber;
    private List<OrderLineItems> orderLineItems;

}
