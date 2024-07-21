package org.example.rest.service;

import org.example.rest.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	private final OrderFeignClient orderFeignClient;

	@Autowired
	public OrderService(OrderFeignClient orderFeignClient) {
		this.orderFeignClient = orderFeignClient;
	}

	public Order getOrderById(Order.ID id) {
		return orderFeignClient.getOrderById(id.value());
	}
}
