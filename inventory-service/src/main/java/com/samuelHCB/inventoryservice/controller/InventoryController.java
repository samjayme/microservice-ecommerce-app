package com.samuelHCB.inventoryservice.controller;

import com.samuelHCB.inventoryservice.dto.InventoryResponse;
import com.samuelHCB.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    public List<InventoryResponse>  isInStock (@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);

    }
}
