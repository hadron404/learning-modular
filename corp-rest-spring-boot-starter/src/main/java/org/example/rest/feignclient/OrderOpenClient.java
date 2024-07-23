package org.example.rest.feignclient;


import org.example.application.api.open.OrderOpenAPI;
import org.example.application.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "order-client")
public interface OrderOpenClient extends OrderOpenAPI {
	@GetMapping("/{id}")
	Order getOrderById(@PathVariable("id") Long ID);
}
