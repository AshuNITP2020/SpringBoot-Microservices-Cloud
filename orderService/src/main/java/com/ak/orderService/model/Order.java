package com.ak.orderService.model;

import lombok.*;
//import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

//@Document(value = "orders")
@Entity
@Table(name = "product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private Long id;
    private String orderNumber;
    private List<OrderLineItems> orderLineItems;

}
