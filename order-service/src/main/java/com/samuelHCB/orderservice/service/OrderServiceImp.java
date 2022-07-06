package com.samuelHCB.orderservice.service;

import com.samuelHCB.orderservice.dto.InventoryResponse;
import com.samuelHCB.orderservice.dto.OrderLineItemsDto;
import com.samuelHCB.orderservice.dto.OrderRequest;
import com.samuelHCB.orderservice.entity.OrderTable;
import com.samuelHCB.orderservice.entity.OrderLineItems;
import com.samuelHCB.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class OrderServiceImp implements OrderService{
    private final OrderRepository orderRepository;
    @Autowired
    private final WebClient.Builder webClientBuilder;
    @Override
    public void placeOder(OrderRequest orderRequest) {
        OrderTable orderTable = new OrderTable();
        orderTable.setOrderNumber(UUID.randomUUID().toString());

      List<OrderLineItems> orderLineItems = orderRequest.getOrderItems().stream()
                .map(this::mapToDto).toList();
      orderTable.setOrderLineItems(orderLineItems);


        List<String> skuCodes = orderTable.getOrderLineItems().stream()
                .map(OrderLineItems::getSkuCode
                ).toList();
        // Calling Inventory Service to check if products are in stock
        InventoryResponse[] inventoryResponses = webClientBuilder.build().get()
              .uri("http://inventory-service/api/inventory",
                      uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())// uri to get inventory status
                      .retrieve()// retrieve response from url
                              .bodyToMono(InventoryResponse[].class)// read data from client response and response type
             .block();

       boolean allProductsInStock =  Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);

     if (allProductsInStock) {
         orderRepository.save(orderTable);
     }else {
         throw new IllegalArgumentException("Product is not in stock");
     }


    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        return orderLineItems;
    }
}
