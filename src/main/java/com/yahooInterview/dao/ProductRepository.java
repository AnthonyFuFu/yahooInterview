package com.yahooInterview.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yahooInterview.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
