package com.samuelHCBproductservice.repository;

import com.samuelHCBproductservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface ProductRepository extends JpaRepository<Product, Long> {
}