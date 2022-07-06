package com.samuelHCB.orderservice.service;

import com.samuelHCB.orderservice.dto.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    void placeOder(OrderRequest orderRequest);
}
