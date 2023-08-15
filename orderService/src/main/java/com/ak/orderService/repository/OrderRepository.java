package com.ak.orderService.repository;

import com.ak.orderService.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface OrderRepository extends MongoRepository<Order,Long> {

}
