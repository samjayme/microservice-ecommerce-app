package com.samuelHCB.inventoryservice.service;

import com.samuelHCB.inventoryservice.dto.InventoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {
    List<InventoryResponse>  isInStock (List<String> skuCode);
}
