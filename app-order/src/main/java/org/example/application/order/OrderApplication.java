package org.example.application.order;

import org.example.application.api.open.OrderOpenAPI;
import org.example.application.domain.Order;
import org.example.application.domain.User;
import org.example.rest.EnableApplicationCommunication;
import org.example.rest.application.UserApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableApplicationCommunication
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@RestController
	public static class Controller implements OrderOpenAPI {

		private final UserApp userApp;

		@Autowired
		public Controller(UserApp userApp) {
			this.userApp = userApp;
		}

		@Override
		@GetMapping("/{id}")
		public Order getOrderById(@PathVariable Long id) {
			User userInfo = userApp.getUserById(new User.ID(id));
			return new Order(new Order.ID(2L), "订单编号");
		}
	}
}
