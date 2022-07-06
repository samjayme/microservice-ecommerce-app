package com.samuelHCBproductservice.service;

import com.samuelHCBproductservice.dto.ProductRequest;
import com.samuelHCBproductservice.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    void addProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
