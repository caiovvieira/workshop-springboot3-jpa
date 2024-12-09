package com.myproject.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.course.entities.OrderItem;
import com.myproject.course.entities.PK.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}

