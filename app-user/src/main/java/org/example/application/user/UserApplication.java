package org.example.application.user;

import org.example.application.api.open.UserOpenAPI;
import org.example.application.domain.User;
import org.example.rest.EnableApplicationCommunication;
import org.example.rest.application.OrderApp;
import org.example.web.EnableWebResponseAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableApplicationCommunication
@EnableWebResponseAdvice
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@RestController
	public static class Controller implements UserOpenAPI {

		private final OrderApp orderApp;

		@Autowired
		public Controller(OrderApp orderApp) {
			this.orderApp = orderApp;
		}

		@Override
		@GetMapping("/{id}")
		public User getUserById(@PathVariable Long id) {
			return new User(new User.ID(1L), "周强");
		}
	}
}
