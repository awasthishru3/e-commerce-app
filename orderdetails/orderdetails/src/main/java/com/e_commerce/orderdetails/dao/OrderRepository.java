package com.e_commerce.orderdetails.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_commerce.orderdetails.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
