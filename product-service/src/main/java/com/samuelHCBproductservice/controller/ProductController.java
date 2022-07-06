package com.samuelHCBproductservice.controller;

import com.samuelHCBproductservice.dto.ProductRequest;
import com.samuelHCBproductservice.dto.ProductResponse;
import com.samuelHCBproductservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public  ResponseEntity<String> addProduct (@RequestBody ProductRequest productRequest){

        productService.addProduct(productRequest);
        return new ResponseEntity<>("Product is saved",HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
       return new ResponseEntity<>( productService.getAllProducts(),HttpStatus.FOUND);
    }
}
