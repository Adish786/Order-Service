package com.common.retail.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.common.retail.model.Order;
import com.common.retail.repository.OrderRepo;
import com.common.retail.service.OrderService;


@RestController
public class OrderController {
	@Autowired
    private OrderService service;
	@Autowired
	private OrderRepo orderRepo;

    @PostMapping("/addOrder")
    public Order addOrder(@RequestBody Order order) {
        return service.saveOrder(order);
    }

    @PostMapping("/addOrders")
    public List<Order> addOrders(@RequestBody List<Order> orders) {
        return service.saveOrders(orders);
    }

    @GetMapping("/orders")
    public List<Order> findAllOrders() {
        return service.getOrders();
    }

    @GetMapping("/orderById/{id}")
    public Order findOrderById(@PathVariable int id) {
        return service.getOrderById(id);
    }

    @GetMapping("/order/{name}")
    public Order findOrderType(@PathVariable String ordertype) {
        return service.getordertype(ordertype);
    }
/*
    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order) {
        return service.updateOrder(order);
    }
*/
    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable int id) {
        return service.deleteOrder(id);
    }
	
    @PutMapping("update/{id}")
     public ResponseEntity<Order> update(@PathVariable("id") int id, @RequestBody Order order) {
         Optional<Order> optionalProject = orderRepo.findById(id);
         if (optionalProject.isPresent()) {
        	 Order p = optionalProject.get();
             if (order.getOrdername() != null)
                 p.setOrdername(order.getOrdername());
             if (order.getOrdernumber() !=0)
                 p.setOrdernumber(order.getOrdernumber());
             if (order.getOrdertype() != null)
                 p.setOrdertype(order.getOrdertype());
             return new ResponseEntity<>(orderRepo.save(p), HttpStatus.OK);
         } else
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
}
