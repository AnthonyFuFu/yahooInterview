package com.yahooInterview.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yahooInterview.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
}