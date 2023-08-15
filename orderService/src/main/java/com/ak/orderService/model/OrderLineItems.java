package com.ak.orderService.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.math.BigDecimal;

@Document(value = "orderLineItems")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItems {
    @Id
    private String id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
