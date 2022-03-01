package com.common.retail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.common.retail.model.Order;


@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {
	Order findByordertype(String ordertype); 
}
