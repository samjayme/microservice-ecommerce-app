package com.samuelHCB.orderservice.repository;

import com.samuelHCB.orderservice.entity.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderTable,Long> {
}
