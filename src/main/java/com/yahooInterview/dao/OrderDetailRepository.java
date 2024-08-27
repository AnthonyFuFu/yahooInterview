package com.yahooInterview.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yahooInterview.model.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}