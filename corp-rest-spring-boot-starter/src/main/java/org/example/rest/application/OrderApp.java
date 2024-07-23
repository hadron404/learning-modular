package org.example.rest.application;

import org.example.application.domain.Order;
import org.example.rest.feignclient.OrderOpenClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderApp {
	private final OrderOpenClient orderClient;

	@Autowired
	public OrderApp(OrderOpenClient orderClient) {
		this.orderClient = orderClient;
	}

	public Order getOrderById(Order.ID id) {
		return orderClient.getOrderById(id.value());
	}
}
