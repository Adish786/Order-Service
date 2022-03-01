package com.common.retail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.common.retail.model.Order;
import com.common.retail.repository.OrderRepo;


@Service
public class OrderService {
	
		@Autowired
	    private OrderRepo repository;

	    public Order saveOrder(Order order) {
	        return repository.save(order);
	    }

	    public List<Order> saveOrders(List<Order> orders) {
	        return repository.saveAll(orders);
	    }

	    public List<Order> getOrders() {
	        return repository.findAll();
	    }

	    public Order getOrderById(int id) {
	        return repository.findById(id).orElse(null);
	    }

	    public Order getordertype(String name) {
	        return repository.findByordertype(name);
	    }

	    public String deleteOrder(int id) {
	        repository.deleteById(id);
	        return "Order removed !! " + id;
	    }

	    public Order updateOrder(Order order) {
	    	Order existingOrder = repository.findById(order.getId()).orElse(null);
	    	existingOrder.setId(order.getId());
	    	existingOrder.setOrdername(order.getOrdername());
	    	existingOrder.setOrdernumber(order.getOrdernumber());
	    	existingOrder.setOrdertype(order.getOrdertype());
	        return repository.save(existingOrder);
	    }


}
