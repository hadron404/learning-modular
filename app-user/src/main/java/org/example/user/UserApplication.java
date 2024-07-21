package org.example.user;

import org.example.rest.EnableServiceCommunication;
import org.example.rest.Order;
import org.example.rest.User;
import org.example.rest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableServiceCommunication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@RestController
	public static class Controller {

		private final OrderService orderService;

		@Autowired
		public Controller(OrderService orderService) {
			this.orderService = orderService;
		}

		@GetMapping("/{id}")
		public ResponseEntity<User> get(@PathVariable Long id) {
			Order order = orderService.getOrderById(new Order.ID(id));
			return ResponseEntity.ok(new User(new User.ID(1L), "周强"));
		}
	}
}
