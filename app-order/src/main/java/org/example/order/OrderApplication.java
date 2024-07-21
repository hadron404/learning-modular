package org.example.order;

import org.example.rest.EnableServiceCommunication;
import org.example.rest.Order;
import org.example.rest.User;
import org.example.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableServiceCommunication
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@RestController
	public static class Controller {

		private final UserService userService;

		@Autowired
		public Controller(UserService userService) {
			this.userService = userService;
		}

		@GetMapping("/{id}")
		public ResponseEntity<Order> get(@PathVariable Long id) {
			User userInfo = userService.getUserById(new User.ID(id));
			return ResponseEntity.ok(new Order(new Order.ID(2L), "订单编号"));
		}
	}
}
