package org.example.rest.service;


import org.example.rest.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "order-service")
public interface OrderFeignClient {
	@GetMapping("/{id}")
	Order getOrderById(@PathVariable("id") Long ID);
}
