package org.example.application.user;

import org.example.rest.EnableApplicationCommunication;
import org.example.application.domain.Order;
import org.example.application.domain.User;
import org.example.rest.application.OrderApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableApplicationCommunication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@RestController
	public static class Controller {

		private final OrderApp orderApp;

		@Autowired
		public Controller(OrderApp orderApp) {
			this.orderApp = orderApp;
		}

		@GetMapping("/{id}")
		public ResponseEntity<User> get(@PathVariable Long id) {
			Order order = orderApp.getOrderById(new Order.ID(id));
			return ResponseEntity.ok(new User(new User.ID(1L), "周强"));
		}
	}
}
