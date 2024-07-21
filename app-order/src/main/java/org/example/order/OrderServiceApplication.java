package org.example.order;

import org.example.rest.EnableServiceCommunication;
import org.example.rest.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableServiceCommunication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@RestController
	public static class Controller {

		private final OrderService orderService;

		public Controller(OrderService orderService) {
			this.orderService = orderService;
		}

		@GetMapping("/{id}")
		public ResponseEntity<User> get(@PathVariable Long id) {
			return ResponseEntity.ok(orderService.getUserById(new User.ID(id)));
		}
	}
}
