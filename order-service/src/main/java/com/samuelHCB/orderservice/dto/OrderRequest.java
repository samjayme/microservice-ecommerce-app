package com.samuelHCB.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class OrderRequest {
    private List<OrderLineItemsDto> orderItems;

    public OrderRequest() {
    }

    public OrderRequest(List<OrderLineItemsDto> orderItems) {
        this.orderItems = orderItems;
    }

    public List<OrderLineItemsDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderLineItemsDto> orderItems) {
        this.orderItems = orderItems;
    }
}
